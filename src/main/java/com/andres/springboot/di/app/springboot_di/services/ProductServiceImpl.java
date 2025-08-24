package com.andres.springboot.di.app.springboot_di.services;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.andres.springboot.di.app.springboot_di.models.Product;
import com.andres.springboot.di.app.springboot_di.repositories.ProductRepository;


@Service
public class ProductServiceImpl implements ProductService{

  
  @Autowired
  @Qualifier("productList")
  private ProductRepository repository;
  @Autowired
  private Environment environment;

  @Override
  public List<Product> findAll(){
    return repository.findAll().stream().map(p->{
      Double priceTax = p.getPrice() * environment.getProperty("config.price.tax",Double.class);
      // Product newProduct = new Product(p.getId(),p.getName(),priceImp.longValue());
      Product newProduct = (Product) p.clone(); // La parte comentada de arriba esta bien pero es mejor incluirlo en el clone como se hace en esta linea
      newProduct.setPrice(priceTax.longValue());      
      return newProduct;
    }).collect(Collectors.toList()); // Toca volver a convertirlo en una lista, porque map devuelme un stream y el metodo devuelve una List
    
  }

  @Override
  public Product findById(Long id){
    return repository.findById(id);

  }
  


}