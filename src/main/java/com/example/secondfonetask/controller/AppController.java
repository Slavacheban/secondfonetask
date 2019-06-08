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

import java.util.List;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AppController {
    private final UserRepositoryService service;

    @GetMapping
    public String viewHomePage(Model model) {
        List<User> listUsers = service.getAll();
        model.addAttribute("listUsers", listUsers);
        return "index";
    }
}
