package com.dashboard.beans;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CommentBean {
	
	@Id
	private int auto;
	private int type = 0;
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	private int postId;
	public int getAuto() {
		return auto;
	}
	public void setAuto(int auto) {
		this.auto = auto;
	}
	private int commentId;
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	

}
