package book.ch4;

import java.util.StringTokenizer;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class SwitchTest2 extends JFrame{

	public static void main(String[] args) {
		
		/*
		 * 제어문의 역할은 업무 순서에 대한 흐름을 바꾼다.
		 * 순서에 대한 정보를 바탕으로 의사를 결정할 수 있는 것은
		 * 팀장, 차장, 부장 선택자의 선택(비즈니스로직계층-모델계층)에 따라
		 */
		SwitchTest2 st2 = new SwitchTest2();
		int signal = 0;
		String nickName = "geundu";
		String inputMsg = "야 세르게이 작은 고추의 매운 맛을 보여주마";
		String msg = 300 + "#" + nickName + "#" + inputMsg;
		StringTokenizer st = new StringTokenizer(msg, "#");
		signal = Integer.parseInt(st.nextToken());
		String tokenName = st.nextToken();
		String tokenMsg = st.nextToken();
		
		
		switch (signal) {
		
		case 100:
			System.out.println("case 1 printed");
			break;
		case 200:
			System.out.println("case 2 printed");
			break;
		case 300:
			System.out.println("[" + tokenName + "] " + tokenMsg);
			break;
		default:
			JOptionPane.showMessageDialog(st2, "해당되는 시그널이 없음");
			break;
		}///////////end of switch	
	}///////////////end of main
}
