package com.mvc.common.controller;

import java.util.HashMap;
import java.util.Map;

import com.mvc.board.controller.GetBoardListController;
import com.mvc.board.controller.InsertBoardController;
import com.mvc.board.controller.InsertFormController;
import com.mvc.board.controller.PasswdCheckController;
import com.mvc.board.controller.UpdateBoardController;
import com.mvc.board.controller.UpdateFormController;
import com.mvc.reply.controller.ReplyListController;
import com.mvc.board.controller.DeleteBoardController;
import com.mvc.board.controller.DetailBoardController;

public class HandlerMapping {
	private Map<String, Controller> mappings;

	public HandlerMapping() {
		//                   매핑정보(key) 구현클래스(value)
		mappings = new HashMap<String, Controller>();
		/* 답변형 게시판 처리 */
		mappings.put("/board/getBoardList.do", new GetBoardListController()); /* 게시판 리스트 */
		mappings.put("/board/insertForm.do", new InsertFormController());
		mappings.put("/board/insertBoard.do", new InsertBoardController());
		mappings.put("/board/detailBoard.do", new DetailBoardController());
		mappings.put("/board/updateForm.do", new UpdateFormController());
		mappings.put("/board/updateBoard.do", new UpdateBoardController());
		mappings.put("/board/deleteBoard.do", new DeleteBoardController());
		mappings.put("/board/passwdCheck.do", new PasswdCheckController());
		
		/* 댓글 처리 */
		mappings.put("/replies/replyList.do", new ReplyListController());
	}

	public Controller getController(String path) { // 게시판리스트일 경우 path="/board/getBoardList.do"
		return mappings.get(path);                 // mappings.get("/board/getBoardList.do")=> new GetBoardListController()의 주솟값 반환
	}
}