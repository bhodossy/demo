package com.example.demo.backend.publication;

import com.example.demo.model.publication.entity.Publication;

import java.util.List;

public interface PublicationService {

    List<Publication> getAllPublication();

    Publication getPublicationByDOI(String doi);

    void register(String doi, String title, String abs, int year) throws PublicationException;
}
