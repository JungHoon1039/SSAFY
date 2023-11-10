package com.ssafy.ws.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.ws.model.service.CommentService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/articleapi/{articleId}/comments")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
		RequestMethod.DELETE })
public class CommentController {
	@Autowired
	CommentService commentService;
	
	@GetMapping(value="/{commentId}")
	@ApiOperation(value="댓글 조회", response=Map.class)
	public Map<String,Object> getComment(@PathVariable("commentId")int commentId) {		
		return commentService.getComment(commentId);
	}
	
	@PostMapping(value="")
	@ApiOperation(value="댓글 작성", response=Boolean.class)
	public boolean writeComment(@RequestBody Map<String, Object> comment) {	
		System.out.println(comment);
		if(!comment.containsKey("depth")) {
			comment.put("depth", 0);
		}
		return commentService.insertComment(comment);
	}
	
	@GetMapping(value="")
	@ApiOperation(value="{articleId}번 게시글의 모든 댓글 조회", response=List.class)
	public List<Map<String,Object>> getComments( @RequestParam Map<String, Object> param,
			@PathVariable("articleId") int articleId ) {
		param.put("articleId", articleId);
		return commentService.getComments(param);
	}
	
	@DeleteMapping(value="/{commentId}")
	@ApiOperation(value="{commentId}번  댓글 삭제", response=List.class)
	public boolean deleteComment(@PathVariable("commentId")int commentId) {		
		return commentService.deleteComment(commentId);
	}
	
}
