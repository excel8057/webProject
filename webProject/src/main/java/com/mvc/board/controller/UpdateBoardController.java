package com.mvc.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.board.service.BoardService;
import com.mvc.board.service.BoardServiceImpl;
import com.mvc.board.vo.BoardVO;
import com.mvc.common.controller.Controller;

public class UpdateBoardController implements Controller {

	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String passwd = request.getParameter("passwd");
		if(passwd.isEmpty()) passwd=""; // 비밀번호가 비어있을 때 null이 아닌 ""(빈문자)로 제어를 위해 설정
		
		BoardVO vo = new BoardVO();
		vo.setNum(Integer.parseInt(request.getParameter("num")));
		vo.setTitle(request.getParameter("title"));
		vo.setContent(request.getParameter("content"));
		vo.setPasswd(passwd);
		
		BoardService service = BoardServiceImpl.getInstance();
		int result = service.boardUpdate(vo);
		String path = null;
		
		if(result == 1) { // 수정 성공시 상세페이지로 이동. 이때 레코드의 글번호를 기준으로 조회. 
			path = "/board/detailBoard.do?num="+vo.getNum();
		} 

		return path;
	}
}