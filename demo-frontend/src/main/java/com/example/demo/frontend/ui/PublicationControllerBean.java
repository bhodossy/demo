package com.example.demo.frontend.ui;

import com.example.demo.backend.publication.DefaultPublicationService;
import com.example.demo.model.context.AppCtx;
import com.example.demo.model.publication.entity.Publication;
import com.vaadin.ui.Notification;
import org.springframework.stereotype.Component;

@Component
public class PublicationControllerBean {
    public void register(String doi, String title, String abs, int year) {
        try {
            AppCtx.bean(DefaultPublicationService.class).register(doi, title, abs, year);
            Notification.show("Publication saved.");
        } catch (Exception e) {
            Notification.show("Error occurred", e.getMessage(), Notification.Type.WARNING_MESSAGE);
        }
    }
}
