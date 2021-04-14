package book.ch5;

/*
 * 싱글턴 패턴의 정의
 * 해당 클래스의 인스턴스가 하나만 만들어지고
 * 어디서든지 그 인스턴스에 접근할 수 있도록 하기 위한 패턴이다
 * 클래스 변수
 * 인스턴스 변수
 * 방법1 - 고전적인 싱글턴패턴 구현법
 * 방법2 - 성능이나 병목현상을 고려하여 구현하기
 * 방법3 - 
 *
 */

public class Pride {
	//클래스 변수이다
	static int wheelNum = 0;
	int speed = 0;
	
	private Pride() {
		
	}
	
	public Pride(int speed) {
		this.speed = speed;
	}
	
	public Pride(int speed, int wheelNum) {
		this.speed = speed;
		this.wheelNum = wheelNum;
	}
	
	void speedUP() {
		speed += 1;
	}
	
//	static void stop() {
//		speed = 0;
//	}
	
	static void change() {
		wheelNum = 2;
	}
	
	public static Pride getPride() {
		Pride myCar = null;
		if(myCar == null) {myCar = new Pride();}
		return myCar;
	}
}
