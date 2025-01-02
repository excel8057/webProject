package com.mvc.reply.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.common.controller.Controller;
import com.mvc.reply.service.ReplyService;
import com.mvc.reply.service.ReplyServiceImpl;
import com.mvc.reply.vo.ReplyVO;

public class ReplyListController implements Controller {	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		ReplyVO vo = new ReplyVO();
		vo.setNum(Integer.parseInt(request.getParameter("num")));

		ReplyService service = ReplyServiceImpl.getInstance();
		String  listData = service.replyList(vo);

        request.setAttribute("resultData", listData);
		
		return "/common/resultData";
	}
}