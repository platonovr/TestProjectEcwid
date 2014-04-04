package com.ecwid.project.dao;

import java.util.List;

/**
 * Created by Roman on 15.03.14.
 */
public interface CRUDDao<T> {
    public T save(T item);

    public T findById(Long id);

    public List<T> findAll() ;

    public void delete(T item) ;


}
