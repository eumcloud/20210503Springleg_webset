package com.jin.Membership;

public interface IMemberDao {
	public int isExistID(String id);
	//Dao������ ���� ��ȸ�ؼ� �ִ��� ������ ���� �ʿ��ϱ� ������ int�� �޴´�
	
	public void InsertLogin(String id, String pw);

	public void InsertLogin(Login login);
}
