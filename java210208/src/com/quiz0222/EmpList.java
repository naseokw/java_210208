package com.quiz0222;

public class EmpList {
	
	
	public String[] getEmpDetail(int empno) {
		String[] info = new String[2];
		EmpVO eVO = new EmpVO();
		eVO.setEmpno(7566);
		int deptno = eVO.getDeptno();//7566 사원에 대한 부서번호
		String ename = eVO.getEname();
		info[0] = ename;
		DeptVO dVO = new DeptVO();
		dVO.setDeptno(deptno);
		String dname = dVO.getDname();
		info[1] = dname;
		return info;
		
	}

	public static void main(String[] args) {

		EmpList el = new EmpList();
		String[] myInfo = new String[2];
		myInfo = el.getEmpDetail(7566);
		System.out.println(myInfo[0]);
		System.out.println(myInfo[1]);
	}

}
