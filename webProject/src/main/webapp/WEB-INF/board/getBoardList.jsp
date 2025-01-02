<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/common/common.jsp" %>

<body>
	<div class="container">
		<div class="text-center"><h3>게시판 리스트</h3></div>	
		<%--=============== 검색기능 시작 ====================--%> 
		<form id="f_search" name="f_search" >
			<div class="row g-2 align-items-center">
				<div class="col-auto">
					<label for="search">검색조건</label>
				</div>
				<div class="col-auto">
					<select id="search" name="search" class="form-select form-select-sm">
						<option value="all">전체조회</option>
						<option value="title">제목</option>
						<option value="content">내용</option>
						<option value="author">작성자</option>
					</select>
				</div>
				<div class="col-auto">
					<input type="text" name="keyword" id="keyword" placeholder="검색어를 입력하세요" 
					class="form-control form-control-sm" />
				</div>
				<div class="col-auto">
					<button type="button" id="searchData" class="btn btn-primary btn-sm">검색</button>
				</div>	
			</div>
		</form>
		<%-- =================== 리스트 시작  ================== --%>
		<div id="boardList">
			<table summary="게시판 리스트" class="table">
				<thead>
					<tr class="text-center">
					   <th class="col-md-1">번호</th>
					   <th class="col-md-6">제목</th>
					   <th class="col-md-2">작성자</th>
					   <th class="col-md-2">날짜</th>
					   <th class="col-md-1">조회수</th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${not empty list}" >
							<c:forEach var="vo" items="${list}">
								<tr class="text-center" data-num="${vo.num}" >
									<td>${vo.num}</td>
									<%--<td class="text-start"><span class="goDetail">${vo.title}</span></td> --%> 
									<td class="text-start"><a href="/board/detailBoard.do?num=${vo.num}">${vo.title}</a></td> 
									<td>${vo.author}</td>
									<td>${vo.writeday}</td>
									<td>${vo.readcnt}</td>
								</tr>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<tr>
								<td colspan="5" class="text-center">등록된 게시물이 존재하지 않습니다.</td>
							</tr>
						</c:otherwise>
					</c:choose>		
				</tbody>
			</table>
		</div>
		
		<%-- ================ 글쓰기 버튼 출력 시작 =============== --%>
		<div class="contentBtn text-end">
			<button type="button" id="writeForm"  class="btn btn-primary btn-sm">글쓰기</button>
		</div>
	</div>
	<script src="/include/js/getBoardList.js"></script>
	<script src="/include/js/common.js"></script>
</body>
</html>