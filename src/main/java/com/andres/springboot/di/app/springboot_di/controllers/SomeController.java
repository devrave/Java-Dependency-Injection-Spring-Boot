package com.andres.springboot.di.app.springboot_di.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andres.springboot.di.app.springboot_di.models.Product;
import com.andres.springboot.di.app.springboot_di.services.ProductServiceImpl;

@RestController
@RequestMapping(path = "/api")
public class SomeController { //Nota: el controlador el singleton, es una unica instancia compartida por todos

  private ProductServiceImpl service = new ProductServiceImpl();

  @GetMapping
  public List<Product> list(){
    return service.findAll();

  };

  @GetMapping("/{id}")
    public Product show(@PathVariable Long id){
      return service.findById(id);

  }

}
