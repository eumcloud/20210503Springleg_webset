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
	private IMemberDao iMemberDao;  //Dao�� ����
	private final int EXISTID = 1; //select ��ȸ�� 1�ΰ��***
	
	private String randNum;
	
	@Override
	public String isExistID(Login login) {
		if(iMemberDao.isExistID(login.getId())==EXISTID) { // select�غô��� ���� �ִٴ� ���
			return "�ߺ��� ���̵� �Դϴ�"; //return�ϸ� �޼ҵ尡 ������ ���� else�� ������������
		}
		
		return "��밡���� ���̵��Դϴ�";
	}


	@Override
	public String sendAuth(Member member) {
		
		Random rand = new Random();
		String authNum = String.format("%04d", rand.nextInt(10000));
		this.randNum = randNum;
//		sendEmail(member.getEmail(), randNum);
		
		
		return "forward:index?formpath=member";
	}

	//������ ��Ʈ�ѷ������� ���޵ǰ�, ��Ʈ�ѷ� ���ؼ� ���� �޾ƾ���.
	
	@Override
	public String authConfirm(String authNum,String sAuthNum ,SessionStatus session) {

		/*
		 * 1.������ȣ �ð� Ȯ��
		 * 2.������ȣ�� �Էµ� ��ȣ Ȯ��
		 * ���� �� �� �ϳ��� �����Ѵٸ� session ����
		 */
//		logger.warn(randNum);
		session.isComplete();
		
		return "������ȣ Ȯ��";
	}


	@Override
	public void MemberProc(Member member) {
		SHA sha = new SHA();
		logger.warn(member.getPw()); //�Էµ� �н�����
		logger.warn(sha.encryptSHA512(member.getPw()));//��ȣȭ�� �н����� > �̰� DB�� �־����
		
//		String id = member.getId();
//		String pw = sha.encryptSHA512(member.getPw());
//		iMemberDao.InsertLogin(id, pw);
		
		
		Login login = new Login();
		login.setId(member.getId());
		login.setPw(sha.encryptSHA512(member.getPw()));
				
		//Login login = member; //Login�̶�� Ʋ�� member���� login������ ���� ��ӹ��� ����Ŭ������ �����Ѵ�.
		iMemberDao.InsertLogin(login);
		
		String gender = member.getGender();
		if(!"n".contentEquals(gender)) {
			iMemberDao.InsertMember(member);
		}
			
		
	}
 //LoginDTO�� ��ӹ��� Memberdto�� �Է¹޾� �� ���� �ٽ� SHA�Ͽ� LoginDTO�� �־��ش�. 	

}
