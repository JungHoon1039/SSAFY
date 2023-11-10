package com.ssafy.ws.model.service;

import java.nio.file.Path;
import java.util.Map;
import java.util.stream.Stream;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;


public interface FileStorageService {
	public void init();
	public void save(MultipartFile file, Map<String, Object> fileMap);
	public Resource load(String filename);
	public void deleteAll();
	public Stream<Path> loadAll();
	public Resource loadFile(Map<String, Object> fileMap);
}
