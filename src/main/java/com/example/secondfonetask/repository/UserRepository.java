package com.example.secondfonetask.repository;

import com.example.secondfonetask.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findAllByName(String name);
    @Query(value = "SELECT * FROM users " +
            "WHERE email IS NOT NULL " +
            "AND extract(MONTH FROM birthday) = :m " +
            "AND extract(DAY FROM birthday) = :d",
            nativeQuery = true)
    List<User> findByMatchMonthAndMatchDay(@Param("m") int month, @Param("d") int day);
}
