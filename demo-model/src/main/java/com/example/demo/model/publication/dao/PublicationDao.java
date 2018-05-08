package com.example.demo.model.publication.dao;

import com.avaje.ebean.Ebean;
import com.example.demo.model.base.dao.BaseDao;
import com.example.demo.model.publication.entity.Publication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublicationDao {

    @Autowired
    private BaseDao baseDao;

    public static Publication getPublicationByDOI(String doi) {
        return Ebean.find(Publication.class)
                .where()
                .eq("doi", doi)
                .findUnique();
    }
}
