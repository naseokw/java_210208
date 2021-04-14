package variable.step1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class LoginView extends Object implements ActionListener {
//	인터페이스. 결합도 낮추는 코드 작성할 때 필요, 클래스 설계 시 필요
	
	JFrame jf = new JFrame();
//	화면 그리기 구현
	
	JButton jbtn_login = new JButton("로그인");
	
	public void initDisplay() {
//		자기 자신이 이벤트 처리를 담당하는 핸들러 클래스이다 라는 의미로 this 사용하기도 함
		jbtn_login.addActionListener(this);//이벤트 소스와 이벤트 처리를 담당하는 클래스 연결, 매칭
		jf.setSize(500, 500);
		jf.add("North", jbtn_login);
		jf.setTitle("LoginView");
		jf.setVisible(true);
	}
//	클래스 내부에 있는 메서드이지만 static 영역 내부에서 non-static에 접근할 수 없으므로 인스턴스화를 해서 해결
	public static void main(String[] args) {
		LoginView lv = new LoginView();
		lv.initDisplay();
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (jbtn_login == e.getSource()) { //이벤트 감지는 컴퓨터가, 버튼의 주소는 내가 정의. 주소가 동일한가?
			System.out.println("유성열님 환영합니다.");
		}
	}

}
