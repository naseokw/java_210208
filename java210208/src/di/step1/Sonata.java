package di.step1;

public class Sonata extends Object {
	private String	carColor	= null;
	private int		speed		= 0;
	private int		whellNum	= 4;

	public Sonata(String carColor, int speed) {
		this.carColor = carColor;
		this.speed = speed;
	}

	public Sonata() {

	}

	public String toString() {
		return "그녀의 자동차의 색은 " + this.carColor + "이고 현재 속도는 " + this.speed + "입니다";
	}
}