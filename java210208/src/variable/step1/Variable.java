package variable.step1;

public class Variable {
	//선언부
	
	//메서드 선언
	void methodA(int x) {

	}
	double methodB(int x) {
		System.out.println(x);
		return 3.14;
	}
	//메인메서드 - exe 파일로 만들 수 있다
	/**************************************************
	 * 문제해결능력을 키움
	 * @return void이다. 비어있다. 돌려받을 수 있는 값이 없다.
	 * 			이것때문에 에러가 발생할 수도 있다.
	 * @param args
	 */
	public static void main(String[] args) {
		//system:나의컴퓨터 out속성:출력장치, print():이건 illegal, print(int i), print(double pi), print("안녕")
		Variable v = new Variable();
		
		System.out.print(10 + " ");
		System.out.print(v.methodB(1) + " "); //메서드를 호출할 수 있는가?? 주소.methodA();
		System.out.print(5); //메서드를 호출할 수 있는가?? 주소.methodA();
		//메서드를 선언할 때는 {}를 사용
		//호출할 때는 ;
		//API, XXX.jar, 이 안(클래스 안에 객체[결정되지 않았다] 안에)에 있는 것을 꺼내쓴다.
		//print메서드는 여러 개이다. 같은 이름의 메서드를 여러 개 만들 수 있다.
//		System.out.print();//줄바꿈 안됨
		System.out.println();//줄바꿈 추가된 메서드
	}
}
