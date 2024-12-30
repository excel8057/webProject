package com.mvc.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.board.service.BoardService;
import com.mvc.board.service.BoardServiceImpl;
import com.mvc.board.vo.BoardVO;
import com.mvc.common.controller.Controller;

public class DetailBoardController implements Controller {
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		BoardVO boardVO = new BoardVO();
		boardVO.setNum(Integer.parseInt(request.getParameter("num"))); // 게시글의 글번호
		
		BoardService service = BoardServiceImpl.getInstance();
		service.readcntUpdate(boardVO); // 조회수 증가
		BoardVO data = service.boardDetail(boardVO); // 글번호에 해당하는 레코드 조회
		
		request.setAttribute("detail", data);
		
		return "/board/detailBoard";
	}
}