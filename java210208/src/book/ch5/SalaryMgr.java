package book.ch5;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.quiz0222.DeptVO;
import com.quiz0222.EmpVO;

public class SalaryMgr extends JFrame implements ActionListener{
	//선언부
	JPanel jp_north = new JPanel();
	JPanel jp_center = new JPanel();
	String[] cols = {"eName", "dName"};
	String[][] data = new String[0][2];
	JTable jt = null;
	DefaultTableModel dtm = null;
	JScrollPane	jsp = null;
	JTableHeader jth = null;
	JButton[] jbs = null;
	JButton jb = null;
	String[] jbs_lable = {"조회", "입력", "수정", "삭제", "종료"};
	
	//Constructor
	public SalaryMgr() {
		dtm = new DefaultTableModel(data, cols);
		jt = new JTable(dtm);
		jsp = new JScrollPane(jt);
		//Line 37 : 메서드를 통해서 객체를 주입받을 수 있다
		jth = jt.getTableHeader();
		jbs = new JButton[jbs_lable.length];
		jp_north.setLayout(new GridLayout(1, 5, 3, 3));
		for (int i = 0; i < jbs_lable.length; i++) {
			jb = new JButton(jbs_lable[i]);
			jp_north.add(jb);
			jbs[i] = jb;
			jbs[i].addActionListener(this);
		}
		initDisplay();
	}
	//화면처리부
	public void initDisplay() {
		jth.setBackground(Color.green);
		jth.setReorderingAllowed(false);
		this.add("North",jp_north);
		this.add("Center",jsp);
		jp_center.setLayout(new BorderLayout());
		this.setTitle("급여명세서");
		this.setSize(400, 300);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		SalaryMgr sm = new SalaryMgr();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		String command = e.getActionCommand();
		//jbs[0 ~ 4] == e.getSource() || obj 도 가능하지만 직관적이지 않다.
		if ("조회".equals(command)) {
			System.out.println("조회 버튼 눌렸음");
			EmpVO evo = new EmpVO();
			evo.setEname("유성열");
			DeptVO dvo = new DeptVO();
			dvo.setDname("KOSMO80");
			evo.setDvo(dvo);								//Line 75~79 : 핵심
			
//			Vector oneRow = new Vector();
//			oneRow.addElement(evo.getEname());
//			oneRow.addElement(evo.getDvo().getDname());		//확인 주소.주소.메서드
//			dtm.addRow(oneRow);
			
			Vector oneRow = new Vector();
			oneRow.addElement("");
			oneRow.addElement("");		//확인 주소.주소.메서드
			dtm.addRow(oneRow);
			
			for (int row = 0; row < 1; row++) {
				dtm.setValueAt(evo.getEname(), row, 0);
				dtm.setValueAt(evo.getDvo().getDname(), row, 1);
			}
		}
		else if ("입력".equals(command)) {
			System.out.println("입력 버튼 눌렸음");
		}
		else if ("수정".equals(command)) {
			System.out.println("수정 버튼 눌렀음");
		}
		else if ("삭제".equals(command)) {
			System.out.println("삭제 버튼 눌렸음");
		}
		else {
			System.exit(0);
		}
	}
}
