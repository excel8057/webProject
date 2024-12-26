package com.mvc.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.mvc.common.util.JDBCTemplate.*;

import com.mvc.board.vo.BoardVO;

public class BoardDAO {
	private static BoardDAO instance =null;
	
	public static BoardDAO getInstance() {
		if(instance==null) {
			instance= new BoardDAO();
		}
		return instance;
	}
	
	private BoardDAO() {}
	
	/***********************************************************
	 * boardList(BoardVO vo) 메서드: 게시판 목록 조회.
	 * @return List<BoardVO> 리턴.
	 ***********************************************************/
	public List<BoardVO> boardList(BoardVO vo){
		List<BoardVO> list = new ArrayList<BoardVO>();
		// 인터페이스<타입> 참조변수 = new 구현클래스<>();
		// List<BoardVO> list = new List<>(); // 인스턴스 생성 X
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			conn = getConnection();
			StringBuffer query = new StringBuffer();
			query.append("SELECT  num, author, title,  ");
			query.append("to_char(writeday, 'YYYY/MM/DD') writeday, ");
			query.append("readcnt, repRoot, repStep, repIndent ");
			query.append("FROM board ");
			query.append("order by repRoot desc, repStep asc");
			
			pstmt = conn.prepareStatement(query.toString());
			rs = pstmt.executeQuery();
			
			while( rs.next()){
				BoardVO data = new BoardVO();
				data.setNum(rs.getInt("num"));
				data.setAuthor(rs.getString("author"));
				data.setTitle(rs.getString("title"));
				data.setWriteday(rs.getString("writeday"));
				data.setReadcnt(rs.getInt("readcnt"));
				data.setRepRoot(rs.getInt("repRoot"));
				data.setRepStep(rs.getInt("repStep"));
				data.setRepIndent(rs.getInt("repIndent"));
				
				list.add( data );
			}//end while
		}catch(Exception e){ 
			e.printStackTrace();
		}finally{
			close(rs);
			close(pstmt);
			close(conn);
		}
		return list;
	}//end select 
}