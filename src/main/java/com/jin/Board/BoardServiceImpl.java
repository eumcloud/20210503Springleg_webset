package com.jin.Board;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jin.Membership.Login;
import com.jin.Membership.Member;

@Service
public class BoardServiceImpl implements IBoardService{

	@Autowired
	private IBoardDao Dao;
	private List<Board> BoardLst;

	@Override
	public List<Board> BoardLst(Board board, Login login) {
		
		Dao.SelectBoard(login);
		return BoardLst;
	}
	
	@Override
	public void InsertBoard(Board board){
		Dao.InsertBoard(board);
	}
	@Override
	public boolean UpdateWrite(Board board, HttpSession session, Member member) {
		
		String id = (String) session.getAttribute(member.getId());
		String idchk = Dao.SelectBoardId(board);
		if(id.contentEquals(idchk)) {Dao.UpdateWrite(board); return true;}
		return false;
	}
	
	
	@Override
	public boolean DeleteWrite(Board board, HttpSession session,Member member) {
		//삭제를 원하는 글이 로그인id와 맞을경우에 진행
		
		String id = (String) session.getAttribute(member.getId());
		String idchk = Dao.SelectBoardId(board);
		if(id.contentEquals(idchk)){Dao.DeleteWrite(board); return true;}
		
		
		return false;
	}

}
