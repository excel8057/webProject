package com.mvc.reply.vo;

public class ReplyVO { 
	private int    replyNumber     = 0;  //댓글번호
	private int    num     	       = 0;  //게시판 글번호
	private String replyName       = ""; //댓글 작성자  
	private String replyContent    = ""; //댓글 내용 
	private String replyDate       = ""; //댓글 작성일 
	private String replyPwd        = ""; //댓글 비밀번호 
	
	public int getReplyNumber() {
		return replyNumber;
	}
	public void setReplyNumber(int replyNumber) {
		this.replyNumber = replyNumber;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getReplyName() {
		return replyName;
	}
	public void setReplyName(String replyName) {
		this.replyName = replyName;
	}
	public String getReplyContent() {
		return replyContent;
	}
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	public String getReplyDate() {
		return replyDate;
	}
	public void setReplyDate(String replyDate) {
		this.replyDate = replyDate;
	}
	public String getReplyPwd() {
		return replyPwd;
	}
	public void setReplyPwd(String replyPwd) {
		this.replyPwd = replyPwd;
	}
	@Override
	public String toString() {
		return "ReplyVO [replyNumber=" + replyNumber + ", num=" + num + ", replyName=" + replyName + ", replyContent="
				+ replyContent + ", replyDate=" + replyDate + ", replyPwd=" + replyPwd + "]";
	}
	
    // 설정자, 접근자, toString() 메서드 선언.
}