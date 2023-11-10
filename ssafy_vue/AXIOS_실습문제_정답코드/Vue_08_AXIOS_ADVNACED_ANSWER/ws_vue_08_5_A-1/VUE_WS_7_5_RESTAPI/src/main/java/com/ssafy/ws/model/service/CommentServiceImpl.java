package com.ssafy.ws.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.ws.model.CommentDto;
import com.ssafy.ws.model.mapper.CommentDao;

@Service
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	CommentDao commentDao;

	@Override
	public List<Map<String, Object>> getComments(Map<String,Object> comment) {		
		return commentDao.selectComments(comment);
	}

	@Override
	public Map<String, Object> getComment(int commentId) {		
		return commentDao.selectComment(commentId);
	}

	@Override
	public boolean insertComment(Map<String, Object> comment) {
		int result = commentDao.insertComment(comment);
		if (result > 0) return true;
		return false;
	}


	@Override
	public boolean deleteComment(int commentId) {
		int result = commentDao.deleteComment(commentId);
		if (result > 0) return true;
		return false;
	}

	@Override
	public boolean replyComment(Map<String, Object> comment) {
		commentDao.updateRgt(comment);
		System.out.println(comment);
		commentDao.updateLft(comment);
		System.out.println(comment);
		
		return commentDao.replyComment(comment) == 1;	
	}

	@Override
	public boolean likeComment(Map<String, Object> comment) {
		
		return commentDao.likeComment(comment) == 1;
	}

	@Override
	public boolean dislikeComment(Map<String, Object> comment) {
		return commentDao.dislikeComment(comment) == 1;
	}
}
