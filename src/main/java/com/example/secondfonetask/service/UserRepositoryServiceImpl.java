package com.example.secondfonetask.service;

import com.example.secondfonetask.model.User;
import com.example.secondfonetask.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRepositoryServiceImpl implements UserRepositoryService {
    private final UserRepository repository;

    @Autowired
    public UserRepositoryServiceImpl(UserRepository repository) {
        this.repository = repository;
    }
    @Override
    public List<User> getAll(int month, int day) {
        return repository.findByMatchMonthAndMatchDay(month,day);
    }

    @Override
    public List<User> getAll() {
        return repository.findAll();
    }
}
