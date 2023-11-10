package com.ssafy.ws.model;

public enum Article {
	ARTICLE_ID("articleId"), 
	TITLE("title"), 
	CONTENT("content"), 
	USER_SEQ("userSeq"), 
	USER_ID("userId"),
	USER_NAME("userName"), 
	VIEW_CNT("viewCnt"), 
	LIKE_CNT("likeCnt"),
	DISLIKE_CNT("dislikeCnt"),
	TOTAL_COMMENT_CNT("totalCommentCnt"), 
	TOTAL_LIKE_CNT("totalLikeCnt"), 
	CREATED_AT("createdAt"),
	MODIFIED_AT("modifiedAt"), 
	BOARD_ID("boardId"), 
	BOARD_NAME("boardName"),
	LFT("lft"), 
	RGT("rgt"), 
	DEPTH("depth"),
	USER_NICKNAME("userNickname"), 
	CURRENT_PAGE("currentPage"), 
	FILE_LIST("fileList"),
	MAX_RGT("maxRgt"),
	MAX_LFT("maxLft"), 
	TARGET_LFT("targetLft"), 
	TARGET_RGT("targetRgt"), 
	TARGET_DEPTH("targetDepth");
	private Article(String filed) {
		this.filed = filed;
	};

	public String getField() {
		return this.filed;
	}

	private String filed;
}
