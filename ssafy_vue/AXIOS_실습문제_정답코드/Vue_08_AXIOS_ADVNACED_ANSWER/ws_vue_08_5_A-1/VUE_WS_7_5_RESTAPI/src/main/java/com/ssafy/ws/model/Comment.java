package com.ssafy.ws.model;

public enum Comment {
	commentId("commentId"), 
	content("content"), 
	likeCnt("likeCnt"),
	dislikeCnt("dislikeCnt"),
	totalLikeCnt("totalLikeCnt"), 
	totalDislikeCnt("totalDislikeCnt"),
	userSeq("userSeq"), 
	userName("userName"),
	nickname("nickname"), 
	articleId("articleId"), 
	boardId("boardId"),
	boardName("boardName"), 
	lft("lft"), 
	rgt("rgt"),
	depth("depth"), 
	createdAt("createdAt");

	private String field;

	private Comment(String field) {
		this.field = field;
	}

	public String getField() {
		return this.field;
	}
}
