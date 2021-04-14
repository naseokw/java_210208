package design.duck;

public class FlyNoWay implements FlyBehavior {

	@Override
	public void fly() {
		System.out.println("오리는 날 수 없다 엄마에게 혼났죠");
	}
}
