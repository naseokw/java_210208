package book.ch12;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.quiz0222.DeptVO;

public class DeptList extends JFrame implements ActionListener {

	String[]			cols	= { "부서번호", "부서명", "지역" };

	// 데이터셋 선언
	DefaultTableModel	dtm		= null;

	JTable				jt		= null;
	JScrollPane			jsp		= null;
	JButton				button	= new JButton("SEARCH");

	public void tableCreate() {
		dtm = new DefaultTableModel(new Object[3][3], cols);
		jt = new JTable(dtm);
		jsp = new JScrollPane(jt);
		this.add("Center", jsp);
	}

	public DeptList() {
		// 인스턴스화 될 때 화면이 즉시 그려지도록
		initDisplay();
	}

	// 데이터 수집하기 1
	public List<Map<String, Object>> getDeptList1() {
		System.out.println("getDeptList1() called successfully");
		List<Map<String, Object>>	deptlist	= new ArrayList<Map<String, Object>>();
		Map<String, Object>			map			= new HashMap<String, Object>();
		map.put("deptno", 10);
		map.put("dname", "인사부");
		map.put("loc", "서울");
		deptlist.add(map);
		map = new HashMap<String, Object>();
		map.put("deptno", 20);
		map.put("dname", "총무부");
		map.put("loc", "서울");
		deptlist.add(map);
		map = new HashMap<String, Object>();
		map.put("deptno", 30);
		map.put("dname", "개발부");
		map.put("loc", "제주");
		deptlist.add(map);
		return deptlist;
	}

	// 데이터 수집하기 2
	public List<DeptVO> getDeptList2() {
		System.out.println("getDeptList2() called successfully");
		return null;
	}

	public void initDisplay() {

		tableCreate();
		button.setContentAreaFilled(false);
		button.addActionListener(this);
		this.add("North", button);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Department List");
		this.setSize(400, 300);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// dtm, jt 접근해야 할 수도 있으므로 멤버변수 선언
		if (e.getSource() == button) {
			List<Map<String, Object>>		deptlist	= getDeptList1();
			Iterator<Map<String, Object>>	iterator	= deptlist.iterator();
			Object[]						keys		= null;

			while (iterator.hasNext()) {
				Map<String, Object> data = iterator.next();
				keys = data.keySet().toArray();
				Vector<Object> oneRow = new Vector<>();
				oneRow.add(data.get(keys[0]));
				oneRow.add(data.get(keys[1]));
				oneRow.add(data.get(keys[2]));
				dtm.addRow(oneRow);
			}
		}
	}

	public static void main(String[] args) {
		new DeptList();
	}
}
