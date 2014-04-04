package com.ecwid.project.service;

import com.ecwid.project.dao.UserDao;
import com.ecwid.project.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Roman on 15.03.14.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;


    @Override
    public void addUser(User user) {
        userDao.save(user);
    }


    @Override
    public User getUser(Long id) {
        return userDao.findById(id);
    }

    @Override
    public void deleteUser(User user) {
        userDao.delete(user);

    }

    @Override
    public List<User> findAllUsers() {
        return userDao.findAll();
    }


}
