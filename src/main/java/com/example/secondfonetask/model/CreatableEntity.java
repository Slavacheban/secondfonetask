package com.example.secondfonetask.model;

import com.example.secondfonetask.listener.UserCreatableListener;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDate;

@MappedSuperclass
@Setter
@Getter
@EntityListeners(value = UserCreatableListener.class)
public class CreatableEntity extends BaseEntity{
    @Column(name = "created_date")
    private LocalDate createdDate;
}
