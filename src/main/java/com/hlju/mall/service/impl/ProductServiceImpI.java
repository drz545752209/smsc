package com.hlju.mall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hlju.mall.dao.ProductMapper;
import com.hlju.mall.domain.Product;
import com.hlju.mall.domain.ProductExample;
import com.hlju.mall.domain.ProductExample.Criteria;
import com.hlju.mall.service.ProductService;

@Service("productService")
public class ProductServiceImpI implements ProductService {
	
	@Autowired
	ProductMapper productMapper;

	@Override
	public List<Product> selectByType(String typeName) {
		 ProductExample productExample=new ProductExample();
		 if("".equals(typeName)||typeName==null) {
			 Criteria criteria = productExample.createCriteria();
			 criteria.andTypeNameEqualTo(typeName);
		 }
		 productExample.setOrderByClause("sales_volume DESC");
		 List<Product> products=productMapper.selectByExample(productExample);
		 return products;
	}

		
	


}
