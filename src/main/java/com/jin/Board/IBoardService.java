package com.jin.Board;

import java.util.List;

import com.jin.Membership.Login;

public interface IBoardService {
	public List<Board> BoardLst(Board board, Login login);

	public void InsertBoard(Board board);

	public void UpdateWrite(Board board);
}
