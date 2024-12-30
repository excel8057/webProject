let buttonCheck = ""; // buttonCheck는 수정버튼과 삭제버튼을 구별하기 위한 변수
$(function(){		
	let btnInit = function(){
		$("#message").removeClass("text-danger");
		$("#message").addClass("text-primary");
		$("#message").text("작성시 입력한 비밀번호를 입력해 주세요.");
	}	
		
	/* 수정 버튼 클릭 시 처리 이벤트 */
	$("#updateForm").on("click", ()=>{
		$("#f_data").attr({
			"method":"post",
			"action":"/board/updateForm.do"
		});
		$("#f_data").submit();
		
		// 비밀번호 확인 후 처리
	});
	
	/* 목록 버튼 클릭 시 처리 이벤트 */
	$("#boardListBtn").on("click", ()=>{
		location.href="/board/getBoardList.do";
	});
});