package com.jin.Membership;

//로그인 
public class Login {

 // 아이디 
 private String id;

 // 패스워드 
 private String pw;

 public String getId() {
     return id;
 }

 public void setId(String id) {
     this.id = id;
 }

 public String getPw() {
     return pw;
 }

 public void setPw(String pw) {
     this.pw = pw;
 }

 // Login 모델 복사
 public void CopyData(Login param)
 {
     this.id = param.getId();
     this.pw = param.getPw();
 }
}