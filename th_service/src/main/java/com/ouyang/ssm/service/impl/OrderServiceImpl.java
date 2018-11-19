package com.ouyang.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.ouyang.ssm.dao.IOrderDao;
import com.ouyang.ssm.domain.Orders;
import com.ouyang.ssm.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements IOrderService {
    @Autowired
    private IOrderDao orderDao;

    @Override
    public List<Orders> findAll(int page,int size) {
        PageHelper.startPage(page, size);
        return orderDao.findAll();
    }

    @Override
    public Orders findById(String ordersId) {
        return orderDao.findById(ordersId);
    }
}
