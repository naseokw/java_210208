package com.design.zipcode;

public class StringTest {

	public static void main(String[] args) {
		String sql = "SELECT";
		sql += " empno, ename";
		sql += " FROM emp";
		sql += " WHERE empno > 7000";
		System.out.println(sql);

		String sql2 = "JAVA";
		// J를 H로 바꾸더라도 원본은 유지가 된다
		// 원본을 바꾸려면 sql2 = sql2.replace('J', 'H');
		// 계속 새로운 객체를 생성하게 된다
		sql2.replace('J', 'H');
		System.out.println(sql2);
	}
}
