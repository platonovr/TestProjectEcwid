package com.ecwid.project.dao.Impl;

import com.ecwid.project.dao.CRUDDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by Roman on 15.03.14.
 */
public class CRUDDaoImpl<T> implements CRUDDao<T> {
    private Class<T> type;

    private SessionFactory sessionFactory;

    public CRUDDaoImpl(Class<T> type, SessionFactory sessionFactory) {
        this.type = type;
        this.sessionFactory = sessionFactory;
    }

    @Override
    public T findById(Long id) {
        return (T) getSession().get(type, id);
    }

    @Override
    public T save(T objectToSave) {
        getSession().saveOrUpdate(objectToSave);
        return objectToSave;
    }

    @Override
    public List<T> findAll() {
        return getSession().createCriteria(type).list();
    }

    @Override
    public void delete(T item) {
        getSession().delete(item);
    }

   /* @Override
    public T update(T item) throws SQLException {
        getSession().merge(item);
        return item;
    }*/

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }
}
