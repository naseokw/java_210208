package design.duck;

/*
 * 추상클래스는 생성자와 일반메서드 추상메서드를 가질 수 있다
 * 전역변수 선언도 가능하다
 * 추상 메서드의 경우 일반메서드와 구분하기 위해
 * 메서드 이름 앞에 abstract를 붙인다
 */

public abstract class Duck {
	FlyBehavior flyBehavior = null;
	QuackBehavior quackBehavior = null;

	public Duck() {
		System.out.println("Duck 생성자 호출");
	}

	public abstract void display();

	public void performFly() {
		flyBehavior.fly();
	}

	public void performQuack() {
		quackBehavior.quack();
	}

	public void swimming() {
		System.out.println("모든 오리는 물에 뜬다");
	}
}
