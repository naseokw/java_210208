package design.duck;

/*
 * 단독으로는 인스턴스화를 할 수 없다
 * 반드시 구현체 클래스가 있어야 한다
 * 메서드 오버라이딩을 꼭 해야 한다
 */

public class FlyWithWings implements FlyBehavior {

	@Override
	public void fly() {
		System.out.println("오리가 난다요");
	}
}
