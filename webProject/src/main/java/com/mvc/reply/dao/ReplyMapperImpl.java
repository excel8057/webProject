package com.mvc.reply.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mvc.reply.vo.ReplyVO;

import mybatis.SqlSessionTemplate;

public class ReplyMapperImpl implements ReplyMapper {
	private SqlSession session;
	
	public ReplyMapperImpl() {
		session = SqlSessionTemplate.getSqlSession();
	}

	@Override
	public List<ReplyVO> replyList(ReplyVO vo) {
		List<ReplyVO> replyList = session.selectList("replyList", vo);
		return replyList;
	}

	public void close() {
		session.close();
	}
}