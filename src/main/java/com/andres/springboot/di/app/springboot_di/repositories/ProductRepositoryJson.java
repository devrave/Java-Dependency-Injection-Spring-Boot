package com.andres.springboot.di.app.springboot_di.repositories;

import java.io.IOException;
import java.security.PublicKey;
import java.util.Arrays;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.andres.springboot.di.app.springboot_di.models.Product;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ProductRepositoryJson implements ProductRepository {

  private List<Product> list;

  

  public ProductRepositoryJson() {
    Resource resource = new ClassPathResource("json/product.json"); //para leer un archivo
    ObjectMapper objectMapper = new ObjectMapper();  // ObjectMapper permite convertir un archivo a un objeto de java
    try {
      list = Arrays.asList(objectMapper.readValue(resource.getFile(), Product[].class));
    } catch (StreamReadException e) {      
      e.printStackTrace();
    } catch (DatabindException e) {     
      e.printStackTrace();
    } catch (IOException e) {  
      e.printStackTrace();
    }
  }

  @Override
  public List<Product> findAll() {    
    return list;
  }

  @Override
  public Product findById(Long id) {   
    return null;
  }



}
