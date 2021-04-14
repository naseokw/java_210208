package com.quiz0222;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestVO {

	public void testConect(EmpVO[] evoArray, DeptVO[] dvoArray) {

		Connection	conn	= null;	// 자바 오라클 연결
		Statement	stmt	= null;	// 쿼리문 대기 및 설정
		ResultSet	rset	= null;	// 결과값 받아오기

		try {
			String	dbURL		= "jdbc:oracle:thin:@121.139.85.156:15210:orcl11";	// 오라클 외부 url
			String	dbID		= "SCOTT";											// 아이디
			String	dbPassword	= "tiger";											// 패스워드
			Class.forName("oracle.jdbc.driver.OracleDriver"); // jdbc 드라이버 파일
			conn = DriverManager.getConnection(dbURL, dbID, dbPassword); // 오라클 연결
//			System.out.println(conn);
			String sql = "SELECT * FROM emp"; // 쿼리문
//			String sql = "SELECT dvo.deptno, dvo.dname, evo.ename FROM dept dvo, emp evo"
//					+ "WHERE evo.deptno(+) = dvo.deptno";

			stmt = conn.createStatement(); // 이건 뭐하는 거지
			rset = stmt.executeQuery(sql); // 쿼리문 실행결과 리턴

			int		i	= 0, j = 0;

//			DeptVO[]	dVOS	= null;		// 선생님 피드백
			EmpVO	eVO	= null;
			DeptVO	dVO	= null;
//			ArrayList	al		= new ArrayList();

			while (rset.next()) { // rset.next() true인 동안
				eVO = new EmpVO(); // 새 인스턴스
				eVO.setEmpno(rset.getInt("EMPNO")); // evo에 불러온 값 set
				eVO.setEname(rset.getString("ENAME"));
				eVO.setJob(rset.getString("JOB"));
				eVO.setMgr(rset.getInt("MGR"));
				eVO.setHiredate(rset.getString("HIREDATE"));
				eVO.setSal(rset.getInt("SAL"));
				eVO.setComm(rset.getInt("COMM"));
				eVO.setDeptno(rset.getInt("DEPTNO"));
//				dVO.setEvo(eVO);
				evoArray[i] = eVO; // evo객체배열에 저장
				if (i < evoArray.length - 1)
					i++;
			}

			for (EmpVO e : evoArray) { // EmpVO[] 출력
				System.out.println(e.getEmpno() + " "
											+ e.getEname() + " "
											+ e.getJob() + " "
											+ e.getMgr() + " "
											+ e.getHiredate() + " "
											+ e.getSal() + " "
											+ e.getComm() + " "
											+ e.getDeptno());
			}

			System.out.println();
			String sql2 = "SELECT * FROM dept";
			rset = stmt.executeQuery(sql2); // 쿼리문2 실행결과 리턴

			/******************************************************************
			 * while(rset.next()){ dVO = new DeptVO(); dVO.setDeptno(rset.getInt("DEPTNO"));
			 * dVO.setDname(rset.getString("DNAME")); dVO.setLoc(rset.getString("LOC"));
			 * al.add(dVO); } dVOS = new DeptVO[al.size()];
			 * 
			 * 
			 * for(DeptVO dVO2 : dVOS){ System.out.println(dVO2.getDeptno() + " " +
			 * dVO2.getDname() + " " + dVO2.getLoc()); }
			 *****************************************************************/
			while (rset.next()) { // rset.next() true인 동안
				dVO = new DeptVO();
				dVO.setDeptno(rset.getInt("DEPTNO"));
				dVO.setDname(rset.getString("DNAME"));
				dVO.setLoc(rset.getString("LOC"));
				dvoArray[j] = dVO;
				if (j < evoArray.length - 1)
					j++;
			} ////////////////////////////// end of while(set and store dvo)

			for (DeptVO d : dvoArray) {
				System.out.println(d.getDeptno() + " "
											+ d.getDname() + " "
											+ d.getLoc());
			} //////////////////////// end of for(dvoArray print)

			try {
				rset.close();
				stmt.close();
				conn.close();
			} ////////////// end of try in finally
			catch (SQLException e) {
				e.printStackTrace();
			} ////////////// end of catch SQLException in finally
		} ///////////////// end of try
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} //////////////// end of catch ClassNotFoundException
		catch (SQLException e) {
			e.printStackTrace();
		} //////////////// end of catch SQLException
	}////////////////////// end of testConnect

	public static void main(String[] args) {
		EmpVO		evo			= new EmpVO();
		DeptVO		dvo			= new DeptVO();
		TestVO		tvo			= new TestVO();
		EmpVO[]		evoArray	= new EmpVO[14];
		DeptVO[]	dvoArray	= new DeptVO[4];
		tvo.testConect(evoArray, dvoArray);
	}
}