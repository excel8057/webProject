/* 저장 버튼 클릭 시 처리 이벤트 */
$("#boardInsert").click(function(){
		//입력값 체크
		if (!chkData("#author","이름을"))	return;
		else if (!chkData("#title","제목을"))	return;
		else if (!chkData("#content","작성할 내용을"))	return;
		else if (!chkData("#passwd","비밀번호를"))	return;
		else {
			$("#f_writeForm").attr({
				"method":"post",
				"action":"/board/insertBoard.do"
			});
			$("#f_writeForm").submit();
		}
});
	
/* 목록 버튼 클릭 시 처리 이벤트 */
$("#boardListBtn").click(function(){
		location.href="/board/getBoardList.do";
});