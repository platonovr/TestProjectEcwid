package com.ecwid.project.service;


import com.ecwid.project.model.User;

import java.util.List;

/**
 * Created by Roman on 15.03.14.
 */
public interface UserService {
    public void addUser(User user);


    public User getUser(Long id);

    public void deleteUser(User user);

    public List<User> findAllUsers();


}
