package design.duck;

/*
 * 생성자, 일반 변수가 올 수 없다
 * 메서드 이름 앞에 abstract 생략 가능하다
 * 메서드 뒤에 바디({})가 없이 ;로 끝난다
 */

public interface FlyBehavior {
	public void fly();
}
