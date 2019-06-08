package com.example.secondfonetask.listener;

import com.example.secondfonetask.model.CreatableEntity;

import javax.persistence.PrePersist;
import java.time.LocalDate;

public class UserCreatableListener {
    @PrePersist
    public void prePersist(CreatableEntity entity) {
        entity.setCreatedDate(LocalDate.now());
    }
}
