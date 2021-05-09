package com.jin.Membership;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
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
	private IMemberDao iMemberDao;  //Dao와 연결
	private final int EXISTID = 1; //select 조회값 1인경우***
	final String AUTHCONFIRMOK = "인증 성공하였습니다.";
	final String REAUTHCONFIRMOK = "이미 "+AUTHCONFIRMOK+"를 받으셨습니다.";
	final String AUTHCONFIRMFAILD = "인증 실패하였습니다.";
	final String NOAUTHNUMBER = "인증번호가 존재하지 않습니다.";
	
	private String randNum;
	
	@Override
	public String isExistID(Login login) {
		if(iMemberDao.isExistID(login.getId())==EXISTID) { // select해봤더니 값이 있다는 얘기
			return "중복된 아이디 입니다"; //return하면 메소드가 끝나니 따로 else는 구현하지않음
		}
		
		return "사용가능한 아이디입니다";
	}
	
	@Override
	public void sendAuth(Member member, HttpSession session) {
		
		Random rand = new Random();
		String authNum = String.format("%04d", rand.nextInt(10000));
		
		
		if(authNum==null || "".contentEquals(authNum)) {//인증받은적 없거나, 이미 받은게 있는경우
			this.randNum = randNum;
			session.setAttribute(authNum, randNum);
			session.setMaxInactiveInterval(180);//3분만료		
		}
//		return randNum;
	}
	//세션은 컨트롤러쪽으로 전달되고, 컨트롤러 통해서 전달 받아야함.
	@Override
	public String authConfirm(String authNum ,HttpSession session) {
		String sAuthNum = (String) session.getAttribute("authNum");
		if(sAuthNum==null || "".contentEquals(sAuthNum)) return "인증번호를 요청하세요";
		if(sAuthNum!=authNum)//인증번호 틀린경우
			return AUTHCONFIRMFAILD;
	
		if("".contentEquals(authNum))//인증번호 존재 안함 = 요청안함
			return NOAUTHNUMBER;
		
//		session.isComplete();
		
		return AUTHCONFIRMOK;//인증성공
	}


	@Override
	public void MemberProc(Member member, Postcode postcode) {
		SHA sha = new SHA();
		logger.warn(member.getPw()); //입력된 패스워드
		logger.warn(sha.encryptSHA512(member.getPw()));//암호화된 패스워드 > 이걸 DB에 넣어야함
		
//		String id = member.getId();
//		String pw = sha.encryptSHA512(member.getPw());
//		iMemberDao.InsertLogin(id, pw);
		
		
		logger.warn(postcode.getAdd1());//빈값을 보냈을때 어떻게 처리해오나 체크
		logger.warn(postcode.getAdd2());
		
		Login login = new Login();
		login.setId(member.getId());
		login.setPw(sha.encryptSHA512(member.getPw()));
				
		//Login login = member; //Login이라는 틀에 member안의 login에대한 값만 상속받은 상위클래스로 전달한다.
		iMemberDao.InsertLogin(login);
		
		String gender = member.getGender();
		if(!"n".contentEquals(gender)) {
			iMemberDao.InsertMember(member);
		}
		if(!"".contentEquals(postcode.getZipcode())) {
			iMemberDao.InsertPostcode(postcode);
		}	
		
	}
 //LoginDTO를 상속받은 Memberdto로 입력받아 온 값을 다시 SHA하여 LoginDTO로 넣어준다. 	

	
	
	@Override
	public List<Zipcode> Searchzipcode(String addr) {
		
		return iMemberDao.SearchZipcode(addr);
	}



	







}
