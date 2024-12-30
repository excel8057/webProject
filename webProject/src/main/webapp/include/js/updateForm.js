$(function(){
	/* 저장 버튼 클릭 시 처리 이벤트 */
	$("#boardUpdate").on("click", function(){
		//입력값 체크
		if (!chkData("#title","제목을"))	return;
		else if (!chkData("#content","작성할 내용을"))	return;
		else {
			$("#f_updateForm").attr({
				"method":"post",
				"action":"/board/updateBoard.do"
			});
			$("#f_updateForm").submit();
		}
	});
	
	/* 목록 버튼 클릭 시 처리 이벤트 */
	$("#boardListBtn").on("click", function(){
		location.href="/board/getBoardList.do";
	});
});