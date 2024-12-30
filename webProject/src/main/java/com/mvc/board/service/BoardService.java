package com.mvc.board.service;

import java.util.List;
import com.mvc.board.vo.BoardVO;

public interface BoardService {
	public List<BoardVO> boardList(BoardVO vo);
	public int boardInsert(BoardVO vo);
	
	public void readcntUpdate(BoardVO vo);
	public BoardVO boardDetail(BoardVO vo);
	
	public BoardVO updateForm(BoardVO vo);
}