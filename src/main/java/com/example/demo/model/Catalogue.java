package com.example.demo.model;


import jakarta.persistence.*;

import java.util.List;

public class Catalogue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = false)
    private List<Category> categoryList;
}
