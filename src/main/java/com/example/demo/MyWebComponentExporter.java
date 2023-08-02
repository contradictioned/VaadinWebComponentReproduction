package com.example.demo;

import com.vaadin.flow.component.WebComponentExporter;
import com.vaadin.flow.component.page.Push;
import com.vaadin.flow.component.webcomponent.WebComponent;

@Push
public class MyWebComponentExporter extends WebComponentExporter<MainView> {

    public MyWebComponentExporter() {
        super("my-web-component");
    }
    @Override
    protected void configureInstance(WebComponent<MainView> webComponent, MainView component) {

    }
}
