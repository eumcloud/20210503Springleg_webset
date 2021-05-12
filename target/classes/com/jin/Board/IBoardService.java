package com.jin.Board;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public interface IBoardService {
	public void Write(Board board, HttpServletRequest request);

	public List<Board> SelectBoard();
	public Board DetailRead(String writeNo);
}