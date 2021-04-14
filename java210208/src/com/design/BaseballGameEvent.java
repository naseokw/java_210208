package com.design;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class BaseballGameEvent implements ActionListener {
	
//	static BaseballGameView bgView = null;
	BaseballGameLogic bgLogic = new BaseballGameLogic();
	BaseballGameView bgView = null;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		bgView = BaseballGameView.getInstance();
		
		Object obj = e.getSource();
		// 라벨값으로 처리하고 싶으면
		String label = e.getActionCommand(); //새게임,지우기
		System.out.println("event label:"+label);
		if(obj == bgView.jtf_input){
			String input =  bgView.jtf_input.getText().trim();
			
			//만일 숫자가 아닌 값이 있을 때도 고려해야 한다.
			try {
				Integer.parseInt(input);//356
			} catch (NumberFormatException nfe) {
				bgView.jop.showMessageDialog(bgView.jf, "숫자만 입력하세요", "Error", JOptionPane.ERROR_MESSAGE);
				bgView.jtf_input.setText("");
				bgView.jtf_input.requestFocus();				
				return;
			}
			
			if(input.length() != 3){
				bgView.jop.showMessageDialog(bgView.jf, "세 자리만 입력하라고");
				bgView.jtf_input.setText("");
			}
			else{
				bgView.jta_display.append(++bgLogic.cnt + "번째 시도 : " + bgView.jtf_input.getText() + " : " + bgLogic.screen(input) + "\n");
				bgView.jtf_input.setText("");
			}
		}
		else if("지우기".equals(label)){
			bgView.jta_display.setText("");
			bgView.jtf_input.requestFocus();
		}
		else if("종료".equals(label) || obj == bgView.jmi_exit){
			System.exit(0);// 자바 가상머신과의 연결고리를 끊는다.
		}
		else if(obj == bgView.jbtns[1] || obj == bgView.jmi_dap){
			bgView.jta_display.append("정답은 " + bgLogic.randNum[0] + bgLogic.randNum[1] + bgLogic.randNum[2] + "\n");
//			bgLogic.randGenerate();
		}
		////////////////////////////////////////<<새 게임>>////////////////////////////////////////
		else if(obj == bgView.jbtns[0] || obj == bgView.jmi_new){
			bgLogic.cnt = 0;
			bgLogic.randGenerate();
			bgView.jta_display.setText("야구게임 시작! 세 자리 숫자 츄라이 츄라이\n");
			bgView.jtf_input.setText("");
			bgView.jtf_input.requestFocus();
		}
		////////////////////////////////////////<<새 게임>>////////////////////////////////////////
	}
}
