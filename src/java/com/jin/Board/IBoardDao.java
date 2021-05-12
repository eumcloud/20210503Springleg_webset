package com.jin.Board;

import java.util.Map;

public interface IBoardDao {
	public int Write(Board board);
	public void AttachFile(Map<String, String> fileMap);
}
