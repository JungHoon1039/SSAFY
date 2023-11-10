package com.ssafy.ws.model.mapper;

import java.util.List;
import java.util.Map;

public interface ArticleDao {
	public List<Map<String,Object>> selectArticles(Map<String,Object> param);
	public Map<String,Object> selectArticle(Map<String,Object> param);
	
	public int insertArticle(Map<String,Object> article);
	//getMaxRgt
	public int selectMaxRgt(int boardId);
	
	public int updateArticle(Map<String,Object> article);
	
	public int getParentDepth(Map<String,Object> article);
	public int replyArticle(Map<String,Object> article);
	public int updateLft(Map<String,Object> article);
	public int updateRgt(Map<String,Object> article);
	
	public int deleteArticle(int id);	
	
	public int likeArticle(Map<String,Object> article);
	public int dislikeArticle(Map<String,Object> article);
	
	
	//file
	public int saveFile(Map<String,Object> param);
	public int increaseViewCnt(int id);
	
	
}
