<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table{border-collapse:collapse;}
	button{margin-top:10px;padding:8px 15px;background:rgb(59, 59, 59);color:rgba(255,255,255,0.8);border:none;cursor:pointer;}
</style>
</head>
<body>
<jsp:include page="../common/menu.jsp" />
<div align="center">
		<div>
			<h1>게시글 작성</h1>
		</div>
		<div>
		<form id="frm" name="frm" action="/20210125mvc/BoardInput.do" method="post">
			<table border="1">
				<tr>
					<th width="100">글번호</th>
					<td width="50"><input type="text" id="boardNo" name="boardNo"></td>
					<th width="100">작성자</th>
					<td width="100"><input type="text" id="writer" name="writer"></td>
					<th width="100">작성일자</th>
					<td width="100"><input type="date" id="creationDate" name="creationDate"></td>
				</tr>
				<tr>
				<th>제 목</th>
				<td colspan="5"><input type="text" id="title" name="title" size="95"></td>
				</tr>
				<tr>
				<th>내용</th>
				<td colspan="5"><textarea id="content" name="content" rows="7" cols="97"></textarea></td>
				</tr>
			</table>
			<button type="submit">저장하기</button>
			<button type="reset">취소</button>
		</form>
		</div>
	</div>
</body>
</html>