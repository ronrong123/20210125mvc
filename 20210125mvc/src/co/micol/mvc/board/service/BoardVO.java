package co.micol.mvc.board.service;

import java.sql.Date;

public class BoardVO {
	//VO는 DB테이블과 일치하는것으로 객체를 만드는것
	//기본적으로 테이블과 1:1로 만들음(컬럼명과 변수명 데이터타입이 동일해야함)
	
	private int boardNo;
	private String title;
	private String content;
	private String writer;
	private Date creationDate;
	//private는 값을 전달하거나 가져올 방법이없어 get,set을 만들음
	public BoardVO() {
		// TODO Auto-generated constructor stub
	}
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
	
}
