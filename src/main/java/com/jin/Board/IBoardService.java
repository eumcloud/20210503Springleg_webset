package com.jin.Board;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.jin.Membership.Login;
import com.jin.Membership.Member;

public interface IBoardService {
	public List<Board> BoardLst(Board board, Login login);

	public void InsertBoard(Board board);

	public boolean UpdateWrite(Board board, HttpSession session, Member member);

	public boolean DeleteWrite(Board board, HttpSession session, Member member);

	
}
