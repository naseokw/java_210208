package book.ch8;

public class Rectangle extends Shape {
	int	width	= 10;
	int	height	= 4;

	@Override
	void area() {
		double area = 0.0;
		area = width * height;
		System.out.println("직사각형의 면적은 " + area);
	}

	@Override
	void fillDraw() {

	}
}
