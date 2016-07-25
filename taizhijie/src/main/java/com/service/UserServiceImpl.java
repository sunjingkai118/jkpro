package com.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.UserDao;
import com.model.User;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public User getUserById(Integer userId) {
		return userDao.selectByPrimaryKey(userId);
	}

	@Override
	public void saveUser(User user) {
		int rs = userDao.insert(user);
		System.out.println(user.getId());
		System.out.println(rs);
		throw new RuntimeException();
	}
}