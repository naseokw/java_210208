package design.duck;

public class RubberDuck extends Duck {
	public RubberDuck() {
		flyBehavior = new FlyWithWings();
		quackBehavior = new Squeak();
	}

	@Override
	public void display() {
		System.out.println("나는 고무오리입니다");
	}
}
