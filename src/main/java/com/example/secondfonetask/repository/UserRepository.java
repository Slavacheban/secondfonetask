package com.example.secondfonetask.repository;

import com.example.secondfonetask.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findAllByName(String name);
    List<User> findAll();
}
