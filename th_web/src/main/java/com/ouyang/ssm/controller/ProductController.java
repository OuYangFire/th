package com.ouyang.ssm.controller;

import com.ouyang.ssm.domain.Product;
import com.ouyang.ssm.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService iProductService;

    //添加产品
    @RequestMapping("/save.do")
    public String save(Product p){
        iProductService.save(p);
        return "redirect:findAll.do";
    }

    @RequestMapping("/findAll.do")
    public ModelAndView findAll() {
        ModelAndView mv = new ModelAndView();
        List<Product> ps = iProductService.findAll();
        mv.addObject("productList",ps);
        mv.setViewName("product-list");
        return mv;
    }
}
