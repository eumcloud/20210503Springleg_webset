package com.jin.Board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jin.Membership.Login;

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
	public void UpdateWrite(Board board) {
		Dao.UpdateWrite(board);
	}

}
