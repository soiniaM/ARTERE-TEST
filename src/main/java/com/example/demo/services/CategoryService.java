package com.example.demo.services;

import com.example.demo.model.Category;
import com.example.demo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    private CategoryRepository categoryRepository;
    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository=categoryRepository;
    }

    private Category addCategory(Category category){
        return this.categoryRepository.save(category);
    }
    private void deleteCategory(Category category){
         this.categoryRepository.delete(category);
    }

    private void updateCategory(Category category){

        Optional<Category> categoryOptional= this.categoryRepository.findById(category.getId());
       if( categoryOptional.isPresent()){
           //find
           Category oldCategory= categoryOptional.get();
           //update
           oldCategory.setNom(category.getNom());
           oldCategory.setDescription(category.getDescription());
           oldCategory.setCategoryList(category.getCategoryList());
           oldCategory.setProduitsList(category.getProduitsList());

           //save
           this.categoryRepository.save(oldCategory);

       }
    }


}

