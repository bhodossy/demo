package com.example.demo.frontend.ui;

import com.example.demo.model.context.AppCtx;
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

    private GridLayout pubGrid = new GridLayout(2,1);

    private void candidateStart() {
        VerticalLayout candidateLayout = new VerticalLayout();
        candidateLayout.setDefaultComponentAlignment(Alignment.TOP_CENTER);
        candidateLayout.setWidth("100%");
        HorizontalLayout dates = new HorizontalLayout();
        dates.setWidth("300pt");

        DateField startDate = new DateField();
        DateField endDate = new DateField();

        TextField fNameField = new TextField("First Name");
        TextField lNameField = new TextField("Last Name");
        TextField keywordsField = new TextField("Fields of expertise");
        keywordsField.setPlaceholder("history, linear algebra");
        keywordsField.setWidth("300pt");
        Label datesLabel = new Label("Availability");
        Button addPublication = new Button("Add publication");
        addPublication.addClickListener(event -> pubPopUp());

        pubGrid.addComponent(new Label("Title"), 0, 0);
        pubGrid.addComponent(new Label("DOI"), 1, 0);
        pubGrid.setWidth("300pt");

        dates.addComponents(startDate, endDate);
        dates.setComponentAlignment(startDate, Alignment.TOP_LEFT);
        dates.setComponentAlignment(endDate, Alignment.TOP_RIGHT);
        candidateLayout.addComponents(fNameField, lNameField, keywordsField, datesLabel, dates, addPublication, pubGrid);
        setContent(candidateLayout);
    }

    private TextField title = new TextField("Title");
    private TextField doi = new TextField("DOI");
    private TextField year = new TextField("Year");
    private TextField keys = new TextField("Keywords");
    private TextField abs = new TextField("Abstract");
    private Window subWindow = new Window("Add publication");

    private void pubPopUp() {
        VerticalLayout subContent = new VerticalLayout();
        subWindow.center();

        HorizontalLayout options = new HorizontalLayout();
        Button save = new Button("Save");
        save.addClickListener(event -> addPub());
        Button cancel = new Button("Cancel");
        cancel.addClickListener(e -> subWindow.close());
        options.addComponents(save, cancel);

        subContent.addComponents(title, doi, year, keys, abs, options);
        subWindow.setContent(subContent);
        addWindow(subWindow);
    }

    private void addPub() {
        AppCtx.bean(PublicationControllerBean.class).register(doi.getValue(), title.getValue(), abs.getValue(), Integer.parseInt(year.getValue()));
        pubGrid.insertRow(1);
        pubGrid.addComponents(new Label(title.getValue()), new Label(doi.getValue()));
        subWindow.close();
    }

    private void piStart() {
        VerticalLayout layout = new VerticalLayout();
        layout.setWidth("100%");
        layout.setDefaultComponentAlignment(Alignment.TOP_CENTER);
        HorizontalLayout options = new HorizontalLayout();

        TextField freeform = new TextField();
        freeform.setPlaceholder("example: postdoc in molecular biology");
        freeform.setWidth("80%");
        Button submit = new Button("Submit");
        submit.addClickListener(event -> freeQuery(freeform.getValue()));
        Button filter = new Button("Search by filters");
        filter.addClickListener(event -> startFilter());

        options.addComponents(submit, filter);
        layout.addComponents(freeform, options);
        setContent(layout);
    }

    private void freeQuery(String input) {
        setContent(new Label(input + "needs to be sent to beckend for parsing"));
    }

    private void startFilter() {
        setContent(new Label("here we start a search"));
    }
}