package com.jin.Board;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WriteServiceImpl implements IWriteService{

	@Autowired IWriteDao Dao;
	
	@Override
	public Board writeProc(Board board) {
		Date writedate = new Date(System.currentTimeMillis());
		Dao.Insert(board);
		
		return board;
	}

}
