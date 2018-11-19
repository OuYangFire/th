package com.ouyang.ssm.service;

import com.ouyang.ssm.domain.Orders;

import java.util.List;

public interface IOrderService {
    List<Orders>findAll(int page,int size);

    Orders findById(String ordersId);
}
