package com.example.demo.services;

import com.example.demo.model.Catalogue;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.stereotype.Service;

@Service
public class CatalogueService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  void delierCategory(Catalogue catalogue){

    }
}
