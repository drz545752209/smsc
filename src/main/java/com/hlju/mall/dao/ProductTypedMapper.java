package com.hlju.mall.dao;

import com.hlju.mall.domain.ProductTyped;
import com.hlju.mall.domain.ProductTypedExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface ProductTypedMapper {
    long countByExample(ProductTypedExample example);

    int deleteByExample(ProductTypedExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProductTyped record);

    int insertSelective(ProductTyped record);

    List<ProductTyped> selectByExample(ProductTypedExample example);

    ProductTyped selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProductTyped record, @Param("example") ProductTypedExample example);

    int updateByExample(@Param("record") ProductTyped record, @Param("example") ProductTypedExample example);

    int updateByPrimaryKeySelective(ProductTyped record);

    int updateByPrimaryKey(ProductTyped record);
}