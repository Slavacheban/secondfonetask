package com.example.secondfonetask.service;

import com.example.secondfonetask.model.User;

import java.util.List;

public interface UserRepositoryService {
    List<User> getAll(int month, int day);
}
