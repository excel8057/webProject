package com.mvc.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mvc.board.vo.BoardVO;

import mybatis.SqlSessionTemplate;

public class BoardMapperImpl implements BoardMapper{
	private SqlSession session;
	
	public BoardMapperImpl() {
		session = SqlSessionTemplate.getSqlSession();
	}
	
	public List<BoardVO> boardList(BoardVO vo){
		return session.selectList("boardList", vo);
	}
	
	public void close(){
		session.close();
	}
	public int boardInsert(BoardVO vo) {
		return session.insert("boardInsert", vo);	
	}
	public void readcntUpdate(BoardVO vo) {
		session.update("readcntUpdate", vo);
	}
		
	public BoardVO boardDetail(BoardVO vo) {
		return (BoardVO)session.selectOne("boardDetail", vo);
	}
	@Override
	public int boardUpdate(BoardVO vo) {
		return session.update("boardUpdate", vo);	
	}
	@Override
	public void boardDelete(BoardVO vo) {
		session.delete("boardDelete", vo);	
	}
	@Override
	public int boardPasswdChk(BoardVO vo) {
		return (int)session.selectOne("boardPasswdChk", vo);
	}
	
}