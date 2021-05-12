package com.jin.Board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

public interface IBoardService {
	public void Write(Board board, HttpServletRequest request);

	public List<Board> SelectBoard();

	public List<Board> SelectContetns(int no);
}
