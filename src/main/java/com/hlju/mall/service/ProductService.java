package com.hlju.mall.service;


import com.github.pagehelper.PageInfo;
import com.hlju.mall.domain.Product;

public interface ProductService {

	 PageInfo<Product> selectByType(String typeName);
	 
}
