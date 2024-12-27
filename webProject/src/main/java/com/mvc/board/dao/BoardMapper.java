package com.mvc.board.dao;

import java.util.List;

import com.mvc.board.vo.BoardVO;

public interface BoardMapper {
	public List<BoardVO> boardList(BoardVO vo);
}