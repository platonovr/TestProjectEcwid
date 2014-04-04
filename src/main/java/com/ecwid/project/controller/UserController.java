package com.ecwid.project.controller;

import com.ecwid.project.model.User;
import com.ecwid.project.service.UserService;
import com.ecwid.project.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Roman on 15.03.14.
 */
@Controller
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    UserService userService;


    @RequestMapping(value = "/userslist")
    public ModelAndView listOfTeams() {
        ModelAndView modelAndView = new ModelAndView("list-of-users");

        List<User> users = userService.findAllUsers();
        modelAndView.addObject("users", users);


        return modelAndView;
    }


}
