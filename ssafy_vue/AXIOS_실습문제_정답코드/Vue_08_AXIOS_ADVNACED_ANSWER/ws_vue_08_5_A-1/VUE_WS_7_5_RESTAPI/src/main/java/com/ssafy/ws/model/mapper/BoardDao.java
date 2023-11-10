package com.ssafy.ws.model.mapper;

import java.util.List;
import java.util.Map;

public interface BoardDao {
	public List<Map<String,Object>> selectBoards();
	public Map<String,Object> selectBoard(Map<String,Object> board);
	public int insertBoard(Map<String,Object> board);
	public int updateBoard(Map<String,Object> board);
	public int deleteBoard(int id);	
}
