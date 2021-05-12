package com.jin.Board;

import javax.servlet.http.HttpServletRequest;

public interface IBoardService {
	public void Write(Board board, HttpServletRequest request);
}
