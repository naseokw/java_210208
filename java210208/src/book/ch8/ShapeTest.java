package book.ch8;

public class ShapeTest {

	public static void main(String[] args) {
		Shape	s1	= new Rectangle();
		Shape	s2	= new Circle();
		s1.area();
		s2.area();
//		s2.area(5);

		Circle s3 = new Circle();
		s3.area(5);
	}
}
