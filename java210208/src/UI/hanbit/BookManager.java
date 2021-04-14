package UI.hanbit;

import javax.swing.JFrame;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BookManager extends JFrame {

	Logger logger = LogManager.getLogger(BookManager.class);
	// 선언부
	JFrame jf = new JFrame();
//	static JFrame bm = new BookManager();
//	static BookManager bm2 = new BookManager();
	static BookManager bm3 = null;

	// 생성자
	public BookManager() {
		// bm.initDisplay();
		// jf.initDisplay();
//		initDisplay();
//		this.setSize(500,300);
		this.setSize(600,700);
		//우리는 setVisible에 대해서 오버라이딩을 하지않았다. 따라서 부모의 메소드가 호출되었다.
		this.setVisible(true);
	}

	// 화면처리부
	public void initDisplay() {
		logger.info("initDisplay() 호출성공");
	}

	// 메인메소드
	public static void main(String[] args) {
		bm3 = new BookManager();
		bm3.initDisplay();
	}

}
