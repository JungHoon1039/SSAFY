package com.ssafy.ws.controller;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.ws.model.service.FileDatabaseService;
import com.ssafy.ws.model.service.FileStorageService;

import io.swagger.annotations.ApiOperation;

@Controller
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
		RequestMethod.DELETE })
public class FileController {
	
	@Autowired
	FileStorageService fileStorageService;
	
	@Autowired
	FileDatabaseService fileDatabaseService;
		

	@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
		RequestMethod.DELETE })
	@PostMapping("/fileapi")
	@ApiOperation(value = "파일을 업로드한다")
	public ResponseEntity<Map<String, Object>> uploadFile(@RequestParam("file") MultipartFile file){
		Map<String, Object> fileMap = new HashMap<String, Object>();
		try {
			String today = new SimpleDateFormat("yyMMdd").format(new Date());
			String saveFilename = UUID.randomUUID().toString();
			
			fileMap.put("originFile",file.getOriginalFilename() );
			fileMap.put("saveFolder", today);
			fileMap.put("saveFile", saveFilename);
			fileMap.put("status", "success");
			fileMap.put("message", "파일이 성공적으로 업로드되었습니다: "+file.getOriginalFilename());
			
			fileStorageService.save(file, fileMap);
			
			return ResponseEntity.status(HttpStatus.OK).body(fileMap);
		} catch (Exception e) {
			fileMap.put("message", "파일을 업로드하지 못했습니다: "+file.getOriginalFilename());
			fileMap.put("status", "failed");
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(fileMap);
		}
	}
	
	@GetMapping("/fileapi/{fileId}")
	@ResponseBody
	@ApiOperation(value = "{fileId}에 해당하는 파일 정보를 반환한다.")
	public ResponseEntity<Resource> getFile(@PathVariable("fileId") int fileId) {
		Map<String,Object> fileMap = fileDatabaseService.getFile(fileId);
		Resource file = fileStorageService.loadFile(fileMap);
		return ResponseEntity.ok()
		        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + ((String)fileMap.get("originFile")) + "\"").body(file);
		
		
	}
	
	@GetMapping("/articleapi/{articleId}/files")
	@ApiOperation(value = "{articleId}에 해당하는 게시글의 모든 파일 정보를 반환한다.")
	public @ResponseBody List<Map<String,Object>> getFiles(@PathVariable("articleId") int articleId){
		return fileDatabaseService.getFiles(articleId);
	}
}
