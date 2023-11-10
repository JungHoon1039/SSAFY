package com.ssafy.ws.model;

public enum File {
	FILE_ID("articleId"), ORIGIN_FILE("originFile"), SAVE_FOLDER("saveFolder"), SAVEFILE("saveFile"),
	ARTICLEID("articleId");

	private String field;

	private File(String field) {
		this.field = field;
	}

	public String getField() {
		return this.field;
	}
}
