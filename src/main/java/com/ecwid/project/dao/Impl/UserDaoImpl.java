package com.ecwid.project.dao.Impl;

import com.ecwid.project.dao.UserDao;
import com.ecwid.project.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Roman on 15.03.14.
 */
@Repository
public class UserDaoImpl extends CRUDDaoImpl<User> implements UserDao {
    @Autowired
    public UserDaoImpl(SessionFactory sessionFactory) {
        super(User.class, sessionFactory);
    }
}
