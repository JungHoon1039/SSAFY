package com.ssafy.ws.model.service;

import java.util.List;
import java.util.Map;

public interface ArticleService {
//	public List<Map<String, Object>> getArticles();
	public List<Map<String, Object>> getArticles(Map<String,Object> params);
	public Map<String, Object> getArticle(Map<String,Object> params);
	public boolean insertArticle(Map<String,Object> article);
	public boolean replyArticle(Map<String,Object> article);
	public boolean updateArticle(Map<String,Object> article);
	public boolean likeArticle(Map<String,Object> article);
	public boolean dislikeArticle(Map<String,Object> article);
	public boolean deleteArticle(int articleId);		
	public boolean increaseViewCnt(int articleId);
}
