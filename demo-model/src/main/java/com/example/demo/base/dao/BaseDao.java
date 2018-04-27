package com.example.demo.base.dao;
import com.example.demo.base.entity.BaseEntity;
import io.ebean.Ebean;
import io.ebean.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class BaseDao {

    @Transactional
    public void save(BaseEntity baseEntity) {
        Ebean.save(baseEntity);
    }

    @Transactional
    public void delete(BaseEntity baseEntity) {
        Ebean.delete(baseEntity);
    }

    @Transactional
    public void update(BaseEntity baseEntity) {
        Ebean.update(baseEntity);
    }

    @Transactional
    public void saveAll(Collection<? extends BaseEntity> baseEntities) {
        Ebean.saveAll(baseEntities);
    }

    @Transactional
    public void deleteAll(Collection<? extends BaseEntity> baseEntities) {
        Ebean.deleteAll(baseEntities);
    }

    @Transactional
    public List findAll(Class clazz) {
        return Ebean.find(clazz).findList();
    }
}
