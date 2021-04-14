package com.quiz0222;

public class DeptVO {
	public EmpVO getEvo() {
		return evo;
	}
	public void setEvo(EmpVO evo) {
		this.evo = evo;
	}
	//이하 변수들은 모두 private로 한다. - Encapsulation 데이터 보호, 직접 값을 변경할 수 없다
	//각각 값을 유지하거나 재사용하는 문제는 인스턴스화에 따라 각각 다르게 활용할 수 있다
	//값을 초기화하는 방법에 대해서는 두 가지 있음. 1) setter, 2) constructor
	private int deptno = 0;
	private String dname = null;
	private String loc = null;
	private EmpVO evo = null;				//Department ⊃ Employee
	
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
}