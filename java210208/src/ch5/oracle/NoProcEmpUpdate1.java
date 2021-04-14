package ch5.oracle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.util.DBConnectionMgr;

public class NoProcEmpUpdate1 extends JFrame {
	
	Connection con1 = null;
	Connection con2 = null;
	Connection con3 = null;
	PreparedStatement pstmt1 = null;
	PreparedStatement pstmt2 = null;
	PreparedStatement pstmt3 = null;
	ResultSet rs1 = null;
	ResultSet rs2 = null;
	String sql1 = "";
	String sql2 = "";
	String sql3 = "";
	DBConnectionMgr dbMgr = null;
	
	public void salUpdate(int p_empno) {
		
		dbMgr = DBConnectionMgr.getInstance();
		
		String r_ename = null;
		double r_sal = 0.0;
		double r_avg_sal = 0.0;
		double v_rate = 0.0;
		int result = 0;				//0 = 성공, 1 = 실패
		
		sql1 = "SELECT ename, sal FROM emp"
				+ " WHERE empno = ?";
		
		sql2 = "SELECT AVG(sal) avgsal FROM emp"
				+ " WHERE deptno = (SELECT deptno FROM emp WHERE empno = ?)";
//				+ " WHERE deptno = (SELECT deptno FROM emp WHERE empno = " + p_empno + ")";
		
		sql3 = "UPDATE emp SET sal = ? WHERE empno = ?";
		
		try {
			con1 = dbMgr.getConnection();
			pstmt1 = con1.prepareStatement(sql1);
			pstmt1.setInt(1, p_empno);
			rs1 = pstmt1.executeQuery();
			rs1.next();
			r_ename = rs1.getString("ename");
			r_sal = rs1.getDouble("sal");
			System.out.println(p_empno + " 사원의 이름은 " + r_ename + ", 급여는 " + r_sal);
			dbMgr.freeConnection(con1, pstmt1, rs1);
			
			con2 = dbMgr.getConnection();
			pstmt2 = con2.prepareStatement(sql2);
			pstmt2.setInt(1, p_empno);
			rs2 = pstmt2.executeQuery();
			rs2.next();
			r_avg_sal = rs2.getDouble("avgsal");
			System.out.println("해당 사원이 속한 부서의 급여 평균은 " + r_avg_sal);
			
			if (r_sal > r_avg_sal) {
				v_rate = 1.1;
			}
			else {
				v_rate = 1.2;
			}
			
			dbMgr.freeConnection(con2, pstmt2, rs2);
			
			con3 = dbMgr.getConnection();
			pstmt3 = con3.prepareStatement(sql3);
			pstmt3.setDouble(1, r_sal * v_rate);
			pstmt3.setInt(2, p_empno);
			result = pstmt3.executeUpdate();
			System.out.println(result);
			if (result == 1) {
				JOptionPane.showMessageDialog(this, "수정되었습니다.");
			}
			else {
				JOptionPane.showMessageDialog(this, "실패하였습니다.");
			}
			
			dbMgr.freeConnection(con3, pstmt3);
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {
		NoProcEmpUpdate1 neu1 = new NoProcEmpUpdate1();
		String user_input = JOptionPane.showInputDialog("사원 번호를 입력하시오");
		int empno = 0;
		if (user_input != null || user_input.length() > 1) {
			empno = Integer.parseInt(user_input);
		}
		neu1.salUpdate(empno);
	}
}
