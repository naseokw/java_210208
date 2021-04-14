package book.ch5;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class SalaryMgrView extends JFrame {
	
	JPanel jp_north = new JPanel();
	JPanel jp_center = new JPanel();
	SalaryMgrEventHandler emEvent = null;
	
	JTable jt = null;
	JScrollPane	jsp = null;
	JTableHeader jth = null;
	JButton[] jbs = null;
	JButton jb = null;
	String[] jbs_lable = {"조회", "입력", "수정", "삭제", "종료"};

	String[] cols = {"eName", "dName"};
	String[][] data = new String[0][2];
	DefaultTableModel dtm = new DefaultTableModel(data, cols);
//	SalaryMgrLogic smLogic = new SalaryMgrLogic();
	
	
//	SalaryMgrView(SalaryMgrEventHandler smeh) {
	SalaryMgrView() {
		emEvent = new SalaryMgrEventHandler(this);		//로 하고 emEvent 리스너에 넣어도 됨
//		smLogic = new new SalaryMgrLogic(this);
		jt = new JTable(dtm);
		jsp = new JScrollPane(jt);
		//Line 37 : 메서드를 통해서 객체를 주입받을 수 있다
		jth = jt.getTableHeader();
		jth.setBackground(Color.green);
		jth.setReorderingAllowed(false);
		jbs = new JButton[jbs_lable.length];
		jp_north.setLayout(new GridLayout(1, 5, 3, 3));
		jp_center.setLayout(new BorderLayout());
		for (int i = 0; i < jbs_lable.length; i++) {
			jb = new JButton(jbs_lable[i]);
			jp_north.add(jb);
			jbs[i] = jb;
			jbs[i].addActionListener(emEvent);
		}
		initDisplay();
	}
	
	public void initDisplay() {
		this.add("North",jp_north);
		this.add("Center",jsp);
		this.setTitle("급여명세서");
		this.setSize(400, 300);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
//		SalaryMgrLogic sml = new SalaryMgrLogic();
		new SalaryMgrView();
	}////////////////end of main
}////////////////////end of class
