package com.ecwid.project.controller;

import com.ecwid.project.model.User;
import com.ecwid.project.service.UserService;
import com.ecwid.project.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;

@Controller
@RequestMapping("/registration")
@SessionAttributes(types = User.class)
public class RegistrationController {

    private final UserService userService;


    @Autowired
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }


    @Autowired
    private UserValidator userValidator;

    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(userValidator);
    }


    @RequestMapping(method = RequestMethod.GET)
    public String getRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String registration(@Valid User user, BindingResult result, SessionStatus status) {


        if (result.hasErrors()) {

            return "/registration";
        } else {
            this.userService.addUser(user);
            status.setComplete();
            return "redirect:/users/userslist/";
        }

    }


}




