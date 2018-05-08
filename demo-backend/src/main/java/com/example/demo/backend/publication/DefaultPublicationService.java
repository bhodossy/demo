package com.example.demo.backend.publication;

import com.avaje.ebean.annotation.Transactional;
import com.example.demo.model.base.dao.BaseDao;
import com.example.demo.model.profile.Profile;
import com.example.demo.model.publication.dao.PublicationDao;
import com.example.demo.model.publication.entity.Publication;
//import com.google.web.bindery.requestfactory.shared.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultPublicationService implements PublicationService {

    @Autowired
    private BaseDao baseDao;

    @Override
    public List<Publication> getAllPublication() {
        return baseDao.findAll(Publication.class);
    }

    @Override
    public Publication getPublicationByDOI(String doi) {
        return null;
    }

    @Transactional
    public Profile getAuthorFromPublication() {
        //Publication publication = (Publication) baseDao.findAll(Publication.class).get(0);

        Profile author = (Profile) baseDao.findAll(Profile.class).get(0);

        return author;
    }

    @Override
    @Transactional
    public void register(String doi, String title, String abs, int year) throws PublicationException {
        if (PublicationDao.getPublicationByDOI(doi) != null) {
            throw new PublicationException("Error");
        } else {
            Publication newPub = new Publication(doi, title, abs, year);
        }
    }
}
