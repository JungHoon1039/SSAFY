package com.ssafy.ws.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.ws.model.service.ArticleService;
import com.ssafy.ws.model.service.FileDatabaseService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/articleapi")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
		RequestMethod.DELETE })
public class ArticleController {

	@Autowired
	private ArticleService articleService;
	
	@GetMapping("")
	@ApiOperation(value="모든 게시글 조회",response = List.class)
	public List<Map<String, Object>> getArticles() throws Exception{
		
		return articleService.getArticles(new HashMap<String, Object>());
	}
	
	@GetMapping("/{articleId}")
	@ApiOperation(value="{articleId} 를 이용한 게시글 조회", response=Map.class)
	public Map<String, Object> getArticle(@RequestParam Map<String,Object> paramMap, 
			@PathVariable("articleId")int articleId) throws Exception{
		articleService.increaseViewCnt(articleId);
		return articleService.getArticle(paramMap);
	}
	
	@PostMapping(value = "", consumes = "multipart/form-data")
	@ApiOperation(value="게시글 작성", response=Boolean.class)
	public boolean write(@RequestParam Map<String, Object> paramMap, @RequestPart(name = "fileInfos", required = false) MultipartFile[] files, HttpSession session)throws Exception{		
		if (files != null && files.length > 0) {
			paramMap.put("fileInfos", files);
		}
		System.out.println(paramMap);
		articleService.insertArticle(paramMap);
		return true;
	}
	
	
	@PutMapping("")
	@ApiOperation(value="게시글 수정", response=Boolean.class)
	public boolean update(@RequestBody Map<String,Object> map)throws Exception{
		return articleService.updateArticle(map);
	}
	
	
	@DeleteMapping("/{articleId}")
	@ApiOperation(value="게시글 삭제", response=Boolean.class)
	public boolean delete(Map<String,String> paramMap, 
			@PathVariable("articleId")int articleId){
		return articleService.deleteArticle(articleId);
	}
	
}
