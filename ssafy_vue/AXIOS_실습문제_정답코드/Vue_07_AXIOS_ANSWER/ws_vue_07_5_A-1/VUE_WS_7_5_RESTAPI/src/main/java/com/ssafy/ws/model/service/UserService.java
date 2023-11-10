package com.ssafy.ws.model.service;


import java.util.List;
import java.util.Map;

import com.ssafy.ws.model.UserDto;


public interface UserService {
	public List<Map<String, Object>> getUsers(); 
	public Map<String, Object> getUser(int userSeq);
	public boolean insertUser(Map<String,Object> user);
	public boolean updateUser(Map<String,Object> user);
	public boolean deleteUser(int userSeq);
	public Map<String,Object> login(Map<String,Object> user);
	public Boolean checkPassword(Map<String, Object> map);
	
}
