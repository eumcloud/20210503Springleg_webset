package com.jin.Membership;

//ȸ������ 
public class Member {

 // ���� 
 private Integer no;

 // �����ȣ 
 private String zipcode;

 // �ּ� 
 private String add1;

 // ���ּ� 
 private String add2;

 // ���̵� 
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

 public String getAdd1() {
     return add1;
 }

 public void setAdd1(String add1) {
     this.add1 = add1;
 }

 public String getAdd2() {
     return add2;
 }

 public void setAdd2(String add2) {
     this.add2 = add2;
 }

 public String getId() {
     return id;
 }

 public void setId(String id) {
     this.id = id;
 }

 // Member �� ����
 public void CopyData(Member param)
 {
     this.no = param.getNo();
     this.zipcode = param.getZipcode();
     this.add1 = param.getAdd1();
     this.add2 = param.getAdd2();
     this.id = param.getId();
 }
}
