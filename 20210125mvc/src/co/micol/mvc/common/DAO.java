package co.micol.mvc.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DAO {
	private String driver =  "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "hr";
	private String password = "hr";
	//private는 상속안됨 public만 됨
	public Connection conn;
	
	public DAO() { //상위 dao class
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			//conn은 sql을 연결시켜주는것인데 아직 jsp에 활용못함 psmt로 jsp에 명령
			System.out.println("DB 연결 성공!!");
		}catch(ClassNotFoundException | SQLException e) {
			System.out.println("DB 연결 실패!!");
		}
	}
}
