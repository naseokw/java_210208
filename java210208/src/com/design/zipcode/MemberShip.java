package com.design.zipcode;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import common.jdbc.MemberDAO;

public class MemberShip extends JDialog implements ActionListener {
	// 선언부
	JPanel				jp_center		= new JPanel();
	JLabel				jlb_id			= new JLabel("아이디");
	public JTextField	jtf_id			= new JTextField(10);
	JLabel				jlb_pw			= new JLabel("패스워드");
	public JTextField	jtf_pw			= new JTextField(10);
	JLabel				jlb_nickName	= new JLabel("대화명");
	public JTextField	jtf_nickName	= new JTextField(20);
	JLabel				jlb_name		= new JLabel("성명");
	public JTextField	jtf_name		= new JTextField(30);
	JLabel				jlb_gender		= new JLabel("성별");
	String[]			genderList		= { "남자", "여자" };
	public JComboBox	jcb_gender		= new JComboBox(genderList);
	JLabel				jlb_zipcode		= new JLabel("우편번호");
	public JTextField	jtf_zipcode		= new JTextField(6);
	JLabel				jlb_address		= new JLabel("주소");
	public JTextField	jtf_address		= new JTextField(100);
	JButton				jbtn_zipcode	= new JButton("우편번호찾기");
	JScrollPane			jsp				= null;
	JPanel				jp_south		= new JPanel();
	JButton				jbtn_ins		= new JButton("등록");
	JButton				jbtn_close		= new JButton("닫기");

	public int			gender			= 0;
//	ZipCodeSearch zcs = new ZipCodeSearch(this);

	// 생성자
	public MemberShip() {
		initDisplay();
	}

	// 화면처리부
	public void initDisplay() {
		jbtn_zipcode.addActionListener(this);
		jbtn_ins.addActionListener(this);
		jbtn_close.addActionListener(this);
		jp_center.setLayout(null);
		jlb_id.setBounds(20, 20, 100, 20);
		jtf_id.setBounds(120, 20, 120, 20);
		jlb_pw.setBounds(20, 45, 100, 20);
		jtf_pw.setBounds(120, 45, 120, 20);
		jlb_nickName.setBounds(20, 70, 100, 20);
		jtf_nickName.setBounds(120, 70, 150, 20);
		jlb_name.setBounds(20, 95, 100, 20);
		jtf_name.setBounds(120, 95, 150, 20);
		jlb_gender.setBounds(20, 120, 100, 20);
		jcb_gender.setBounds(120, 120, 150, 20);
		jcb_gender.setFont(new Font("굴림", 1, 14));
		jlb_zipcode.setBounds(20, 145, 100, 20);
		jtf_zipcode.setBounds(120, 145, 100, 20);
		jbtn_zipcode.setBounds(230, 145, 120, 20);
		jlb_address.setBounds(20, 170, 100, 20);
		jtf_address.setBounds(120, 170, 250, 20);
		jp_center.add(jlb_id);
		jp_center.add(jtf_id);
		jp_center.add(jlb_pw);
		jp_center.add(jtf_pw);
		jp_center.add(jlb_nickName);
		jp_center.add(jtf_nickName);
		jp_center.add(jlb_name);
		jp_center.add(jtf_name);
		jp_center.add(jlb_gender);
		jp_center.add(jcb_gender);
		jp_center.add(jlb_zipcode);
		jp_center.add(jtf_zipcode);
		jp_center.add(jbtn_zipcode);
		jp_center.add(jlb_address);
		jp_center.add(jtf_address);
		jp_south.setLayout(new FlowLayout(FlowLayout.RIGHT));
		jp_south.add(jbtn_ins);
		jp_south.add(jbtn_close);
		this.add("South", jp_south);
		jsp = new JScrollPane(jp_center);
		this.add("Center", jsp);
		this.setTitle("회원가입");
		this.setSize(400, 500);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		boolean	isRefused	= false;
		Object	obj			= e.getSource();

		if (obj == jbtn_zipcode) {
			ZipCodeSearch zipcodeSearch = new ZipCodeSearch(this);
		}

		else if (obj == jbtn_ins) {

			if ("".equals(jtf_id.getText()) || "".equals(jtf_address.getText()) || "".equals(jtf_name.getText())
										|| "".equals(jtf_nickName.getText()) || "".equals(jtf_pw.getText())
										|| "".equals(jtf_zipcode.getText())) {
				JOptionPane.showMessageDialog(this, "모든 정보를 입력해주십시오");
			}
			else {

				if ("남자".equals(jcb_gender.getSelectedItem())) {
					gender = 0;
				}
				else {
					gender = 1;
				}

				MemberDAO memberDAO = new MemberDAO();
				isRefused = memberDAO.join(this);

				if (isRefused != true) {
					JOptionPane.showMessageDialog(this, "회원가입 성공");
					this.dispose();
				}
				else {
					JOptionPane.showMessageDialog(this, "중복된 아이디입니다");
					jtf_id.setText("");
				}
			}
		}

		else if (obj == jbtn_close) {
			this.dispose();
		}
	}
}