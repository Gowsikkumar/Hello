package com.example.registerform.controller;

import com.example.registerform.model.User;
import com.example.registerform.service.UserService;

import jakarta.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    private UserService userservice;

    public UserController(UserService userservice) {
        this.userservice = userservice;
    }
    @GetMapping("/")
    public String userform(Model model)
    {
        model.addAttribute("user", new User());
        return "user-form";
    }
    @PostMapping("/next")
    public String nextform(@Valid @ModelAttribute("User")User user, BindingResult result, Model model)
    {
        if(result.hasErrors())
        {
            System.out.println("dfsghjberrroghbjnmk======================");
            return "user-form";
        }
        userservice.create(user);
        model.addAttribute("message","user successfully registered!");
        model.addAttribute("users",userservice.getAllUsers());
        return "success";
    }
    @GetMapping("/del/{id}")
    public String delete(@PathVariable("id") Long id, Model mod)
    {
        userservice.deleteById(id);
        mod.addAttribute("users",userservice.Read());
        return "success";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id")Long id, Model mod)
    {
        mod.addAttribute("users",userservice.getById(id).get());
        return "edit";
    }
    @PostMapping("/update/{id}")
    public  String  update(@PathVariable Long id,@ModelAttribute User user,Model mod)
    {
        userservice.create(user);
        mod.addAttribute("users",userservice.Read());
        return "success";
    }
}
