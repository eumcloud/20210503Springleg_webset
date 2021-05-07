package com.jin.Membership;

import java.util.List;

public interface IMemberDao {
	public int isExistID(String id);
	//Dao������ ���� ��ȸ�ؼ� �ִ��� ������ ���� �ʿ��ϱ� ������ int�� �޴´�
	
	public void InsertLogin(String id, String pw);

	public void InsertLogin(Login login);
//	public void InsertLogin(Member member);

	public void InsertMember(Member member);
	
	public void addrSelect(String addr);

	public List<Zipcode> SearchZipcode(String addr);
}
