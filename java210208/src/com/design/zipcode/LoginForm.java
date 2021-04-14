package com.design.zipcode;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import common.jdbc.MemberDAO;

public class LoginForm extends JFrame implements ActionListener {
	String			imgPath		= "src\\";
	ImageIcon		ig			= new ImageIcon(imgPath + "main.png");
	JLabel			jlb_id		= new JLabel("아이디");
	JTextField		jtf_id		= new JTextField("");
	JLabel			jlb_pw		= new JLabel("비밀번호");
	JPasswordField	jtf_pw		= new JPasswordField("");
	Font			font		= new Font("맑은 고딕", Font.BOLD, 15);
	JButton			jbtn_login	= new JButton(new ImageIcon(imgPath + "login.png"));
	JButton			jbtn_join	= new JButton(new ImageIcon(imgPath + "confirm.png"));
//	TalkDao tDao = new TalkDao();
	public String	nickName	= null;													// 닉네임 등록
	public boolean	isActivate	= true;

	public LoginForm() {
		initDisplay();
	}

	// 내부 클래스로 배경 이미지 처리
	class MyPanel extends JPanel {
		public void paintComponent(Graphics g) {
			g.drawImage(ig.getImage(), 0, 0, null);
			setOpaque(false);
			super.paintComponent(g);
		}
	}

	public void initDisplay() {
		jbtn_login.addActionListener(this);
		jbtn_join.addActionListener(this);
		this.setContentPane(new MyPanel());
		this.setLayout(null);// 디폴트 - BorderLayout
		jlb_id.setBounds(45, 200, 80, 40);
		jlb_id.setFont(font);
		jtf_id.setBounds(110, 200, 185, 40);
		this.add(jlb_id);
		this.add(jtf_id);
		jlb_pw.setBounds(45, 240, 80, 40);
		jlb_pw.setFont(font);
		jtf_pw.setBounds(110, 240, 185, 40);
		this.add(jlb_pw);
		this.add(jtf_pw);
		jbtn_join.setBounds(45, 285, 120, 40);
		this.add(jbtn_join);
		jbtn_login.setBounds(175, 285, 120, 40);
		this.add(jbtn_login);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("자바채팅 Ver2.0");
		this.setLocation(500, 100);
		this.setSize(350, 600);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		LoginForm login = new LoginForm();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object		obj			= e.getSource();
		MemberDAO	memberDAO	= new MemberDAO();

		if (jbtn_login == obj) {

			if ("".equals(jtf_id.getText()) || "".equals(jtf_pw.getText())) {
				JOptionPane.showMessageDialog(this, "아이디와 비밀번호를 확인하세요.");
				return;
			}

			try {
				String	mem_id	= jtf_id.getText();
				String	mem_pw	= jtf_pw.getText();
				String	msg		= memberDAO.login(mem_id, mem_pw);

				if ("아이디가 존재하지 않습니다.".equals(msg)) {
					JOptionPane.showMessageDialog(this, "아이디를 확인하세요.");
					jtf_id.setText("");
					jtf_pw.setText("");
					return;
				}
				else if ("비밀번호가 틀립니다.".equals(msg)) {
					JOptionPane.showMessageDialog(this, "비밀번호를 확인하세요.");
					jtf_id.setText("");
					jtf_pw.setText("");
					return;
				}
				else {
					nickName = msg;
					isActivate = false;
					JOptionPane.showMessageDialog(this, "로그인 성공", "info", JOptionPane.INFORMATION_MESSAGE);
					this.setVisible(false);
				}

			}
			catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		else if (jbtn_join == obj) {
			MemberShip membershipView = new MemberShip();
		}
	}
}