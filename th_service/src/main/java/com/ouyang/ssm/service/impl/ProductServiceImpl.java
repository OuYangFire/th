package com.ouyang.ssm.service.impl;

import com.ouyang.ssm.dao.IProductDao;
import com.ouyang.ssm.domain.Product;
import com.ouyang.ssm.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class ProductServiceImpl implements IProductService {
    @Autowired
    private IProductDao productDao;
    @Override
    public List<Product> findAll() {
        return productDao.findAll();
    }

    @Override
    public void save(Product product) {
        productDao.save(product);
    }
}
