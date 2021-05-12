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
			return "�ߺ��� ���̵��Դϴ�.";
		return "��� ������ ���̵� �Դϴ�.";
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

		if (sAuthNum == null)	return "������ȣ�� �����ϼ���";

		if(authNum.contentEquals(sAuthNum)) {
			session.setAttribute("authState", true);
			return "���� �Ϸ�";
		}

		return "���� ����";
	}
	@Override
	public String MemberProc(Member member, Postcode postcode) {
		Boolean authState = (Boolean)session.getAttribute("authState");
		if(!authState)	return "������ �����ؾ� �մϴ�.";

		SHA sha = new SHA();

		Login login = member;
		login.setPw(sha.encryptSHA512(member.getPw()));
		
		iMemberDao.InsertLogin(login);
		//���û��� �Է�
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
