package com.mvc.reply.dao;

import java.util.List;

import com.mvc.reply.vo.ReplyVO;

public interface ReplyMapper {
	public List<ReplyVO> replyList(ReplyVO vo);
}