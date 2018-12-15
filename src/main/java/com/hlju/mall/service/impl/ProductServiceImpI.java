package com.hlju.mall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hlju.mall.dao.ProductMapper;
import com.hlju.mall.domain.Product;
import com.hlju.mall.domain.ProductExample;
import com.hlju.mall.domain.ProductExample.Criteria;
import com.hlju.mall.service.ProductService;

@Service("productService")
public class ProductServiceImpI implements ProductService {
	
	@Autowired
	ProductMapper productMapper;
	final static Integer pageSize=5;

	@Override
	public  PageInfo<Product> selectByType(String typeName) {
		 ProductExample productExample=new ProductExample();
		 if("".equals(typeName)||typeName==null) {
			 Criteria criteria = productExample.createCriteria();
			 criteria.andTypeNameEqualTo(typeName);
		 }
		 productExample.setOrderByClause("sales_volume DESC");
		 PageHelper.startPage(1, pageSize);
		 List<Product> products=productMapper.selectByExample(productExample);
		 PageInfo<Product> pageInfo=new PageInfo<Product>(products);
		 return pageInfo;
	}

		
	


}
