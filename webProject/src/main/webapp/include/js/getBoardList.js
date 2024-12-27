/* 글쓰기 버튼 클릭 시 처리 이벤트 */		
$("#writeForm").on("click", function(){
		console.log("글쓰기 버튼 클릭"); // 콘솔에 출력하는 이유는 이벤트가 정상적으로 실행되는지 확인하시 위해서 명시.
		location.href = "/board/insertForm.do"; // 위 코드가 정상적으로 실행되면 작성 후 확인.
});