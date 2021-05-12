package com.jin.Board;

import java.sql.Date;

//게시판 
public class Board {
	// 글번호
	private Integer no;
	// 작성자
	private String id;
	// 제목
	private String title;
	// 내용
	private String contents;
	// 작성일
	private Date writedate;

	public Integer getNo() {
		return no;
	}

	public void setNo(Integer no) {
		this.no = no;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public Date getWritedate() {
		return writedate;
	}

	public void setWritedate(Date writedate) {
		this.writedate = writedate;
	}
}