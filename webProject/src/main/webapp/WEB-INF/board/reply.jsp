<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<body>
		<div class="accordion" id="comment_list">

		</div>
		
		<script>
			$(function() {
				/** 기본 덧글 목록 불러오기 */
				let num = ${detail.num};
				listAll(num)
			});	
		</script>
		<script src="/include/js/reply.js"></script>
	</body>
</html>