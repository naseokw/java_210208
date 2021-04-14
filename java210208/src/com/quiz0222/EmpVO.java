package com.quiz0222;

public class EmpVO {
	
	public EmpVO() {
//		System.out.println("Default Constructor called");
	}
	
	public EmpVO(int empno) {
		this.empno = empno;
	}
	
	public EmpVO(int empno, String ename, String job,
				int mgr, String hiredate, double sal,
				double comm, int deptno, DeptVO dvo) {
		this.empno    = empno;
		this.ename    = ename;
		this.job      = job;
		this.mgr      = mgr;
		this.hiredate = hiredate;
		this.sal      = sal;
		this.comm     = sal;
		this.deptno   = deptno;
		this.dvo      = dvo;							//중요함.
	}
	
	
	
	public DeptVO getDvo() {
		return dvo;
	}
	public void setDvo(DeptVO dvo) {
		this.dvo = dvo;
	}
	
	private int empno = 0;
	private String ename = null;
	private String job = null;
	private int mgr = 0;
	private String hiredate = null;
	private double sal = 0.0;
	private double comm = 0.0;
	private int deptno = 0;
	private DeptVO dvo = null;
	
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public int getMgr() {
		return mgr;
	}
	public void setMgr(int mgr) {
		this.mgr = mgr;
	}
	public String getHiredate() {
		return hiredate;
	}
	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}
	public double getSal() {
		return sal;
	}
	public void setSal(double sal) {
		this.sal = sal;
	}
	public double getComm() {
		return comm;
	}
	public void setComm(int comm) {
		this.comm = comm;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
}