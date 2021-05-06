package com.jin.Membership;

import org.springframework.web.bind.support.SessionStatus;

public interface IMemberService {
		public String isExistID(Login login);
		public String sendAuth(Member member);
		public String authConfirm(String authNum,String sAuthNum ,SessionStatus session);
		public void MemberProc(Login login);
		public void MemberProc(Member member);
}
