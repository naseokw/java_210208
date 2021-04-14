package com.ocjp;


interface ImInterface {
	void methodA();
	void iminterface();
}

abstract class ImAbstract {
	int i = 0;
	
	void methodB() {
		System.out.println();
	}
	void methodC() {
		
	}
}

public class Ocjp52 extends ImAbstract implements ImInterface{
	
	int i;
	
	void methodB() {
		System.out.println("오버라이드된 메서드");
	}
	
	void methodB(int i) {
		super.i = this.i;
	}

	public enum Dogs {collie, harrier, shepherd};

	public static void main(String[] args) {
		

		Dogs myDog = Dogs.shepherd;

		switch (myDog) {
		case collie:
			System.out.println("collie");
			break;
		case shepherd:
			System.out.println("shepherd");
			break;
		case harrier:
			System.out.println("harrier");
			break;
		}//////////////end of switch
	}//////////////////end of main 

	@Override
	public void methodA() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void iminterface() {
		// TODO Auto-generated method stub
		
	}
}
