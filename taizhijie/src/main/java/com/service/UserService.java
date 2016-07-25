package com.service;

import com.model.User;

public interface UserService {
	public User getUserById(Integer userId);

	public void saveUser(User user);
}
