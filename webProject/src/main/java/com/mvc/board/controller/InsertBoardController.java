package com.mvc.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.board.service.BoardService;
import com.mvc.board.service.BoardServiceImpl;
import com.mvc.board.vo.BoardVO;
import com.mvc.common.controller.Controller;


public class InsertBoardController implements Controller {
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String path = null;
		// 1. VO객체에 데이터 바인딩
		BoardVO vo = new BoardVO();
		vo.setTitle(request.getParameter("title")); // input 태그의 name명을 명시. name명=값의 형태로 서버에 전달
		vo.setAuthor(request.getParameter("author"));
		vo.setContent(request.getParameter("content"));
		vo.setPasswd(request.getParameter("passwd"));

		BoardService service = BoardServiceImpl.getInstance();
		int result = service.boardInsert(vo);
		
		if (result == 1) { // 입력 성공시
			path = "/board/getBoardList.do"; // 게시판 리스트 요청
		} else {          // 입력 실패시
			path = "/board/insertForm";      // 입력 화면으로 이동
			request.setAttribute("errorMsg", "등록완료에 문제가 있어 잠시 후 다시 입력해 주세요.");
		}
		
		// 3. 화면 네비게이션
		return path;
	}
}