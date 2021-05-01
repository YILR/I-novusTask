package com.example.mimitest.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Cat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(unique = true)
    private String imageName;
    private Integer likes;

    public Cat() {
    }


}
