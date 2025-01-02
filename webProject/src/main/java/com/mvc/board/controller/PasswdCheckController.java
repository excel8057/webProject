package com.mvc.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.board.service.BoardService;
import com.mvc.board.service.BoardServiceImpl;
import com.mvc.board.vo.BoardVO;
import com.mvc.common.controller.Controller;


public class PasswdCheckController implements Controller {

	public String execute(HttpServletRequest request, HttpServletResponse response) {
		BoardVO vo = new BoardVO();
		vo.setNum(Integer.parseInt(request.getParameter("num")));
		vo.setPasswd(request.getParameter("passwd"));

		BoardService service = BoardServiceImpl.getInstance();
		int result = service.boardPasswdChk(vo);
		
		request.setAttribute("resultData", result);
		
		return  "/common/resultData";
	}

}