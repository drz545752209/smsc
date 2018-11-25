package com.hlju.mall.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hlju.mall.commom.Encryption;
import com.hlju.mall.dao.UserMapper;
import com.hlju.mall.domain.User;
import com.hlju.mall.domain.UserExample;
import com.hlju.mall.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	UserMapper userMapper;

	@Override
	public long countByExample(UserExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByExample(UserExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(User record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(User record) {
		String password = record.getPassword();
		record.setPassword(Encryption.str2MD5(password));
		return userMapper.insertSelective(record);
	}

	@Override
	public boolean hasPassword(User user) {
		List<User> users = selectByExample(user);
		if (users.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public List<User> selectByExample(User user) {
		UserExample uExample = new UserExample();
		UserExample.Criteria criteria = uExample.createCriteria();
		if (StringUtils.isNotBlank(user.getUsername())) {
			criteria.andUsernameEqualTo(user.getUsername());
			if (StringUtils.isNotBlank(user.getPassword())) {
				String password = Encryption.str2MD5(user.getPassword());
				criteria.andPasswordEqualTo(password);
				return userMapper.selectByExample(uExample);
			}
		}
		return null;
	}

	public boolean hasUserName(User user) {
		List<User> users = selectUserNameByExamle(user);
		if (users.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public List<User> selectUserNameByExamle(User record) {
		UserExample uExample = new UserExample();
		UserExample.Criteria criteria = uExample.createCriteria();
		String userName = StringUtils.isNotEmpty(record.getUsername()) ? null : record.getUsername();
		if (!userName.isEmpty()) {
			criteria.andUsernameEqualTo(userName);
			return userMapper.selectByExample(uExample);
		}
		return null;
	}

	@Override
	public User selectByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByExampleSelective(User record, UserExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByExample(User record, UserExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKeySelective(User record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(User record) {
		// TODO Auto-generated method stub
		return 0;
	}

}
