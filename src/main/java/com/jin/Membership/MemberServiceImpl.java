package com.jin.Membership;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements IMemberService{

	private static final Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);
	
	@Override
	public String isExistID(Login login) {
		
		return "사용가능한 아이디입니다";
	}

}
