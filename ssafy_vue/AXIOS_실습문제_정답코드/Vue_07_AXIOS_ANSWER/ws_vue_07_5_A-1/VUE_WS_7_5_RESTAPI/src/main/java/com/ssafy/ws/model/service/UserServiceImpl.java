package com.ssafy.ws.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.ws.model.User;
import com.ssafy.ws.model.UserDto;
import com.ssafy.ws.model.mapper.UserDao;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDao userDao;
	
	@Override
	public List<Map<String, Object>> getUsers() {
		return userDao.selectUsers();
	}

	@Override
	public Map<String, Object> getUser(int userSeq) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put(User.USER_SEQ.toString(), userSeq);
	
		return userDao.selectUser(paramMap);
	}

	@Override
	public boolean insertUser(Map<String, Object> user) {
		int result = userDao.insertUser(user);
		if (result > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean updateUser(Map<String, Object> user) {
		int result = userDao.updateUser(user);
		if (result > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteUser(int userSeq) {
		int result = userDao.deleteUser(userSeq);
		if (result > 0) {
			return true;
		}
		return false;
	}

	@Override
	public Map<String,Object> login(Map<String, Object> loginInfo) {
		String userId = loginInfo.get(User.USER_ID.toString()).toString();
		String pwd = loginInfo.get(User.USER_PWD.toString()).toString();
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		paramMap.put(User.USER_ID.toString(), userId);
		Map<String,Object> user = userDao.selectUser(paramMap);
		System.out.println(paramMap);
		System.out.println(user);
		
		if (user != null && user.get(User.USER_PWD.toString()).toString().equals(pwd)) {
			return user;
		}
		return null;
	}

	@Override
	public Boolean checkPassword(Map<String, Object> map) {
		return userDao.checkPassword(map) == 1;
	}
	
	
}
