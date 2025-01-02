package com.mvc.reply.service;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.mvc.reply.dao.ReplyMapper;
import com.mvc.reply.dao.ReplyMapperImpl;
import com.mvc.reply.vo.ReplyVO;

public class ReplyServiceImpl implements ReplyService{
	private static ReplyMapper mapper = new ReplyMapperImpl();
	
	private static ReplyServiceImpl service = null;
	private ReplyServiceImpl(){ }
	public static ReplyServiceImpl getInstance() {
		if(service == null) {
			service = new ReplyServiceImpl();
		}
		return service;
	}

	/*[
	 * {
	 * 	"replyNumber":1,
	 *  "num":5,
	 *  "replyName":"김철수",
	 *  "replyContent":"소심하고 망설이는 자에게는 모든 일이 불가능하다. 왜냐하면 모든것이 불가능하게 보이기 때문이다.",
	 *  "replyDate":"2024-07-08 16:09:48",
	 *  "replyPwd":""
	 *  }
	 *]*/
	public String replyList(ReplyVO vo) {
		String listData = "";
		List<ReplyVO> list = mapper.replyList(vo);
		ObjectMapper om = new ObjectMapper();
		try {
        	listData = om.writeValueAsString(list);
        	System.out.println(listData);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return listData;
	}

}