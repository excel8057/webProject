package com.mvc.board.service;

import java.util.List;

import com.mvc.board.dao.BoardMapper;
import com.mvc.board.dao.BoardMapperImpl;
import com.mvc.board.vo.BoardVO;

public class BoardServiceImpl implements BoardService {
    private BoardMapper mapper = new BoardMapperImpl();

	private static BoardServiceImpl service = null;
	private BoardServiceImpl(){ }
	public static BoardServiceImpl getInstance() {
		if(service == null) {
			service = new BoardServiceImpl();
		}
		return service;
	}
	
	public List<BoardVO> boardList(BoardVO vo){
		List<BoardVO> boardList = mapper.boardList(vo);
		return boardList;
	}
	@Override
	public int boardInsert(BoardVO vo){
			int result = mapper.boardInsert(vo);
			return result;
	}
	@Override
	public void readcntUpdate(BoardVO vo){
		mapper.readcntUpdate(vo);
	}
		
	@Override
	public BoardVO boardDetail(BoardVO vo){
		BoardVO boardVO = mapper.boardDetail(vo);
		boardVO.setContent(boardVO.getContent().replaceAll("\n", "<br />"));
		return boardVO;
	}
	@Override
	public BoardVO updateForm(BoardVO vo) {
		BoardVO boardVO = mapper.boardDetail(vo);
		boardVO.setContent(boardVO.getContent().replaceAll("<br />", "\n"));
		return boardVO;
	}
}