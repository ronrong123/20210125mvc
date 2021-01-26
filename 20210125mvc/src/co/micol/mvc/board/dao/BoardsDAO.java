package co.micol.mvc.board.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.micol.mvc.board.service.BoardVO;
import co.micol.mvc.common.DAO;

public class BoardsDAO extends DAO{
	//보드테이블 접속하는 DAO
	//DAO를 상속받아서 만든것
	//conn -> psmt -> rs 순서로 열음
	private PreparedStatement psmt;
	private ResultSet rs;
	//담아둘 인터페이스
	
	private final String BOARDSELECTLIST="SELECT * FROM BOARDS ORDER BY BOARD_NO DESC";
	private final String BOARDSELECT = "SELECT * FROM BOARDS WHERE BOARD_NO =?";
	private final String BOARDINSERT ="INSERT INTO BOARDS VALUES(?,?,?,?,?)";
	private final String BOARDDELETE ="DELETE FROM BOARDS WHERE BOARD_NO = ?";
	private final String BOARDUPDATE = "UPDATE BOARDS SET TITLE=?, CONTENT=? WHERE BOARD_NO=?";
	//더이상 수정하지 못하게 만드는것
	//final 키워드는 엔티티를 한 번만 할당합니다. 즉, 두 번 이상 할당하려 할 때 컴파일 오류가 발생하여 확인이 가능합니다.
	//sql부문이 중간에 변경되면 안되기떄문에 final키워드를 씀 상수처럼 되기때문 상수:변하지않는값
	//sql부분은 대부분 대문자를 쓴다.
	public ArrayList<BoardVO> selectList(){
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		BoardVO vo;
		try {
			psmt = conn.prepareStatement(BOARDSELECTLIST);
			rs = psmt.executeQuery(); //record set을 리턴한다.
			//몇개가 나올지 모를때는 while
			while(rs.next()) { //rs를 next하면서 vo에 담음
				vo = new BoardVO();
				vo.setBoardNo(rs.getInt("board_no"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getNString("content"));
				vo.setWriter(rs.getString("writer"));
				vo.setCreationDate(rs.getDate("creation_date"));
				//내가 가지고 있는 record하나의 값을 vo객체에 담음
				list.add(vo);//결과를 list에 담음
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		//finally는 정상적, 비정상적 모두 적용됨
		return list;
	}
	public BoardVO select(BoardVO vo) {
		//한개레코드 조회 구문 작성
		try {
			psmt = conn.prepareStatement(BOARDSELECT);
			psmt.setInt(1, vo.getBoardNo());
			rs = psmt.executeQuery();
			if(rs.next()) { //한개의 행이라 while이 아니라 if 존재하는지 안하는지만 확인하면 됨
				vo = new BoardVO();
				vo.setBoardNo(rs.getInt("board_no"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getNString("content"));
				vo.setWriter(rs.getString("writer"));
				vo.setCreationDate(rs.getDate("creation_date"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return vo;
	}
	public int insert(BoardVO vo) { //boards 테이블에 데이터를 삽입
		int n = 0;
		try {
			psmt = conn.prepareStatement(BOARDINSERT);
			psmt.setInt(1, vo.getBoardNo());
			psmt.setString(2, vo.getTitle());
			psmt.setString(3, vo.getContent());
			psmt.setString(4, vo.getWriter());
			psmt.setDate(5, vo.getCreationDate());
			n = psmt.executeUpdate();
			//select 쿼리만 psmt.executeQuery();고 나머지는 전부 psmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}		
		return n;
	}
	public int update(BoardVO vo) {
		int n = 0;
		try {
			psmt = conn.prepareStatement(BOARDUPDATE);
			//conn객체를 통해 psmt를 만들때 sql문을 실어보냄
			psmt.setString(1, vo.getTitle());
			psmt.setString(2, vo.getContent());
			psmt.setInt(3, vo.getBoardNo());
			
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}
	public int delete(BoardVO vo) {
		int n = 0;
		try {
			psmt = conn.prepareStatement(BOARDDELETE);
			//psmt는 conn객체를 통해 sql 명령문을 수행시켜줌
			psmt.setInt(1, vo.getBoardNo());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return n;
	}
	
	private void close() {
		try {
			if(rs != null) rs.close();
			if(psmt != null) psmt.close();
			if(conn != null) conn.close();
			//여는 순서의 반대로 적어줘야함
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}	
