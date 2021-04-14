package ch5.oracle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.quiz0222.EmpVO;
import com.util.DBConnectionMgr;

public class JdbcTest2 {
	
	Connection 			con = null;
	PreparedStatement pstmt = null;
	ResultSet 			 rs = null;
	
	public JdbcTest2() {
		DBConnectionMgr dbMgr = DBConnectionMgr.getInstance();
		String sql = "SELECT empno, ename, sal FROM emp";
		
		try {
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			EmpVO eVO = null;
			
			System.out.println("EMPNO	ENAME	SAL\n----------------------");
			
			while(rs.next()) {
				eVO = new EmpVO();
				eVO.setEmpno(rs.getInt("EMPNO"));
				eVO.setEname(rs.getString("ENAME"));
				eVO.setSal(rs.getDouble("sal"));
				System.out.println(eVO.getEmpno() + "	" + eVO.getEname() + "	" + eVO.getSal());
			}
			
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		}
		System.out.println("constructor called successfully.");
		
		dbMgr.freeConnection(con, pstmt, rs);
	}

	public static void main(String[] args) {
		JdbcTest2 jt = new JdbcTest2();
	}
}
