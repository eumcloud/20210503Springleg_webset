package com.jin.Board;

import com.jin.Membership.Login;

public interface IBoardDao {
	public void SelectBoard(Login login);
	public void InsertBoard(Board board);
	public void UpdateWrite(Board board);
	public void DeleteWrite(Board board);
	public String SelectBoardId(Board board);
}
