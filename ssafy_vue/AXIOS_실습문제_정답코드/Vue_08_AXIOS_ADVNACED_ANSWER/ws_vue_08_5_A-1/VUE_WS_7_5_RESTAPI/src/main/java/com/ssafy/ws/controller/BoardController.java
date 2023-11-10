package com.ssafy.ws.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.ws.model.service.ArticleService;
import com.ssafy.ws.model.service.BoardService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/boardapi")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
		RequestMethod.DELETE })
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	@Autowired
	ArticleService articleService;
	
	@GetMapping("")
	@ApiOperation(value="게시판 전체 목록조회", response=List.class)
	public List<Map<String, Object>> getBoards() throws Exception{
		return boardService.getBoards();
	}
	
	@GetMapping(value = "/{boardId}/search")
	@ApiOperation(value="{boardId} 번 게시판 조회", response=Map.class)
	public Map<String, Object> search(@RequestParam Map<String,Object> params, 
			@PathVariable("boardId")int boardId) throws Exception{
			System.out.println(params);
			params.put("boardId", boardId);
			Map<String,Object> boardInfo = new HashMap<String, Object>();
			boardInfo.put("board", boardService.getBoard(params));
			System.out.println("params :: " + params);
			
			int currentPage = 1;
			int itemsPerPage = 10;
			int pagesPerGroup = 5;
			if (params.get("currentPage") != null) {
				currentPage = Integer.parseInt((String)params.get("currentPage"));
			}
			if (params.get("itemsPerPage") != null) {
				itemsPerPage =Integer.parseInt((String) params.get("itemsPerPage"));
			}
			if (params.get("pagesPerGroup") != null) {
				pagesPerGroup = Integer.parseInt((String) params.get("pagesPerGroup"));
			}
			
			params.put("limit", itemsPerPage);
			params.put("offset", (currentPage-1) * itemsPerPage);
			boardInfo.put("articles", articleService.getArticles(params));
			
		return boardInfo;
	}
	
	@GetMapping(value = "/{boardId}")
	@ApiOperation(value="{boardId} 번 게시판 조회", response=Map.class)
	public Map<String, Object> read(@RequestParam Map<String,Object> params, 
			@PathVariable("boardId")int boardId) throws Exception{
			System.out.println(params);
			params.put("boardId", boardId);
			Map<String,Object> boardInfo = new HashMap<String, Object>();
			boardInfo.put("board", boardService.getBoard(params));
			
			int currentPage = 1;
			int itemsPerPage = 10;
			int pagesPerGroup = 5;
			if (params.get("currentPage") != null) {
				currentPage = Integer.parseInt((String)params.get("currentPage"));
			}
			if (params.get("itemsPerPage") != null) {
				itemsPerPage =Integer.parseInt((String) params.get("itemsPerPage"));
			}
			if (params.get("pagesPerGroup") != null) {
				pagesPerGroup = Integer.parseInt((String) params.get("pagesPerGroup"));
			}
			
			params.put("limit", itemsPerPage);
			params.put("offset", (currentPage-1) * itemsPerPage);
			boardInfo.put("articles", articleService.getArticles(params));
			
		return boardInfo;
	}
	
	
	@PostMapping(value = "")
	@ApiOperation(value="게시판 생성", response=Boolean.class)
	public boolean createBoard(@RequestBody Map<String,Object> paramMap)throws Exception{		
		System.out.println(paramMap);
		return boardService.insertBoard(paramMap);
	}
	
	@PutMapping(value = "/{boardId}")
	@ApiOperation(value="{boardId} 번 게시판 수정", response=Boolean.class)
	public boolean update(@RequestParam Map<String,Object> paramMap, 
			@PathVariable("boardId")int boardId)throws Exception{
		return boardService.updateBoard(paramMap);
	}
	
	@DeleteMapping(value = "/{boardId}")
	@ApiOperation(value="{boardId} 번 게시판 삭제", response=Boolean.class)
	public boolean delete(@PathVariable("boardId") int boardId){
		return boardService.deleteBoard(boardId);
	}
	
}
