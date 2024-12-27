package com.mvc.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.board.service.BoardService;
import com.mvc.board.service.BoardServiceImpl;
import com.mvc.board.vo.BoardVO;
import com.mvc.common.controller.Controller;

public class GetBoardListController implements Controller {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		BoardVO vo = null;

		BoardService service = BoardServiceImpl.getInstance();
		List<BoardVO> list = service.boardList(vo); 

		request.setAttribute("list", list);

		//jsp 페이지에서 사용방법은 ${requestScope.list}
		return "/board/getBoardList";
	}
}