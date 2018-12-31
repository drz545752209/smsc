package com.hlju.mall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hlju.mall.dao.ProductTypedMapper;
import com.hlju.mall.domain.ProductTyped;
import com.hlju.mall.domain.ProductTypedExample;
import com.hlju.mall.domain.ProductTypedExample.Criteria;
import com.hlju.mall.service.ProductTypedService;

@Service("productTypedService")
public class ProductTypedServiceImpl implements ProductTypedService {

	@Autowired
	ProductTypedMapper productTypedMapper;

	@Override
	public List<ProductTyped> selectByExample(String typedName) {
		ProductTypedExample productTypedExample = new ProductTypedExample();

		Criteria productTypedCriteria = productTypedExample.createCriteria();
		productTypedCriteria.andNameEqualTo(typedName);
		List<ProductTyped> productTypedList = productTypedMapper.selectByExample(productTypedExample);

		return productTypedList;
	}

}
