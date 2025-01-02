/* 입력 양식 enter 제거 또는 검색 기능 부여*/
$("#keyword").bind("keydown", function(event){
	 if (event.keyCode == 13) {
		  event.preventDefault(); // enter가 입력되어도 아무런 작업을 하지 않음
     }
});
	
/* 검색 버튼 클릭 시 처리 이벤트 */
$("#searchData").on("click", ()=>{
	if($("#search").val() != "all"){ // 검색대상(search)의 값이 all이 아니면 키워드(검색할 단어)가 반드시 필요.
		if(!chkData("#keyword","검색어를")) return;
	} else if($("#search").val() == "all"){ // 검색대상(search)의 값이 all이면 전체 검색으로 키워드가 필요하지 않음.
		$("#keyword").val("");
	}  
	$("#f_search").attr({
			"method":"post",
			"action":"/board/getBoardList.do"
	});
	$("#f_search").submit();
});
	
/* 제목 클릭시 상세 페이지 이동을 위한 처리 이벤트 */		
$(".goDetail").on("click", function(){
	//let num = $(this).parents("tr").children().eq(0).html();
	//        이벤트가 발생한 자기 자신.자신을 포함한 부모요소 중 tr을 찾아. tr의 속성인 data-num의 값을 읽어옴
	let num = $(this).parents("tr").attr("data-num");
	//console.log("num = "+num);
	
    // post 방식으로 상세 페이지 이동
	// 폼 태그 내 num요소에 value 설정 
	$("#num").val(num);
	$("#detailForm").attr({
			"method":"post",
			"action":"/board/detailBoard.do"
	});
	$("#detailForm").submit();
		
	// get 방식으로 상세 페이지 이동
	//location.href="/board/detailBoard.do?num="+num;
});
	
/* 글쓰기 버튼 클릭 시 처리 이벤트 */		
$("#writeForm").on("click", function(){
	//console.log("글쓰기 버튼 클릭"); // 콘솔에 출력하는 이유는 이벤트가 정상적으로 실행되는지 확인하시 위해서 명시.
	location.href = "/board/insertForm.do"; // 위 코드가 정상적으로 실행되면 작성 후 확인.
});