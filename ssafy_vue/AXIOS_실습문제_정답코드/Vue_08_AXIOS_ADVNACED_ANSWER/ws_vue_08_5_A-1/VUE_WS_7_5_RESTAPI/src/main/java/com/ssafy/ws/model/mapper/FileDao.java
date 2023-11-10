package com.ssafy.ws.model.mapper;

import java.util.List;
import java.util.Map;

public interface FileDao {
	public int insertFile(Map<String, Object> file);
	public Map<String,Object> getFile(int fileId);
	public List<Map<String,Object>> getFiles(int articleId);
}
