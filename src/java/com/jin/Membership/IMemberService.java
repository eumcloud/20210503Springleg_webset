package com.jin.Membership;

import java.util.List;

import org.springframework.web.bind.support.SessionStatus;

public interface IMemberService {
	public String IsExistID(Login login);
	public void sendAuth(Member member);
	public String authConfirm(String authNum/* , HttpSession session */);
	public String MemberProc(Member member, Postcode postcode);
	public List<Zipcode> SearchZipcode(String addr);
}
