package com.jin.Membership;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements IMemberService{

	private static final Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);
	@Autowired
	private IMemberDao iMemberDao;  //Dao와 연결
	private final int EXISTID = 1; //select 조회값 1인경우***
	
	@Override
	public String isExistID(Login login) {
		if(iMemberDao.isExistID(login.getId())==EXISTID) { // select해봤더니 값이 있다는 얘기
			return "중복된 아이디 입니다"; //return하면 메소드가 끝나니 따로 else는 구현하지않음
		}
				
		return "사용가능한 아이디입니다";
	}

}
