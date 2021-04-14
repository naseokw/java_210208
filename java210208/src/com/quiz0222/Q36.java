package com.quiz0222;

public class Q36 {
	/*
	 * non-static 영역에서 static 타입은 접근할 수 있다
	 * 그러나 static 영역에서 non-static은 접근 불가 
	 * 
	 */

	static {
		System.out.println("Static block");
	}
	void methodA() {
		System.out.println("methodA 호출");
		methodB();
	}
	
	static void methodB() {
//		methodA();
		System.out.println("static methodB 호출");
	}
	/*
	 * 메인메서드도 staic이다
	 * Main Thread라고 한다. 우선순위가 높다
	 * JavaScript는 Single Thread이다.
	 */
	
	public static void main(String[] args) {
		Q36.methodB();
		
		
	}

}
