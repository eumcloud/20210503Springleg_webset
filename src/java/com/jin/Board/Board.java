package com.jin.Board;

import java.sql.Date;

//�Խ��� 
public class Board {
	// �۹�ȣ
	private Integer no;
	// �ۼ���
	private String id;
	// ����
	private String title;
	// ����
	private String contents;
	// �ۼ���
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