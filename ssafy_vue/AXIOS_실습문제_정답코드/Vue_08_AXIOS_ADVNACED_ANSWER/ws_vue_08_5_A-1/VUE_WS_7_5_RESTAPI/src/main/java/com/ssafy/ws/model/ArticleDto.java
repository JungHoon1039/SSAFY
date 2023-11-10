package com.ssafy.ws.model;

import java.util.List;

public class ArticleDto {
	private int articleId, viewCnt, likeCnt, dislikeCnt;
	private int totalCommentCnt, totalLikeCnt;

	private int lft, rgt, depth;
	private int userSeq;
	private String title, content, boardId, userId;
	private String boardName;
	private String createdAt, modifiedAt;
	private String userName, userNickname;
	private String currentPage;
	private List<FileDto> fileList;
	private int maxRgt, maxLft, targetLft, targetRgt, targetDepth;
	
	
	public String getBoardName() {
		return boardName;
	}
	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}
	public int getTotalCommentCnt() {
		return totalCommentCnt;
	}
	public void setTotalCommentCnt(int totalCommentCnt) {
		this.totalCommentCnt = totalCommentCnt;
	}
	public int getTotalLikeCnt() {
		return totalLikeCnt;
	}
	public void setTotalLikeCnt(int totalLikeCnt) {
		this.totalLikeCnt = totalLikeCnt;
	}

		
	public int getUserSeq() {
		return userSeq;
	}
	public void setUserSeq(int userSeq) {
		this.userSeq = userSeq;
	}
	public int getMaxRgt() {
		return maxRgt;
	}
	public void setMaxRgt(int maxRgt) {
		this.maxRgt = maxRgt;
	}
	public int getMaxLft() {
		return maxLft;
	}
	public void setMaxLft(int maxLft) {
		this.maxLft = maxLft;
	}
	public int getTargetLft() {
		return targetLft;
	}
	public void setTargetLft(int targetLft) {
		this.targetLft = targetLft;
	}
	public int getTargetRgt() {
		return targetRgt;
	}
	public void setTargetRgt(int targetRgt) {
		this.targetRgt = targetRgt;
	}
	public int getTargetDepth() {
		return targetDepth;
	}
	public void setTargetDepth(int targetDepth) {
		this.targetDepth = targetDepth;
	}
	public String getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(String currentPage) {
		this.currentPage = currentPage;
	}
	public List<FileDto> getFileList() {
		return fileList;
	}
	public void setFileList(List<FileDto> fileList) {
		this.fileList = fileList;
	}
	
	public int getLft() {
		return lft;
	}
	public void setLft(int lft) {
		this.lft = lft;
	}
	public int getRgt() {
		return rgt;
	}
	public void setRgt(int rgt) {
		this.rgt = rgt;
	}
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getUserNickname() {
		return userNickname;
	}
	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}
	
	public int getArticleId() {
		return articleId;
	}
	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}
	public int getViewCnt() {
		return viewCnt;
	}
	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}
	public int getLikeCnt() {
		return likeCnt;
	}
	public void setLikeCnt(int likeCnt) {
		this.likeCnt = likeCnt;
	}
	public int getDislikeCnt() {
		return dislikeCnt;
	}
	public void setDislikeCnt(int dislikeCnt) {
		this.dislikeCnt = dislikeCnt;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getBoardId() {
		return boardId;
	}
	public void setBoardId(String boardId) {
		this.boardId = boardId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	public String getModifiedAt() {
		return modifiedAt;
	}
	public void setModifiedAt(String modifiedAt) {
		this.modifiedAt = modifiedAt;
	}
	
	
	@Override
	public String toString() {
		return "ArticleDto [articleId=" + articleId + ", viewCnt=" + viewCnt + ", likeCnt=" + likeCnt + ", dislikeCnt="
				+ dislikeCnt + ", lft=" + lft + ", rgt=" + rgt + ", depth=" + depth + ", userSeq=" + userSeq
				+ ", title=" + title + ", content=" + content + ", boardId=" + boardId + ", userId=" + userId
				+ ", createdAt=" + createdAt + ", modifiedAt=" + modifiedAt + ", userName=" + userName
				+ ", userNickname=" + userNickname + ", currentPage=" + currentPage + ", fileList=" + fileList
				+ ", maxRgt=" + maxRgt + ", maxLft=" + maxLft + ", targetLft=" + targetLft + ", targetRgt=" + targetRgt
				+ ", targetDepth=" + targetDepth + "]";
	}
}
