package com.jin.Board;

import java.util.List;

import com.jin.Membership.Login;

public interface IBoardService {
	public List<Board> BoardLst(Login login);

	public void InsertBoard(Board board);
}
