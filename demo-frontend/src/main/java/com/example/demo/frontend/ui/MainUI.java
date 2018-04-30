package com.example.demo.frontend.ui;

import com.example.demo.backend.publication.DefaultPublicationService;
import com.example.demo.model.base.dao.BaseDao;
import com.example.demo.model.context.AppCtx;
import com.example.demo.model.profile.Profile;
import com.example.demo.model.profile.student.entity.Student;
import com.example.demo.model.publication.entity.Publication;
import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.*;

@Theme("valo")
public class MainUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        Button Candidate = new Button("I am looking for a position");
        Candidate.setWidth("90%");
        Candidate.setHeight("90%");
        Candidate.addClickListener(event -> candidateStart());
        Button PI = new Button("I am offering a position");
        PI.setWidth("90%");
        PI.setHeight("90%");
        PI.addClickListener(event -> piStart());
        GridLayout layout = new GridLayout(2,1);
        layout.setSizeFull();
        layout.addComponent(Candidate, 0, 0);
        layout.setComponentAlignment(Candidate, Alignment.MIDDLE_CENTER);
        layout.addComponent(PI, 1, 0);
        layout.setComponentAlignment(PI, Alignment.MIDDLE_CENTER);
        setContent(layout);
//      setContent(new Label(AppCtx.bean(DefaultPublicationService.class).getAuthorFromPublication().toString()));
    }

    private void candidateStart() {
        setContent(new Label("here we start a candidate enquiry"));
    }

    private void piStart() {
        VerticalLayout layout = new VerticalLayout();
        layout.setWidth("100%");
        TextField freeform = new TextField();
        freeform.setPlaceholder("example: postdoc in molecular biology");
        freeform.setWidth("80%");
        layout.addComponent(freeform);
        layout.setComponentAlignment(freeform, Alignment.TOP_CENTER);
        HorizontalLayout options = new HorizontalLayout();
        Button submit = new Button("Submit");
        submit.addClickListener(event -> freeQuery(freeform.getValue()));
        Button filter = new Button("Search by filters");
        filter.addClickListener(event -> startFilter());
        options.addComponent(submit);
        options.addComponent(filter);
        layout.addComponent(options);
        layout.setComponentAlignment(options, Alignment.TOP_CENTER);
        setContent(layout);
    }

    private void freeQuery(String input) {
        setContent(new Label(input + "needs to be sent to beckend for parsing"));
    }

    private void startFilter() {
        setContent(new Label("here we start a search"));
    }
}
