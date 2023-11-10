package com.ssafy.ws.model;

public enum Board {

	BOARD_ID("boardId"), BOARD_NAME("boardName"),
	DESCRIPTION("description"), CREATED_AT("createdAt"),
	TOTAL_ARTICLE_CNT("totalArticleCnt"), NEW_ARTICLE_CNT("newArticleCnt");
	private String field;

	private Board(String field) {
		this.field = field;
	}

	public String getField() {
		return this.field;
	}
}
