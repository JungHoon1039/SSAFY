package com.ssafy.ws.model;

public class CommentDto {
	private int commentId;
	private String content;
	private int likeCnt;
	private int dislikeCnt;
	private int totalLikeCnt;
	private int totalDislikeCnt;
	private int userSeq;
	private String userName;
	private String nickname;
	private int articleId;
	private String boardId;
	private String boardName;
	private int lft;
	private int rgt;
	private int depth;
	private String createdAt;
	
	
	
	public String getBoardName() {
		return boardName;
	}
	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
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
	public int getUserSeq() {
		return userSeq;
	}
	public void setUserSeq(int userSeq) {
		this.userSeq = userSeq;
	}
	public int getArticleId() {
		return articleId;
	}
	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}
	public String getBoardId() {
		return boardId;
	}
	public void setBoardId(String boardId) {
		this.boardId = boardId;
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
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	
	public int getTotalLikeCnt() {
		return totalLikeCnt;
	}
	public void setTotalLikeCnt(int totalLikeCnt) {
		this.totalLikeCnt = totalLikeCnt;
	}
	public int getTotalDislikeCnt() {
		return totalDislikeCnt;
	}
	public void setTotalDislikeCnt(int totalDislikeCnt) {
		this.totalDislikeCnt = totalDislikeCnt;
	}
	
	@Override
	public String toString() {
		return "CommentDto [commentId=" + commentId + ", content=" + content + ", likeCnt=" + likeCnt + ", dislikeCnt="
				+ dislikeCnt + ", userSeq=" + userSeq + ", articleId=" + articleId + ", boardId=" + boardId + ", lft="
				+ lft + ", rgt=" + rgt + ", depth=" + depth + ", createdAt=" + createdAt + "]";
	}	
}
