package com.hlju.mall.controller;


import java.util.Arrays;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.hlju.mall.domain.Product;
import com.hlju.mall.domain.ProductTyped;
import com.hlju.mall.service.ProductService;
import com.hlju.mall.service.ProductTypedService;

@Controller
public class ShopController {
	
	@Autowired
	ProductService productService;
	@Autowired
	ProductTypedService productTypedService;
	
	@RequestMapping(value = { "/index", "/index.html" }, method=RequestMethod.GET)
	public ModelAndView toIndex(String typeName) throws Exception {
		ModelAndView mav=new ModelAndView();
		PageInfo<Product> pageInfo=productService.selectByType(typeName);
		mav.addObject("pageInfo",pageInfo);

		List<ProductTyped> productTypeList=productTypedService.selectByExample(typeName);
		mav.addObject("productTypeList",productTypeList);		
		mav.setViewName("index.html");
		return mav;
	}
	
	@RequestMapping(value = { "/search"}, method=RequestMethod.GET)
	public ModelAndView search(@RequestParam()String keyword) {
		return null;
		
	}
	
	
	

	     

}
