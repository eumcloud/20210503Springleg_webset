package com.jin.Membership;

import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.support.SessionStatus;

import com.jin.mail.SHA;

@Service
public class MemberServiceImpl implements IMemberService{
	private static final Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);
	@Autowired
	private IMemberDao iMemberDao;
	private final int EXISTID = 1;
	
	@Autowired private HttpSession session;

	@Override
	public String IsExistID(Login login) {
		if(iMemberDao.IsExistID(login.getId())==EXISTID)
			return "중복된 아이디입니다.";
		return "사용 가능한 아이디 입니다.";
	}
	@Override
	public void sendAuth(Member member) {
		String authNum = (String)session.getAttribute("authNum");
		
		if (authNum == null ) {
			Random rand = new Random();
			String randNum = String.format("%04d", rand.nextInt(10000));
			
			session.setAttribute("authNum", randNum);
			session.setMaxInactiveInterval(180);
			logger.warn(randNum);
		}
	}
	@Override
	public String authConfirm(String authNum) {
		String sAuthNum = (String)session.getAttribute("authNum");

		if (sAuthNum == null)	return "인증번호를 생성하세요";

		if(authNum.contentEquals(sAuthNum)) {
			session.setAttribute("authState", true);
			return "인증 완료";
		}

		return "인증 실패";
	}
	@Override
	public String MemberProc(Member member, Postcode postcode) {
		Boolean authState = (Boolean)session.getAttribute("authState");
		if(!authState)	return "인증을 진행해야 합니다.";

		SHA sha = new SHA();

		Login login = member;
		login.setPw(sha.encryptSHA512(member.getPw()));
		
		iMemberDao.InsertLogin(login);
		//선택사항 입력
		if(!"n".contentEquals( member.getGender() ))
			iMemberDao.InsertMember(member);
		if(!"".contentEquals( postcode.getZipcode() ))
			iMemberDao.InsertPostcode(postcode);
		
		return "";	
	}
	@Override
	public List<Zipcode> SearchZipcode(String addr) {
		return iMemberDao.SearchZipcode(addr);
	}
	
}
