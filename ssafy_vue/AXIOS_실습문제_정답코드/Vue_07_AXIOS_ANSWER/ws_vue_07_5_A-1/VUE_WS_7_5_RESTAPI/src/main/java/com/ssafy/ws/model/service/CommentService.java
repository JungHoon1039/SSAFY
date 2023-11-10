package com.ssafy.ws.model.service;

import java.util.List;
import java.util.Map;

import com.ssafy.ws.model.CommentDto;

public interface CommentService {
	public List<Map<String, Object>> getComments(Map<String,Object> comment);
	public Map<String, Object> getComment(int commentId);
	public boolean insertComment(Map<String,Object> comment);
	public boolean replyComment(Map<String,Object> comment);
	public boolean likeComment(Map<String,Object> comment);
	public boolean dislikeComment(Map<String,Object> comment);
	public boolean deleteComment(int CommentId);
}
