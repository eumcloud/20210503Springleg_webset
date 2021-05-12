package com.jin.Membership;

//회원 정보 
public class Postcode {
	// 순번
	private Integer no;
	// 우편번호
	private String zipcode;
	// 주소
	private String addr1;
	// 상세주소
	private String addr2;
	// 아이디
	private String id;

	public Integer getNo() {
		return no;
	}

	public void setNo(Integer no) {
		this.no = no;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getAddr1() {
		return addr1;
	}

	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}

	public String getAddr2() {
		return addr2;
	}

	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}