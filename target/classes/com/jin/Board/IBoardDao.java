package com.jin.Board;

import java.util.List;
import java.util.Map;

public interface IBoardDao {
	public int Write(Board board);

	public List<Board> SelectBoard();
	public List<Map<String, Object>> DeatilReadAttach(String writeNo); //클래스 형변환 에러가 떴을때, 형식에 구애받지 않는 최상위Object를 사용
	public Board DetailRead(String writeNo);
	public void AttachFile(Map<String, String> fileMap);
	public void UpdateContetns(String writeNo);
	public void DeleteContents(String writeNo);

	public void REPL(Board board);
	
}
