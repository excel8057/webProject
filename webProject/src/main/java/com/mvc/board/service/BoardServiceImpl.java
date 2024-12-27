package com.mvc.board.service;

import java.util.List;

import com.mvc.board.dao.BoardDAO;
import com.mvc.board.vo.BoardVO;

public class BoardServiceImpl implements BoardService {
	private static BoardServiceImpl service = null;
	
	private BoardDAO dao = BoardDAO.getInstance();
	
	private BoardServiceImpl(){ }
	public static BoardServiceImpl getInstance() {
		if(service == null) {
			service = new BoardServiceImpl();
		}
		return service;
	}
	
	@Override
	 public List<BoardVO> boardList(BoardVO vo) {
		List<BoardVO> list = dao.boardList(vo);
		return list;
	}
}