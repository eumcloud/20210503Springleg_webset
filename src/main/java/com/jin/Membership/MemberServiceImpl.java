package com.jin.Membership;

import java.util.Random;

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
	
	private String randNum;
	
	@Override
	public String isExistID(Login login) {
		if(iMemberDao.isExistID(login.getId())==EXISTID) { // select해봤더니 값이 있다는 얘기
			return "중복된 아이디 입니다"; //return하면 메소드가 끝나니 따로 else는 구현하지않음
		}
		
		return "사용가능한 아이디입니다";
	}


	@Override
	public String sendAuth(Member member) {
		
		Random rand = new Random();
		String authNum = String.format("%04d", rand.nextInt(10000));
		this.randNum = randNum;
//		sendEmail(member.getEmail(), randNum);
		
		
		return "forward:index?formpath=member";
	}

	//세션은 컨트롤러쪽으로 전달되고, 컨트롤러 통해서 전달 받아야함.
	
	@Override
	public String authConfirm(String authNum,String sAuthNum ,SessionStatus session) {

		/*
		 * 1.인증번호 시간 확인
		 * 2.인증번호와 입력된 번호 확인
		 * 위의 둘 중 하나라도 만족한다면 session 종료
		 */
//		logger.warn(randNum);
		session.isComplete();
		
		return "인증번호 확인";
	}


	@Override
	public void MemberProc(Member member) {
		SHA sha = new SHA();
		logger.warn(member.getPw()); //입력된 패스워드
		logger.warn(sha.encryptSHA512(member.getPw()));//암호화된 패스워드 > 이걸 DB에 넣어야함
		
//		String id = member.getId();
//		String pw = sha.encryptSHA512(member.getPw());
//		iMemberDao.InsertLogin(id, pw);
		
		
		Login login = new Login();
		login.setId(member.getId());
		login.setPw(sha.encryptSHA512(member.getPw()));
				
		//Login login = member; //Login이라는 틀에 member안의 login에대한 값만 상속받은 상위클래스로 전달한다.
		iMemberDao.InsertLogin(login);
		
		String gender = member.getGender();
		if(!"n".contentEquals(gender)) {
			iMemberDao.InsertMember(member);
		}
			
		
	}
 //LoginDTO를 상속받은 Memberdto로 입력받아 온 값을 다시 SHA하여 LoginDTO로 넣어준다. 	

}
