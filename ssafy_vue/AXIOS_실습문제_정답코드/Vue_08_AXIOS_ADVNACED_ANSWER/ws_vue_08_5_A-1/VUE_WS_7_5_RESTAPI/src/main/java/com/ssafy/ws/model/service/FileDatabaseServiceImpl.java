package com.ssafy.ws.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.ws.model.mapper.FileDao;

@Service
public class FileDatabaseServiceImpl implements FileDatabaseService {
	
	@Autowired
	private FileDao fileDao;

	@Override
	public int insertFile(Map<String, Object> map) {
		return fileDao.insertFile(map);
	}

	@Override
	public Map<String, Object> getFile(int fileId) {
		return fileDao.getFile(fileId);
	}

	@Override
	public List<Map<String, Object>> getFiles(int articleId) {
		return fileDao.getFiles(articleId);
	}
}
