/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.usa.c4reto01.service;

import com.usa.c4reto01.model.HairProduct;
import com.usa.c4reto01.repository.HairProductRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author alberto
 */
@Service
public class HairProductService {
    @Autowired
    private HairProductRepository repository;
    
    public List<HairProduct>getAll(){
        return repository.getAll();
    }
    
    /**
     * 
     * @param product
     * @return 
     */
    
    public HairProduct save(HairProduct product){
       
               return repository.save(product);   
            
            
    }
    
    public Optional<HairProduct> getByReference(String reference) {
        return repository.getByReference(reference);
    }

    
    public HairProduct update(HairProduct product){
        if(product.getReference()!= null){
         
            Optional<HairProduct> existsProduct=repository.getByReference(product.getReference());
           
        if(existsProduct.isPresent()){
            
     
            if(product.getBrand()!=null){
                existsProduct.get().setBrand(product.getBrand());
            }
            
            if(product.getCategory()!=null){
                existsProduct.get().setCategory(product.getCategory());
            }
            
            if(product.getName()!=null){
                existsProduct.get().setName(product.getName());
            
            if(product.getDescription()!=null){
                existsProduct.get().setDescription(product.getDescription());
            }
            
            }
            if(product.getPhotography()!=null){
                existsProduct.get().setPhotography(product.getPhotography());
            }
            if(product.getPrice()!=0.0){
                existsProduct.get().setPrice(product.getPrice());
            }
            
            if(product.getQuantity()!=0){
                existsProduct.get().setQuantity(product.getQuantity());
            }
            
            
            existsProduct.get().setAvailability(product.isAvailability());
           
                
        return repository.save(existsProduct.get());
        }else{
            return product;
        }
        }else{
            return product;
        }
        
    }
        
   
   public Optional<HairProduct> getHairProductByRefence(String reference){
        return repository.getByReference(reference);
    }
   
    public boolean delete(String reference) {
        //Optional<HairProduct> userExiste=getByReference(reference);
        
        //if(true){
            repository.delete(reference);
            return true;
       // }else{
          //  return false;
      //  }
       /* Boolean aBoolean = getHairProductByRefence(reference).map(producto -> {
            repository.delete(producto.getReference());
            return true;
        }).orElse(false);
        return aBoolean;*/
    }
    
    
}
