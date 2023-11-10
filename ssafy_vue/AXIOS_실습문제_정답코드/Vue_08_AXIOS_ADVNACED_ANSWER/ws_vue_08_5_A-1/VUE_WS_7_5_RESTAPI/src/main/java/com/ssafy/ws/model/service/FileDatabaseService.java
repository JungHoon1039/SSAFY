package com.ssafy.ws.model.service;

import java.util.List;
import java.util.Map;

public interface FileDatabaseService {
	public int insertFile(Map<String,Object> map);
	public Map<String, Object> getFile(int fileId);
	public List<Map<String, Object>> getFiles(int articleId);
}
