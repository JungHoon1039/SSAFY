package com.ssafy.ws.model.mapper;

import java.util.List;
import java.util.Map;

import com.ssafy.ws.model.UserDto;

public interface UserDao {
	public List<Map<String,Object>> selectUsers();
	public Map<String,Object> selectUser(Map<String,Object> paramMap);
	public int insertUser(Map<String,Object> user);
	public int updateUser(Map<String,Object> user);
	public int deleteUser(int userSeq);
	public int checkPassword(Map<String, Object> map);	
}
