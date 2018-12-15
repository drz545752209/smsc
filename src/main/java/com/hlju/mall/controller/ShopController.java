package com.hlju.mall.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.hlju.mall.domain.Product;
import com.hlju.mall.service.ProductService;

@Controller
public class ShopController {
	
	@Autowired
	ProductService productService;
	
	@RequestMapping(value = { "/index", "/index.html" })
	public ModelAndView toIndex(String typeName) throws Exception {
		ModelAndView mav=new ModelAndView();
		PageInfo<Product> pageInfo=productService.selectByType(typeName);
		if(!"".equals(typeName)&&typeName!=null) {
			mav.addObject("pageInfo",pageInfo);
			mav.setViewName("index");
		}
		
		return mav;
	}
	

	     

}
