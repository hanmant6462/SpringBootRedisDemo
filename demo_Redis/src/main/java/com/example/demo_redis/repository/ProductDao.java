package com.example.demo_redis.repository;


import com.example.demo_redis.entity.Product;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDao {


    private static final Object HASH_KEY = "PRODUCT";
    private RedisTemplate redisTemplate;


    public Product save(Product product){
        redisTemplate.opsForHash().put(HASH_KEY,product.getId(),product);
        return product;
    }

    public List<Product> findALl(){
        return redisTemplate.opsForHash().values(HASH_KEY);

    }

    public Product findById(int id) {
        return (Product) redisTemplate.opsForHash().get(HASH_KEY,id);
    }

    public String deleteProduct(int id){
        redisTemplate.opsForHash().delete(HASH_KEY,id);
        return "product removed";
    }
}
