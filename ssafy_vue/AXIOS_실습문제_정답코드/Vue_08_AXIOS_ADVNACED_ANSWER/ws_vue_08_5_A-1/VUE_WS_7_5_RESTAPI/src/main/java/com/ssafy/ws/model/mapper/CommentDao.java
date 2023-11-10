package com.ssafy.ws.model.mapper;

import java.util.List;
import java.util.Map;

import com.ssafy.ws.model.CommentDto;

public interface CommentDao {
	public List<Map<String,Object>> selectComments(Map<String,Object> comment);
	public Map<String,Object> selectComment(int id);
	public int insertComment(Map<String,Object> comment);
	public int replyComment(Map<String,Object> comment);
	public int likeComment(Map<String,Object> comment);
	public int dislikeComment(Map<String,Object> comment);
	
	public int updateRgt(Map<String,Object> comment);
	public int updateLft(Map<String,Object> comment);
//	public int updateComment(Map<String,Object> comment);
	public int deleteComment(int id);	
}
