package com.example.demo.frontend.ui;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;

@Theme("valo")
public class MainUI extends UI {


    @Override
    protected void init(VaadinRequest vaadinRequest) {
        setContent(new Label("Hello World!"));
    }

}
