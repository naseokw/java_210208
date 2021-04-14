package variable.step1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class LoginView2 extends JFrame implements ActionListener {
//	인터페이스. 결합도 낮추는 코드 작성할 때 필요, 클래스 설계 시 필요
//	화면 그리기 구현
	
	JButton jbtn_login = new JButton("로그인");
	
	public void initDisplay() {
//		자기 자신이 이벤트 처리를 담당하는 핸들러 클래스이다 라는 의미로 this 사용하기도 함
		jbtn_login.addActionListener(this);//이벤트 소스와 이벤트 처리를 담당하는 클래스 연결, 매칭 - 콜백메서드가 호출됨
		this.setSize(500, 500);
		this.add("North", jbtn_login);
		this.setTitle("LoginView");
		this.setVisible(true);
	}
//	클래스 내부에 있는 메서드이지만 static 영역 내부에서 non-static에 접근할 수 없으므로 인스턴스화를 해서 해결
	public static void main(String[] args) {
		LoginView2 lv = new LoginView2();
		lv.initDisplay();
		
	}
	//같은 이름의 메서드를 여러 개 정의할 수 있다. 뒷받침하는 개념이 메서드 오버로딩(파라미터 개수 타입 달라야 함) 오버라이딩(이름이 같고 상속관계)
	//@Override는 annotation이라고 함(메타데이터)
	@Override
	public void actionPerformed(ActionEvent e) {//콜백메서드. 내가 호출하는 메서드가 아닌 이벤트 감지가 일어나면 자동호출
		if (jbtn_login == e.getSource()) { //이벤트 감지는 컴퓨터가, 버튼의 주소는 내가 정의. 주소가 동일한가?
			System.out.println("유성열님 환영합니다.");
		}
	}

}
