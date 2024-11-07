package com.example.demo.services;

import com.example.demo.model.Produit;
import com.example.demo.model.Produit;
import com.example.demo.repository.ProduitRepository;
import com.example.demo.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ProduitService {
    private ProduitRepository produitRepository;

    @Autowired
    public ProduitService(ProduitRepository produitRepository) {
        
        this.produitRepository=produitRepository;
    }

    private Produit addProduit(Produit produit){
        
        return this.produitRepository.save(produit);
    }
    private void deleteProduit(Produit Produit){
        this.produitRepository.delete(Produit);
    }

    private void updateProduit(Produit Produit) {

        Optional<Produit> ProduitOptional =
                this.produitRepository.findById(Produit.getId());
        if (ProduitOptional.isPresent()) {
            //find
            Produit oldProduit = ProduitOptional.get();
            //update
            oldProduit.setNom(Produit.getNom());
            oldProduit.setPrix(Produit.getPrix());
            oldProduit.setQuantitéStock(Produit.getQuantitéStock());

            //save
            this.produitRepository.save(oldProduit);

        }
    }

}
