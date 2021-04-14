package ch5.singleton;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ViewApp extends JFrame{
	
	JPanel jp_south = null;
	JButton jbtn_close = null;
	EventHandler eh = null;
	private static ViewApp view = null;
	
	public ViewApp() {
		initDisplay();
	}
	
	private ViewApp(int width, int height) {
		initDisplay();
	}
	
	public static synchronized ViewApp getInstance() {
		if (view == null) {
			view = new ViewApp(700, 700);
		}
		return view;
	}
	
	public void initDisplay() {
		eh = new EventHandler(this);
		jp_south = new JPanel();
		jbtn_close = new JButton("Close");
		jp_south.setLayout(new BorderLayout());
		this.add("South", jp_south);
		jp_south.add(jbtn_close);
		/* 
		 * 이벤트 소스와 이벤트 처리를 담당하는 클래스를 연결해주어야 한다
		 * 이벤트 처리를 담당하는 클래스를 이벤트 핸들러 클래스라고 한다
		 * 이벤트 처리를 담당하는 클래스는 반드시 ActionPerformed라는 메서드를 오버라이딩해야 한다
		 */
		jbtn_close.addActionListener(eh);
		//이벤트처리 메서드가 외부에 있는 때는 this 사용할 수 없음
		this.setSize(500, 400);
		this.setTitle("ViewApp");
		this.setVisible(true);
	}

	public static void main(String[] args) {
//		JFrame myView = new ViewApp();
		ViewApp.getInstance();
		
	}
}
