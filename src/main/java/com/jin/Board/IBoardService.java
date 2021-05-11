package com.jin.Board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.jin.Membership.Login;
import com.jin.Membership.Member;

public interface IBoardService {
	public List<Board> BoardLst(Board board, Login login);

	public void write(Board board);
	public boolean DeleteWrite(Board board, HttpSession session, Member member);

	

	
}
