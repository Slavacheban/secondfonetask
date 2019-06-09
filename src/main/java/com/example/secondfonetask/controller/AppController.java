package com.example.secondfonetask.controller;

import com.example.secondfonetask.model.User;
import com.example.secondfonetask.service.UserRepositoryService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AppController {
    private final UserRepositoryService service;

    @GetMapping
    public ModelAndView viewHomePage() {
        ModelAndView modelAndView = new ModelAndView("index");
        List<User> listUsers = service.getAll();
        modelAndView.addObject("listUsers", listUsers);
        return modelAndView;
    }
}
