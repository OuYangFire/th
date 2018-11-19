package com.ouyang.ssm.service;

import com.ouyang.ssm.domain.Product;

import java.util.List;

public interface IProductService {
    public List<Product>findAll();

    void save(Product product);
}
