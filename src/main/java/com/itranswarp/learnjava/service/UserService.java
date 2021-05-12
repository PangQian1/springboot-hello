package com.itranswarp.learnjava.service;

import java.sql.Statement;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.itranswarp.learnjava.mapper.UserMapper;

import com.itranswarp.learnjava.entity.User;

import javax.annotation.Resource;

@Component
@Transactional
public class UserService {

	final Logger logger = LoggerFactory.getLogger(getClass());

	@Resource
	UserMapper userMapper;

	public User getUserById(long id) {
		User user = userMapper.getById(id);
		if (user == null) {
			throw new RuntimeException("User not found by id.");
		}
		return user;
	}

	public User getUserByEmail(String email) {
		return userMapper.getByEmail(email);
	}

	public User signin(String email, String password) {
		logger.info("try login by {}...", email);
		User user = getUserByEmail(email);
		if (user.getPassword().equals(password)) {
			return user;
		}
		throw new RuntimeException("login failed.");
	}

	public User register(String email, String password, String name) {
		logger.info("try register by {}...", email);
		User user = new User();
		user.setEmail(email);
		user.setPassword(password);
		user.setName(name);
		user.setCreatedAt(System.currentTimeMillis());
		userMapper.insert(user);
		//插入失败怎么办！
//		if (1 != userMapper.insert(user)) {
//			throw new RuntimeException("Insert failed.");
//		}
		return user;
	}

	public void updateUser(User user) {
		userMapper.update(user);
	}

	public void updateUserPassword(User user, String new_password) {
		userMapper.updatePassword(user, new_password);
	}

	public List<User> getAllUser(){
		return userMapper.getAllByPage();
	}
}
