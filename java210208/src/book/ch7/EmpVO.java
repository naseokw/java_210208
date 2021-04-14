package book.ch7;
//EmpVO는 한 개의 row만 담을 수 있다
public class EmpVO {
	private int empno = 0;
	private String ename = null;
	private double sal = 0.0;
	
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
	public double getSal() {
		return sal;
	}
	public void setSal(double sal) {
		this.sal = sal;
	}
}
