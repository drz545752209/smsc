package com.hlju.mall.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hlju.mall.domain.User;
import com.hlju.mall.domain.UserExample;

public interface UserService {
    long countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    boolean hasPassword(User user);
    
    boolean hasUserName(User user);

    User selectByPrimaryKey(Long id);
    
    List<User> selectByExample(User user);
    
    List<User> selectUserNameByExamle(User record);
    
    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);


}
