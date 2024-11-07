package com.example.demo.services;

import com.example.demo.model.Panier;
import com.example.demo.model.Produit;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PanierService {

    private Panier ajouteProduit(Panier panier, List<Produit>produitList){

        produitList.forEach(produit -> panier.getProduitList().add(produit));
        return panier;
    }

}
