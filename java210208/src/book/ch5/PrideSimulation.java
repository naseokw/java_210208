package book.ch5;

public class PrideSimulation {

	public static void main(String[] args) {
		/*
		 * private로 선언했을 경우 Encapsulation이 적용되는 것이다
		 * constructor를 선언할 때 private로 선언했으므로 default constructor를
		 * 활용하고 싶다면 싱글턴 패턴으로 정의하여 사용해야 한다
		 */
		Pride myCar = Pride.getPride();
		Pride himCar = new Pride(10);
		Pride herCar = new Pride(100, 4);
		
		System.out.println("wheelNum = " + Pride.wheelNum);
		
		Pride.wheelNum = 8;
		
		System.out.println("wheelNum = " + Pride.wheelNum);
		
		himCar.speed = 10;
		herCar.speed = 50;
		myCar.speed = 20;
		
		System.out.println("himSpeed = " + himCar.speed
						+ "\nherSpeed = " + herCar.speed
						+ "\nmySpeed = " + myCar.speed);
		
		Pride.change();
		
		System.out.println("wheelNum = " + Pride.wheelNum);
	}
}
