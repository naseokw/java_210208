package book.ch5;

public class ParameterTest {
	
	String g_rdname = null;

	static int methodA() {
		
		return 100;
	}
	static int methodA(int p_empno) {
		
		return 100;
	}
	void methodA(int p_empno, String rdname) {
		g_rdname = rdname;
	}
//	String methodA(int p_empno, String rdname) {
//		g_rdname = rdname;
//		return g_rdname;
//	}		//굳이 이렇게도 할 수는 있네
	
	public static void main(String[] args) {
//		int x = ParameterTest.methodA();
		int x = ParameterTest.methodA(7566);
//		int x = methodA(7566); // =Line25 but implicit
		System.out.println(x);
		String g_rdname = "개발2팀";
		ParameterTest pt = new ParameterTest();
		pt.methodA(7566, g_rdname);
		//바로 밑에서는 메서드를 경유하지 않기 때문에 null;
		System.out.println(new ParameterTest().g_rdname);
		//여기서는 전역변수의 값이 출력되니까 개발2팀이 출력되고
		//당연하게 30에서 methodA를 경유할 때 새롱누 값으로 초기화가 일어나기 때문
		System.out.println(pt.g_rdname);
	}

}
