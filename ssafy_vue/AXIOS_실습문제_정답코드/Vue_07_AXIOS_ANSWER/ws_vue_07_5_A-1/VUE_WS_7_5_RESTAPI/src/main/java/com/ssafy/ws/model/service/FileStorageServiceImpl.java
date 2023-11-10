package com.ssafy.ws.model.service;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.stream.Stream;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileStorageServiceImpl implements FileStorageService {

	private final Path root = Paths.get("uploads");
	
	@Override
	public void init() {
		try {
			Files.createDirectory(root);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("업로드 폴더를 초기화할 수 없습니다");
		}

	}

	@Override
	public void save(MultipartFile file, Map<String, Object> fileMap) {
		try {
			if(!Files.exists(root)) {
				Files.createDirectory(root);
			}
			Path saveFolder = Paths.get("uploads/"+((String)fileMap.get("saveFolder")));
			if(!Files.exists(saveFolder)) {
				Files.createDirectory(saveFolder);
			}
			Files.copy(file.getInputStream(), saveFolder.resolve((String)fileMap.get("saveFile")));
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("파일을 저장할 수 없습니다.");
		}
		
	}

	@Override
	public Resource load(String filename) {
		try {
			Path file = root.resolve(filename);
			Resource resource = new UrlResource(file.toUri());
		
			if(resource.exists() || resource.isReadable()) {
				return resource;
			} else {
				throw new RuntimeException("파일을 읽을 수 없습니다.");
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void deleteAll() {
		FileSystemUtils.deleteRecursively(root.toFile());
	}

	@Override
	public Stream<Path> loadAll() {
		try {
			return Files.walk(this.root,  1).filter(path -> !path.equals(this.root)).map(this.root::relativize);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("파일을 로드할 수 없습니다!");
		}
	}

	@Override
	public Resource loadFile(Map<String, Object> fileMap) {
		Path saveFolder = Paths.get("uploads/"+((String)fileMap.get("saveFolder")));
		Path file = saveFolder.resolve((String)fileMap.get("saveFile"));
		Resource resource;
		try {
			resource = new UrlResource(file.toUri());
			return resource;
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
