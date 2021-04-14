package ch5.singleton;

/***********************************************************
 * 싱글턴 패턴의 정의
 * 해당 클래스의 인스턴스가 하나만 만들어지고
 * 어디서든지 그 인스턴스에 접근할 수 있도록 하기 위한 패턴이다
 * 고전적인 싱글턴 구현 방법
 * 
 **********************************************************/
public class Singleton1_1 {
	
	private static Singleton1_1 uniqueInstanse = null;
	
	public static Singleton1_1 getinstance() {
		if (uniqueInstanse == null) {
			uniqueInstanse = new Singleton1_1();
		}
		return uniqueInstanse;
	}
}
