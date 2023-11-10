package com.ssafy.ws.model;

public class BoardDto {
	private int boardId;
	private String boardName, description, createdAt;
	private int totalArticleCnt, newArticleCnt;


	public int getTotalArticleCnt() {
		return totalArticleCnt;
	}

	public void setTotalArticleCnt(int totalArticleCnt) {
		this.totalArticleCnt = totalArticleCnt;
	}

	public int getNewArticleCnt() {
		return newArticleCnt;
	}

	public void setNewArticleCnt(int newArticleCnt) {
		this.newArticleCnt = newArticleCnt;
	}

	public int getBoardId() {
		return boardId;
	}

	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}

	public String getBoardName() {
		return boardName;
	}

	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "BoardDto [boardId=" + boardId + ", boardName=" + boardName + ", description=" + description
				+ ", createdAt=" + createdAt + ", totalArticleCnt=" + totalArticleCnt + ", newArticleCnt="
				+ newArticleCnt + "]";
	}

	
}
