package com.example.demo.model.profile.student.dao;

import com.example.demo.model.base.dao.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentDao {

    @Autowired
    private BaseDao baseDao;
}
