<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<div>
			<h1>게시글 수정화면</h1>
		</div>
		<div>
		<form id="frm"  name="frm" action="/20210125mvc/BoardUpdateSave.do" method="post">
			<table border="1">
				<tr>
					<th width="100">글번호</th>
					<td width="100"><input type="text" id="no" name="no" value="${vo.boardNo }" readonly></td>
					<th width="100">작성자</th>
					<td width="100">${vo.writer }</td>
					<th width="100">작성일자</th>
					<td width="100">${vo.creationDate }</td>
				</tr>
				<tr>
				<th>제 목</th>
				<td colspan="5"><input type="text" id="title" name="title" value="${vo.title }" size="78"></td>
				</tr>
				<tr>
				<th>내용</th>
				<td colspan="5"><textarea rows="7" cols="80" id="content" name="content">${vo.content }</textarea></td>
				</tr>
			</table>
			<input type="submit" value="수정">&nbsp;
			<input type="button" value="목록가기" onclick="location.href='/20210125mvc/BoardList.do'">
		</form>
		</div>
	</div>
</body>
</html>