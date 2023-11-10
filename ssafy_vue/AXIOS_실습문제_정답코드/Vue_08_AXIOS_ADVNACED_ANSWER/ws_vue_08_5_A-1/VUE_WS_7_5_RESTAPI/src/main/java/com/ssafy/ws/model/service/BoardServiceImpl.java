package com.ssafy.ws.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.ws.model.BoardDto;
import com.ssafy.ws.model.mapper.BoardDao;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	BoardDao boardDao;
	
	@Override
	public List<Map<String, Object>> getBoards() {
		return boardDao.selectBoards();
	}

	@Override
	public Map<String, Object> getBoard(Map<String,Object> board) {
		return boardDao.selectBoard(board);
	}

	@Override
	public boolean insertBoard(Map<String, Object> board) {
		int result = boardDao.insertBoard(board);		
		if (result > 0) return true;
		return false;
	}

	@Override
	public boolean updateBoard(Map<String, Object> board) {
		int result = boardDao.updateBoard(board);		
		if (result > 0) return true;
		return false;
	}

	@Override
	public boolean deleteBoard(int boardId) {
		int result = boardDao.deleteBoard(boardId);		
		if (result > 0) return true;
		return false;
	}
}
