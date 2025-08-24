package com.andres.springboot.di.app.springboot_di.repositories;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.andres.springboot.di.app.springboot_di.models.Product;
@Primary
@Repository("productFoo")
public class productRepositoryFoo implements ProductRepository {

  @Override
  public List<Product> findAll() {
    return Collections.singletonList(new Product(1L, "Monitor Asus 27",600L));
  }

  @Override
  public Product findById(Long id) {
    return new Product(id, "Monitor Asus 27",600L);
  }

}
