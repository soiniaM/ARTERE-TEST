package com.example.demo.services;

import com.example.demo.model.Catalogue;
import com.example.demo.model.Category;
import com.example.demo.model.Produit;
import com.example.demo.repository.CatalogueRepository;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CatalogueService {
private CatalogueRepository catalogueRepository;
@Autowired
    public CatalogueService(CatalogueRepository catalogueRepository) {
        this.catalogueRepository = catalogueRepository;
    }

    public  Catalogue delierCategoryFromCatalogue(Catalogue catalogue, Category category) {
        if (this.checkCategory(catalogue, category)) {
            catalogue.getCategoryList().remove(category);
            catalogueRepository.save(catalogue);
        }
        return catalogue;
    }

        public  Catalogue delierProduitFromCategorie(Catalogue catalogue, Produit produit) {
                if (!catalogue.getCategoryList().isEmpty()){
                    catalogue.getCategoryList()
                    .forEach(category -> {
                        if(category.getProduitsList().contains(produit)){
                            category.getProduitsList().remove(produit);
                        }
                    });
                }
                     return catalogue;
        }

private boolean checkCategory(Catalogue catalogue,Category category){
    return !catalogue.getCategoryList().isEmpty()&& catalogue.getCategoryList().contains(category);

    }
}
