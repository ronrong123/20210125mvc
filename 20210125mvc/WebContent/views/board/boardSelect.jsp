<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table{border-collapse:collapse;}
	table tr, td {padding:10px;}
	button{margin-top:10px;padding:8px 15px;background:rgb(59, 59, 59);color:rgba(255,255,255,0.8);border:none;cursor:pointer;}
</style>
</head>
<jsp:include page="../common/menu.jsp" />
<body>
	<div align="center">
		<div>
			<h1>게시글 상세보기</h1>
		</div>
		<div>
			<table border="1">
				<tr>
					<th width="100">글번호</th>
					<td width="100">${vo.boardNo }</td>
					<th width="100">작성자</th>
					<td width="100">${vo.writer }</td>
					<th width="100">작성일자</th>
					<td width="100">${vo.creationDate }</td>
				</tr>
				<tr>
				<th>제 목</th>
				<td colspan="5">${vo.title }</td>
				</tr>
				<tr>
				<th>내용</th>
				<td colspan="5"><textarea rows="7" cols="70" readonly>${vo.content }</textarea></td>
				</tr>
			</table>
			<button onclick="location.href='/20210125mvc/BoardList.do'">목록보기</button>&nbsp;
			<button onclick="location.href='/20210125mvc/BoardDelete.do?row='+${vo.boardNo }">삭제하기</button>
			<button onclick="location.href='/20210125mvc/BoardUpdate.do?row='+${vo.boardNo }">수정하기</button>
		</div>
	</div>
</body>
</html>