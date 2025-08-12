package com.andres.springboot.di.app.springboot_di.services;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.andres.springboot.di.app.springboot_di.models.Product;
import com.andres.springboot.di.app.springboot_di.repositories.ProductRepository;

public class ProductService {

  private ProductRepository repository = new ProductRepository();


  public List<Product> findAl(){
    return repository.findAll().stream().map(p->{
      Double priceImp = p.getPrice() * 1.25d;
      p.setPrice(priceImp.longValue());
      return p;
    }).collect(Collectors.toList()); // Toca volver a convertirlo en una lista, porque map devuelme un stream y el metodo devuelve una List
    
  }

  public Product findById(Long id){
    return repository.findById(id);

  }


}