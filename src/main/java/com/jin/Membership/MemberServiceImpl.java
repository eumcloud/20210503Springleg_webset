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
	private IMemberDao iMemberDao;  //Dao�� ����
	private final int EXISTID = 1; //select ��ȸ�� 1�ΰ��***
	final String AUTHCONFIRMOK = "���� �����Ͽ����ϴ�.";
	final String REAUTHCONFIRMOK = "�̹� "+AUTHCONFIRMOK+"�� �����̽��ϴ�.";
	final String AUTHCONFIRMFAILD = "���� �����Ͽ����ϴ�.";
	final String NOAUTHNUMBER = "������ȣ�� �������� �ʽ��ϴ�.";
	
	private String randNum;
	
	@Override
	public String isExistID(Login login) {
		if(iMemberDao.isExistID(login.getId())==EXISTID) { // select�غô��� ���� �ִٴ� ���
			return "�ߺ��� ���̵� �Դϴ�"; //return�ϸ� �޼ҵ尡 ������ ���� else�� ������������
		}
		
		return "��밡���� ���̵��Դϴ�";
	}
	
	@Override
	public void sendAuth(Member member, HttpSession session) {
		
		Random rand = new Random();
		String authNum = String.format("%04d", rand.nextInt(10000));
		
		
		if(authNum==null || "".contentEquals(authNum)) {//���������� ���ų�, �̹� ������ �ִ°��
			this.randNum = randNum;
			session.setAttribute(authNum, randNum);
			session.setMaxInactiveInterval(180);//3�и���		
		}
//		return randNum;
	}
	//������ ��Ʈ�ѷ������� ���޵ǰ�, ��Ʈ�ѷ� ���ؼ� ���� �޾ƾ���.
	@Override
	public String authConfirm(String authNum ,HttpSession session) {
		String sAuthNum = (String) session.getAttribute("authNum");
		if(sAuthNum==null || "".contentEquals(sAuthNum)) return "������ȣ�� ��û�ϼ���";
		if(sAuthNum!=authNum)//������ȣ Ʋ�����
			return AUTHCONFIRMFAILD;
	
		if("".contentEquals(authNum))//������ȣ ���� ���� = ��û����
			return NOAUTHNUMBER;
		
//		session.isComplete();
		
		return AUTHCONFIRMOK;//��������
	}


	@Override
	public void MemberProc(Member member, Postcode postcode) {
		SHA sha = new SHA();
		logger.warn(member.getPw()); //�Էµ� �н�����
		logger.warn(sha.encryptSHA512(member.getPw()));//��ȣȭ�� �н����� > �̰� DB�� �־����
		
//		String id = member.getId();
//		String pw = sha.encryptSHA512(member.getPw());
//		iMemberDao.InsertLogin(id, pw);
		
		
		logger.warn(postcode.getAdd1());//���� �������� ��� ó���ؿ��� üũ
		logger.warn(postcode.getAdd2());
		
		Login login = new Login();
		login.setId(member.getId());
		login.setPw(sha.encryptSHA512(member.getPw()));
				
		//Login login = member; //Login�̶�� Ʋ�� member���� login������ ���� ��ӹ��� ����Ŭ������ �����Ѵ�.
		iMemberDao.InsertLogin(login);
		
		String gender = member.getGender();
		if(!"n".contentEquals(gender)) {
			iMemberDao.InsertMember(member);
		}
		if(!"".contentEquals(postcode.getZipcode())) {
			iMemberDao.InsertPostcode(postcode);
		}	
		
	}
 //LoginDTO�� ��ӹ��� Memberdto�� �Է¹޾� �� ���� �ٽ� SHA�Ͽ� LoginDTO�� �־��ش�. 	

	
	
	@Override
	public List<Zipcode> Searchzipcode(String addr) {
		
		return iMemberDao.SearchZipcode(addr);
	}



	







}
