# Testing WebComponents and @CssImport

In our app, it seems, these two features don't play along. Here is a fresh Vaadin Starter to test it.

## Case 1: Only @CssImport

The provided `vaadin-text-field-styles.css` got an easy to spot red background-color.
When running the app, it is there as intended.

# Case 2: WebComponentExporter plus @CssImport

Added `MyWebComponentExporter` and did `gradle vaadinClean` and `gradle bootRun`.
Now http://localhost:8080/web-component/my-web-component.js returns a fitting javascript.
Navigating to http://localhost:8080 yields a blank page and the following error in Chrome's browser console:

```
generated-flow-imports-fde68668.js:2284 Uncaught TypeError: Cannot set properties of undefined (setting 'button')
    at generated-flow-imports-fde68668.js:2284:400
```

Or to add confusion, in Firefox' browser console:

```
Uncaught TypeError: window.Vaadin.Flow is undefined
    <anonymous> http://localhost:8080/VAADIN/build/generated-flow-imports-fde68668.js:2284
```

# Case 3: Separating WebComponent Layout and "regular" Layout

We now copy the MainView to a MyWebComponent-class and use the latter for exporting as WebComponent.
After defensive `gradle vaadinClean` and `gradle bootRun`, still, http://localhost:8080/web-component/my-web-component.js works and  http://localhost:8080 does not.

When starting a webserver, e.g. using `python3 -m http.server` and visiting http://localhost:8000/ we confirm, that the web-component export of our app actually works (and has a red textfield).

# Case 4: Using Vaadin 23.3.16 instead

As our app is bound to the older Vaadin version due to other dependencies, let's test with Vaadin 23.
Here, everything works: http://localhost:8080/ shows the layout (with red text field) and http://localhost:8000/ shows the embedded variant (also with red text field).


# Vaadin Gradle Skeleton Starter Spring Boot

This project demos the possibility of having Vaadin project in npm+webpack mode using Gradle.
Please see the [Starting a Vaadin project using Gradle](https://vaadin.com/docs/latest/guide/start/gradle) for the documentation.


Prerequisites:
* Java 17 or higher
* node.js and npm. Vaadin Gradle plugin will install those for you
  automatically (handy for CI), or you can install it to your OS:
  * Windows: [node.js Download site](https://nodejs.org/en/download/) - use the .msi 64-bit installer
  * Linux: `sudo apt install npm`
* Git
* (Optionally): Intellij Community

## Vaadin Versions

* The [v14](https://github.com/vaadin/base-starter-spring-gradle) branch (the default one)
  contains the example app for Vaadin 14
* The [master](https://github.com/vaadin/base-starter-spring-gradle/tree/master) branch
  contains the example app for Vaadin 19

## Running With Spring Boot via Gradle In Development Mode

Run the following command in this repo:

```bash
./gradlew clean bootRun
```

Now you can open the [http://localhost:8080](http://localhost:8080) with your browser.

## Running With Spring Boot from your IDE In Development Mode

Run the following command in this repo, to create necessary Vaadin config files:

```bash
./gradlew clean vaadinPrepareFrontend
```

The `build/vaadin-generated/` folder will now contain proper configuration files.

Open the `DemoApplication` class, and Run/Debug its main method from your IDE.

Now you can open the [http://localhost:8080](http://localhost:8080) with your browser.

## Building In Production Mode

Run the following command in this repo:

```bash
./gradlew clean build -Pvaadin.productionMode
```

That will build this app in production mode as a runnable jar archive; please find the jar file in `build/libs/base-starter-spring-gradle*.jar`.
You can run the JAR file with:

```bash
cd build/libs/
java -jar base-starter-spring-gradle*.jar
```

Now you can open the [http://localhost:8080](http://localhost:8080) with your browser.

### Building In Production On CI

Usually the CI images will not have node.js+npm available. However, Vaadin Gradle Plugin will download it for you automatically, there is no need for you to do anything.
To build your app for production in CI, just run:

```bash
./gradlew clean build -Pvaadin.productionMode
```
