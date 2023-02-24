package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Controller
public class AuthenticationController {

    @Autowired
    UserService userService;

    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public String register(Model model)
    {
        model.addAttribute("user", new User());
        return "auth/register";
    }

    @RequestMapping(value = {"/register"}, method = RequestMethod.POST)
    public String registerUser(Model model, @Valid User user, BindingResult bindingResult)
    {
     if (bindingResult.hasErrors())
     {
         model.addAttribute("successMessage", "User registered successfully.");
         model.addAttribute("bindingResult", bindingResult);
         return "auth/register";
     }
        List<Object> presentUser = userService.doesUserExist(user);
        if ((Boolean)presentUser.get(0))
        {
            model.addAttribute("successMessage", presentUser.get(1));
            return "auth/register";
        }
        userService.saveUser(user);
        model.addAttribute("successMessage", "User registered successfully.");
        return "auth/login";
    }
}
