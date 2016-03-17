package com.dashboard.beans;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class AutoSeqPost {
	
	@Id
	private int seqToPost;

	public int getSeqToPost() {
		return seqToPost;
	}

	public void setSeqToPost(int seqToPost) {
		this.seqToPost = seqToPost;
	}
	

}
