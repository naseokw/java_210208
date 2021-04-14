package variable.step1;

public class Quiz1 {
	int i; //전역변수 선언&초기화는 한 줄에, 선언만 하면 ok
	//메소드에는 2가지 종류가 있다.
	//JVM에 제공되는 메서드와 사용자 정의 메서드
	//메서드 선언 순서는 : 리턴타입 메서드이름() {실행문;} - 기초가 있다.
	//메서드 선언할 때 리턴타입과 반환타입을 결정할 수 있다. - 기초가 아니다. 코딩을 해봐야 한다. 책X
	
	public static void main(String[] args) {
		Quiz1 q = new Quiz1();
		
		q.methodA();
		q.methodA(0);
		//methodA의 호출이 선언 앞에 오더라도 에러가 아니다
		//절차지향이 아닌 객체지향언어이므로 호출순서와 상관없다
		//자바에서 같은 이름의 메서드를 중복 선언 가능
		//이것을 '메서드 오버로딩'이라고 한다
		//이것은 반드시 매개변수의 타입이 다르거나 개수가 달라야 한다
		//주의사항 : 리턴타입 있고 없고는 영향을 주지 않는다
	}
	
	void methodA() {
		System.out.println("void methodA() call");
	}
	
	void methodA(int i) {
		System.out.println("void methodA(int i) call, i = " + i);
	}
	
	int methodA(double d) {
		System.out.println("int methodA() call");
		
		return 56;
	}
}
