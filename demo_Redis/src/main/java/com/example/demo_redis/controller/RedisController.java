package com.example.demo_redis.controller;


import com.example.demo_redis.entity.Product;
import com.example.demo_redis.repository.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class RedisController {

    @Autowired
    private ProductDao productDao;

    @PostMapping
    public Product save(Product product){
       return productDao.save(product);
    }

    @GetMapping
    public List<Product> getProduct(){
        return productDao.findALl();
    }

    @GetMapping("/{id}")
    public Product findProduct(@PathVariable int id){
        return productDao.findById(id);
    }
}
