package com.hlju.mall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ShopController {
	
	@RequestMapping(value = { "/index", "/index.html" })
	public String toIndex(String typeName) throws Exception {
		
		return "index";
	}
	     

}
