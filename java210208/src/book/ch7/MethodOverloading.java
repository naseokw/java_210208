package book.ch7;

//import com.vo.DeptVo;	내 컴퓨터에 해당 패키지가 없음ㅋㅋ

public class MethodOverloading {
	void go() {}
//	public void go() {} 		//접근제한자는 영향없다
//	int go() {return 0;}		//리턴타입 여부는 상관없다
	
	public void go(int[] a) {}	//오버로딩임
//	public void go(int[] b) {}	//오버로딩이 아님
	
//	public void go(DeptVO dvo) {}	//오버로딩인데 집컴에 저 클래스가 없는듯
	
	public static void main(String[] args) {
	
	}
}
