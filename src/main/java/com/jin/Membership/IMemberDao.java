package com.jin.Membership;

import java.util.List;

public interface IMemberDao {
	public int isExistID(String id);
	//Dao에서는 순수 조회해서 있는지 없는지 값만 필요하기 때문에 int로 받는다
	
	public void InsertLogin(String id, String pw);

	public void InsertLogin(Login login);
//	public void InsertLogin(Member member);

	public void InsertMember(Member member);
	
	public void addrSelect(String addr);

	public List<Zipcode> SearchZipcode(String addr);
}
