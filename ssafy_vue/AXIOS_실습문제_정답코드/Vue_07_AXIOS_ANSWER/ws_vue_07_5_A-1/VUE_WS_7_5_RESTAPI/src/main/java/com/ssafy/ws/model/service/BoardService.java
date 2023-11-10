package com.ssafy.ws.model.service;

import java.util.List;
import java.util.Map;

public interface BoardService {
	public List<Map<String, Object>> getBoards();
	public Map<String, Object> getBoard( Map<String,Object> board);
	public boolean insertBoard(Map<String,Object> board);
	public boolean updateBoard(Map<String,Object> board);
	public boolean deleteBoard(int boardId);
}
