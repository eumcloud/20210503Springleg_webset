package com.jin.Membership;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements IMemberService{

	private static final Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);
	@Autowired
	private IMemberDao iMemberDao;  //Dao�� ����
	private final int EXISTID = 1; //select ��ȸ�� 1�ΰ��***
	
	@Override
	public String isExistID(Login login) {
		if(iMemberDao.isExistID(login.getId())==EXISTID) { // select�غô��� ���� �ִٴ� ���
			return "�ߺ��� ���̵� �Դϴ�"; //return�ϸ� �޼ҵ尡 ������ ���� else�� ������������
		}
				
		return "��밡���� ���̵��Դϴ�";
	}

}
