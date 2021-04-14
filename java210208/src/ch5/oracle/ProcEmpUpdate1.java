package ch5.oracle;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.util.DBConnectionMgr;

public class ProcEmpUpdate1 extends JFrame {
	
	Connection con = null;
	CallableStatement cstmt = null;
	DBConnectionMgr dbMgr = null;
	/***********************************************************
	 * proc_salary1_1 호출 테스트
	 * @param p_empno - 사원번호 입력받아서 단일레코드 처리 실습
	 * @result 프로시저 처리 결과를 int값으로 확인해보기
	 **********************************************************/
	public void salUpdate(int p_empno) {
		
		dbMgr = DBConnectionMgr.getInstance();
		int result = 0;
		
		try {
			con = dbMgr.getConnection();
			cstmt = con.prepareCall("{call PROC_SALARY1_1(?,?)}");
			cstmt.setInt(1, p_empno);
			cstmt.registerOutParameter(2, java.sql.Types.VARCHAR);
			result = cstmt.executeUpdate();
			String msg = cstmt.getNString(2);
			
			System.out.println(result);
		
			if (result == 1) {
				JOptionPane.showMessageDialog(this, "수정되었습니다.");
			}
			else {
				JOptionPane.showMessageDialog(this, "실패하였습니다.");
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	/***********************************************************
	 * proc_salary1_2 호출 테스트
	 * @param p_empno - 부서번호 입력받아서 여러 레코드 처리 실습
	 * @result 프로시저 처리 결과를 int값으로 확인해보기
	 **********************************************************/
	public void salUpdate2(int p_deptno) {
		
		dbMgr = DBConnectionMgr.getInstance();
		int result = 0;
		
		try {
			con = dbMgr.getConnection();
			cstmt = con.prepareCall("{call PROC_SALARY1_2(?)}");
			cstmt.setInt(1, p_deptno);
			result = cstmt.executeUpdate();
			
			System.out.println(result);
			
			if (result >= 1) {
				JOptionPane.showMessageDialog(this, "수정되었습니다.");
			}
			else {
				JOptionPane.showMessageDialog(this, "실패하였습니다.");
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {
		ProcEmpUpdate1 neu1 = new ProcEmpUpdate1();
//		String user_input = JOptionPane.showInputDialog("사원 번호를 입력하시오");
//		int empno = 0;
//		if (user_input != null || user_input.length() > 1) {
//			empno = Integer.parseInt(user_input);
//		}
//		neu1.salUpdate(empno);
		
		String user_input2 = JOptionPane.showInputDialog("부서 번호를 입력하시오");
		int deptno = 0;
		if (user_input2 != null || user_input2.length() > 1) {
			deptno = Integer.parseInt(user_input2);
		}
		neu1.salUpdate2(deptno);
	}
}
