package com.example.demo.repository;

import com.example.demo.model.Catalogue;
import com.example.demo.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatalogueRepository extends JpaRepository<Catalogue,Long> {
}
