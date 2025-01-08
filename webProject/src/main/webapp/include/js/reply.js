/** 댓글 목록 보여주는 함수*/ 
function listAll(num){
	$("#comment_list").html("");
	
	const url = "/replies/replyList.do";
	$.getJSON(url, { "num" : num }, function(data) {
		console.log("list count: " + data.length);
		replyCnt = data.length;
		$(data).each(function() {
			let replyNumber = this.replyNumber;
			let replyName = this.replyName;
			let replyContent = this.replyContent;
			let replyDate = this.replyDate;
			replyContent = replyContent.replace(/(\r\n|\r|\n)/g, "<br />");
			addNewItem(replyNumber, replyName, replyContent, replyDate);
		}); 
	}).fail(function() {
		alert("덧글 목록을 불러오는데 실패하였습니다. 잠시후에 다시 시도해 주세요.");
	});
}
		
/** 새로운 글을 화면에 추가하기(보여주기) 위한 함수*/
function addNewItem(replyNumber, replyName, replyContent, replyDate) {
	// 새로운 글이 추가될 li태그 객체
	let item = $("<div>");
	item.attr("data-num", replyNumber);
	item.addClass("accordion-item");

	// 작성자 정보가 지정될 <h2>태그
	let header = $("<h2>");
	header.addClass("accordion-header");
	
	let button = $('<button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#panelsStayOpen-collapseOne" aria-expanded="true" aria-controls="panelsStayOpen-collapseOne">');
	button.html(replyName + "님 / " + replyDate + " ");
	
	// 수정하기 버튼
	let up_input = $("<input>");
	up_input.attr({"type" : "button", "value" : "수정하기"});
	up_input.addClass("update_form btn btn-success btn-sm");
	
	// 삭제하기 버튼
	let del_input = $("<input>");
	del_input.attr({"type" : "button", "value" : "삭제하기"});
	del_input.addClass("delete_btn btn btn-success btn-sm");
	
	// 내용
	let collapse = $("<div>");
	collapse.attr({"id":"panelsStayOpen-collapseOne"});
	collapse.addClass("accordion-collapse collapse show");
	
	let body =  $("<div>");
	body.addClass("accordion-body");
	body.html(replyContent);

	// 조립하기
	header.append(button.append(up_input).append(del_input));
	collapse.append(body);
	item.append(header).append(collapse);
	
	$("#comment_list").append(item);
}


/* 입력 폼 초기화 */
function dataReset() {
	$("#replyName").val("");
	$("#replyPwd").val("");
	$("#replyContent").val("");
}