package com.ocjp;

public class ParamTest {

	void effectParam(Param P) {
	//P = new Param(); // 500, 100
	P.ival = 500;
	
	System.out.println("메서드가 바꾼 ival = " + P.ival);
}

	public static void main(String[] args) {
		Param p = new Param();
		ParamTest pt = new ParamTest();
		p.ival = 100;
		
		pt.effectParam(p);	//line 6 코멘트 처리하면 500, 500
		System.out.println("main ival = " + p.ival);
	}
}
