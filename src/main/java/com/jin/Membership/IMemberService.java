package com.jin.Membership;

import java.util.List;

import org.springframework.web.bind.support.SessionStatus;

public interface IMemberService<zip> {
		public String isExistID(Login login);
		public String sendAuth(Member member);
		public String authConfirm(String authNum,String sAuthNum ,SessionStatus session);

		public void MemberProc(Member member);
		public List<Zipcode> Searchzipcode(String addr);
		
		
}
