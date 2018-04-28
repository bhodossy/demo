package com.example.demo.frontend.ui;

import com.example.demo.backend.publication.DefaultPublicationService;
import com.example.demo.model.base.dao.BaseDao;
import com.example.demo.model.context.AppCtx;
import com.example.demo.model.profile.Profile;
import com.example.demo.model.profile.student.entity.Student;
import com.example.demo.model.publication.entity.Publication;
import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;

@Theme("valo")
public class MainUI extends UI {


    @Override
    protected void init(VaadinRequest vaadinRequest) {
        setContent(new Label(AppCtx.bean(DefaultPublicationService.class).getAuthorFromPublication().toString()));
    }

}
