package com.example.demo;

import com.vaadin.flow.component.WebComponentExporter;
import com.vaadin.flow.component.page.Push;
import com.vaadin.flow.component.webcomponent.WebComponent;

@Push
public class MyWebComponentExporter extends WebComponentExporter<MyWebComponent> {

    public MyWebComponentExporter() {
        super("my-web-component");
    }
    @Override
    protected void configureInstance(WebComponent<MyWebComponent> webComponent, MyWebComponent component) {

    }
}
