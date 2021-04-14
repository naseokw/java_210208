package ch5.oracle;
/*
 * 물리적으로 떨어져있는 192.168.0.24(김희태) 서버에 접속하려고 한다
 * 서버 컴퓨터의 오라클 제품에 접속하려면 해당 회사가 제공하는 드라이버 클래스가 있어야 한다.
 * 따라서 우리는 ojdbc6.jar을 주입받을 수 있도록 등록하였다.
 * 
 * 
 * 
 * 
 */

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.quiz0222.EmpVO;

public class OracleProcedure {
	
	static final String _DRIVER = "oracle.jdbc.driver.OracleDriver";
	static final String _URL 	= "jdbc:oracle:thin:@121.139.85.156:15210:orcl11";
	String 				_USER 	= "SCOTT";
	String 				_PW 	= "tiger";
	
	Connection 			con = null;
	CallableStatement cstmt = null;
	ResultSet 			 rs = null;
	String msg = null;
	
	public OracleProcedure() {
		
		try {
			Class.forName(JdbcTest._DRIVER);
			con = DriverManager.getConnection(_URL, _USER, _PW);
			cstmt = con.prepareCall("{call PROC_SALARY(?,?)}");
			cstmt.setInt(1, 7566);
			cstmt.registerOutParameter(2, java.sql.Types.VARCHAR);
			
			rs = cstmt.executeQuery();
			
			msg = cstmt.getNString(2);
			
			System.out.println(msg);
			
		} catch(ClassNotFoundException ce) {
			System.out.println(ce.getMessage() + " 드라이버 로딩 실패");
			return;
		} catch (SQLException se) {
			System.out.println(se.getMessage() + "오라클 연결 실패");
		}
		System.out.println("try statement executed successfully.");
	}

	public static void main(String[] args) {
		OracleProcedure op = new OracleProcedure();
	}
}
