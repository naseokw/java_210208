package ch5.singleton;

public class Testing {

	public static void main(String[] args) {
		
		Singleton1_1 s1 = new Singleton1_1();
		System.out.println(s1);
		s1 = new Singleton1_1();
		System.out.println(s1);
		s1 = new Singleton1_1();
		System.out.println(s1);
		s1 = new Singleton1_1();
		System.out.println(s1);
		
		System.out.println();
		
		System.out.println(Singleton1_1.getinstance());
		System.out.println(Singleton1_1.getinstance());
		System.out.println(Singleton1_1.getinstance());
		System.out.println(Singleton1_1.getinstance());
	}
}
