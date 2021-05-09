package com.jin.Membership;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.support.SessionStatus;

public interface IMemberService<zip> {
		public String isExistID(Login login);
		public void sendAuth(Member member, HttpSession session);
		public String authConfirm(String authNum,HttpSession session);

//		public void MemberProc(Member member);
		public List<Zipcode> Searchzipcode(String addr);
		public void MemberProc(Member member, Postcode postcode);
		
		
		
		
}
