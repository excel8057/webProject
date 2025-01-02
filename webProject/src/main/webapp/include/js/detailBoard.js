let buttonCheck = ""; // buttonCheck는 수정버튼과 삭제버튼을 구별하기 위한 변수

let btnInit = function(){
		$("#message").removeClass("text-danger");
		$("#message").addClass("text-primary");
		$("#message").text("작성시 입력한 비밀번호를 입력해 주세요.");
}	
		
/* 수정 버튼 클릭 시 처리 이벤트 */
$("#updateForm").on("click", ()=>{
	/*$("#f_data").attr({
		"method":"post",
		"action":"/board/updateForm.do"
	});
	$("#f_data").submit(); */
		
	// 비밀번호 확인 후 처리
	$("#pwdChk").css("visibility", "visible");
	btnInit();
	buttonCheck = "updateButton";
});
	
/* 삭제 버튼 클릭 시 처리 이벤트 */
$("#boardDelete").on("click", ()=>{
	/*if(confirm("정말로 삭제하시겠습니까?")){
		$("#f_data").attr({
			"method":"post",
			"action":"/board/deleteBoard.do"
		});
		$("#f_data").submit();
	}*/
		
	// 비밀번호 확인 후 처리
	$("#pwdChk").css("visibility", "visible");
	btnInit();
	buttonCheck = "deleteButton";
});

$("#passwd").on("keyup", ()=>{
	btnInit();
});
				
/* 비밀번호 취소 버튼 클릭 시 처리 이벤트 */
$("#passwdCancelBtn").on("click", function(){
	$("#passwd").val("");
	$("#pwdChk").css("visibility", "hidden");
	buttonCheck = "";
});
	
/* 비밀번호 확인 버튼 클릭 시 처리 이벤트 */
$("#passwdBtn").on("click", function(){
	if(!dataCheck("#passwd", "#message", "비밀번호를")) return;
	else {
		$.ajax({
			url : "/board/passwdCheck.do",            //전송 url
			method : "post",                          //전송 시 method 방식
			data : $("#f_passwdCheck").serialize(),   //폼전체 데이터 전송
			dataType : "text"
		}).done(function (resultData) {               //정상적으로 실행이 되었을 경우          
			if(resultData == 0){                      //일치하지 않는 경우(서버로부터 반환값: 0)
				$("#message").toggleClass("text-danger");
				$("#message").text("작성시 입력한 비밀번호가 일치하지 않습니다.");
				$("#passwd").select();
			}else if(resultData == 1){                //일치할 경우(서버로부터 반환값: 1)
				$("#message").text("");
				if(buttonCheck == "updateButton"){         // 수정버튼 클릭
					$("#f_data").attr("action", "/board/updateForm.do");
					$("#f_data").submit();
				} else if(buttonCheck == "deleteButton"){ // 삭제버튼 클릭
					if(confirm("정말 삭제하시겠습니까?")){
						$("#f_data").attr("action", "/board/deleteBoard.do");
						$("#f_data").submit();
					}
				}
			}
		}).fail(function(xhr, textStatus) {          //실행시 오류가 발생하였을 경우
			alert(textStatus + " (HTTP-" + xhr.status + ")");
			//alert('잠시 후에 다시 진행해 주세요.');
		});
	}
});
	
/* 목록 버튼 클릭 시 처리 이벤트 */
$("#boardListBtn").on("click", ()=>{
	location.href="/board/getBoardList.do";
});