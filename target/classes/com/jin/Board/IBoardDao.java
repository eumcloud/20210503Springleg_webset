package com.jin.Board;

import java.util.List;
import java.util.Map;

public interface IBoardDao {
	public int Write(Board board);

	public List<Board> SelectBoard();
	public List<Map<String, Object>> DeatilReadAttach(String writeNo); //Ŭ���� ����ȯ ������ ������, ���Ŀ� ���ֹ��� �ʴ� �ֻ���Object�� ���
	public Board DetailRead(String writeNo);
	public void AttachFile(Map<String, String> fileMap);
	public void UpdateContetns(String writeNo);
	public void DeleteContents(String writeNo);

	public void REPL(Board board);
	
}
