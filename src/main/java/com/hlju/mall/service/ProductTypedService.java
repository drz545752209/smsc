package com.hlju.mall.service;

import java.util.List;

import com.hlju.mall.domain.ProductTyped;
import com.hlju.mall.domain.ProductTypedExample;

public interface ProductTypedService {
	
	 List<ProductTyped> selectByExample(String typedName);

}
