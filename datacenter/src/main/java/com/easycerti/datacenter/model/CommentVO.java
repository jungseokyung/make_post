package com.easycerti.datacenter.model;

import java.util.Date;

public class CommentVO {

	private int cno;
	private int bno;
	private String comment;
	private String writer;
	private String user_id;
	private Date regdate;

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public int getCno() {
		return cno;
	}

	public void setCno(int cno) {
		this.cno = cno;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
	public String toString() {
		return "BoardVO [bno=" + bno + ", cno=" + cno + ", comment=" + comment 
				+ ", writer=" + writer + ", user_id=" + user_id + ", regdate=" + regdate + "]"; 
	}
}
