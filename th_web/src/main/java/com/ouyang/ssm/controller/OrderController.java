package com.ouyang.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.ouyang.ssm.domain.Orders;
import com.ouyang.ssm.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private IOrderService orderService;

    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name = "id") String ordersId) {
        ModelAndView mv = new ModelAndView();
        Orders orders = orderService.findById(ordersId);
        ModelAndView modelAndView = mv.addObject("orders", orders);
        mv.setViewName("orders-show");
        modelAndView.toString();
        return mv;
    }

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") Integer page, @RequestParam(name = "seiz", required = true, defaultValue = "6") Integer size) {
        ModelAndView mv = new ModelAndView();
        List<Orders> ordersList = orderService.findAll(page, size);
        PageInfo pageInfo = new PageInfo(ordersList);
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("orders-page-list");
        return mv;
    }
}
