package com.hlju.mall.service;

import java.util.List;

import com.hlju.mall.domain.Product;
import com.hlju.mall.domain.ProductExample;

public interface ProductService {

	 List<Product> selectByType(String typeName);
	 
}
