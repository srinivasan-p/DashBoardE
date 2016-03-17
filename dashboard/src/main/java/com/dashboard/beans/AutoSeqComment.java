package com.dashboard.beans;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AutoSeqComment {
	
	@Id
	private int seqToComment;

	public int getSeqToComment() {
		return seqToComment;
	}

	public void setSeqToComment(int seqToComment) {
		this.seqToComment = seqToComment;
	}
	

}
