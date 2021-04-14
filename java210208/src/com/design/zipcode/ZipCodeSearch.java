package com.design.zipcode;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import com.util.DBConnectionMgr;

/*
 * dispose에 대한 설명임
 * 이 Window, 하위 구성 요소 및 모든 소유 된 하위 구성 요소에서 사용하는 모든 기본 화면 리소스를
 * 해제합니다. 즉, 이러한 구성 요소에 대한 리소스가 파괴되고 사용하는 모든 메모리가 OS로 반환되며
 * 표시 할 수없는 것으로 표시됩니다.
 * Window 및 하위 구성 요소는 pack 또는 show에 대한 후속 호출로 네이티브 리소스를 다시 빌드하여
 * 다시 표시 가능하게 만들 수 있습니다. 다시 생성 된 Window 및 해당 하위 구성 요소의 상태는 Window가
 * 삭제 된 시점에서 이러한 개체의 상태와 동일합니다 (해당 작업 간의 추가 수정은 고려하지 않음).
 *
 * setVisiable에 대한 설명임.
 * 재정의 : 구성 요소의 setVisible (...)
 * 매개 변수 : b true이면 Window를 표시하고 그렇지 않으면 Window를 숨깁니다.
 * Window 및 / 또는 해당 소유자가 아직 표시 가능하지 않은 경우 둘 다 표시 가능하게됩니다.
 * 창은 보이기 전에 유효성이 검사되며 창이 이미 보이는 경우에는 창을 앞으로 가져옵니다.
 * false이면이 Window, 하위 구성 요소 및 모든 소유 자식을 숨 깁니다. Window 및 해당 하위 구성
 * 요소는 #setVisible (true)를 호출하여 다시 표시 할 수 있습니다.
 */
public class ZipCodeSearch extends JDialog implements MouseListener, ItemListener, FocusListener, ActionListener {

	// 선언부
	String				zdo			= null;
	String				sigu		= null;
	String				dong		= null;
	List<String>		list		= new Vector<>();
	Vector<String>		vec			= new Vector<>();

	Connection			con			= null;
	PreparedStatement	pstmt		= null;
	ResultSet			rs			= null;
	DBConnectionMgr		dbMgr		= null;

	JPanel				jp_north	= new JPanel();
	// insert here
	String[]			zdos		= null;
	String[]			sigus		= null;
	String[]			dongs		= null;
	String[]			totals		= { "전체" };
	JComboBox<String>	jcb_zdo		= null;
	JComboBox<String>	jcb_sigu	= null;
	JComboBox<String>	jcb_dong	= null;
	Vector<String>		vzdos		= new Vector<>();														// vzdos.size()==>0
	JTextField			jtf_search	= new JTextField("동이름을 입력하세요.");
	JButton				jbtn_search	= new JButton("조회");													// East
	String				cols[]		= { "우편번호", "주소" };
	String				data[][]	= new String[0][2];
	DefaultTableModel	dtm_zipcode	= new DefaultTableModel(data, cols);
	JTable				jtb_zipcode	= new JTable(dtm_zipcode);
	JTableHeader		jth			= jtb_zipcode.getTableHeader();
	JScrollPane			jsp_zipcode	= new JScrollPane(jtb_zipcode, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
								JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	MemberShip			memberShip	= null;
	ZipCodeDAO			zcDAO		= new ZipCodeDAO();

	// 생성자
	public ZipCodeSearch(MemberShip memberShip) {

		this.memberShip = memberShip;

		zdos = getZDOList();
		jcb_zdo = new JComboBox<>(zdos);
		jcb_sigu = new JComboBox<>(totals);
		jcb_dong = new JComboBox<>(totals);

		initDisplay();
	}

	// public ZipCodeSearch(MemberShip memberShip) {
	// this();
	// this.memberShip = memberShip;
	// }
	public String[] getZDOList() {

		String[]		zdos	= null;
		// 오라클 서버에 보낼 SELECT문 작성
		// String 자체는 원본이 바뀌지 않는 특성을 가진다.
		// StringBuilder는 단일 스레스에서 안전하고,
		// StringBuffer는 다중 스레드에서 안전하다.
		StringBuilder	sb		= new StringBuilder();

		sb.append("SELECT '전체' zdo FROM dual"
									+ " UNION ALL"
									+ " SELECT zdo FROM"
									+ " (SELECT DISTINCT(zdo) zdo FROM zipcode_t ORDER BY zdo)");

		try {
			dbMgr = DBConnectionMgr.getInstance();
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sb.toString());
			rs = pstmt.executeQuery();
			Vector<String> v = new Vector<String>();

			// List<String> v2 = new Vector<String>();
			while (rs.next()) {
				String zdo = rs.getString("zdo");
				v.add(zdo);
			}
			zdos = new String[v.size()];
			v.copyInto(zdos);
			// 리스트 타입으로 선언해서 벡터로 인스턴스화 한다고 해서 copyInto 쓸 수가 없다
			// v2.copyInto(zdos);

			dbMgr.freeConnection(con, pstmt, rs);

		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return zdos;
	}

	public String[] getSIGUList() {

		String[]		sigus	= null;
		StringBuilder	sb		= new StringBuilder();

		sb.append("SELECT '전체' sigu FROM dual"
									+ " UNION ALL"
									+ " SELECT sigu FROM"
									+ " (SELECT DISTINCT(sigu) sigu FROM zipcode_t"
									+ " WHERE zdo = ? ORDER BY sigu)");

		try {
			dbMgr = DBConnectionMgr.getInstance();
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setString(1, zdo);
			rs = pstmt.executeQuery();
			Vector<String> v = new Vector<String>();

			while (rs.next()) {
				String sigu = rs.getString("sigu");
				v.add(sigu);
			}
			sigus = new String[v.size()];
			v.copyInto(sigus);

			dbMgr.freeConnection(con, pstmt, rs);

		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return sigus;
	}

	public String[] getDONGList() {

		String[]		dongs	= null;
		StringBuilder	sb		= new StringBuilder();

		sb.append("SELECT '전체' dong FROM dual"
									+ " UNION ALL"
									+ " SELECT dong FROM"
									+ " (SELECT DISTINCT(dong) dong FROM zipcode_t"
									+ " WHERE sigu = ? ORDER BY dong)");

		try {
			dbMgr = DBConnectionMgr.getInstance();
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setString(1, sigu);
			rs = pstmt.executeQuery();
			Vector<String> v = new Vector<String>();

			while (rs.next()) {
				String dong = rs.getString("dong");
				v.add(dong);
			}
			dongs = new String[v.size()];
			v.copyInto(dongs);

			dbMgr.freeConnection(con, pstmt, rs);

		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return dongs;
	}

	public void refreshData(String zdo, String sigu, String dong) {

		System.out.println("zdo: " + zdo + ", sigu : " + sigu + ", dong: " + dong);
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT address, zipcode FROM zipcode_t WHERE 1 = 1");

		if (zdo != null && zdo.length() > 0) {
			sql.append(" AND zdo = ?");
		}

		if (sigu != null && sigu.length() > 0) {
			sql.append(" AND sigu LIKE '%'||?||'%'");
		}

		if (dong != null && dong.length() > 0) {
			sql.append(" AND dong LIKE '%'||?||'%'");
		}

		int i = 1;

		try {
			dbMgr = DBConnectionMgr.getInstance();
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());

			if (zdo != null && zdo.length() > 0) {
				pstmt.setString(i++, zdo);
			}

			if (sigu != null && sigu.length() > 0) {
				pstmt.setString(i++, sigu);
			}

			if (dong != null && dong.length() > 0) {
				pstmt.setString(i++, dong);
			}
			rs = pstmt.executeQuery();
			Vector<ZipCodeVO>	v		= new Vector<>();
			ZipCodeVO[]			zVOS	= null;
			ZipCodeVO			zVO		= null;

			while (rs.next()) {
				zVO = new ZipCodeVO();
				zVO.setAddress(rs.getString("address"));
				zVO.setZipcode(rs.getInt("zipcode"));
				v.add(zVO);
			}
			zVOS = new ZipCodeVO[v.size()];
			v.copyInto(zVOS);

			if (v.size() > 0) {

				while (dtm_zipcode.getRowCount() > 0) {
					dtm_zipcode.removeRow(0);
				}
			}

			for (int j = 0; j < v.size(); j++) {
				Vector<Object> oneRow = new Vector<>();
//				ArrayList<Object> oneRow2 = new ArrayList<Object>();
//				List<Object> oneRow3 = new ArrayList<Object>();
//				List<Object> oneRow4 = new Vector<Object>();
				oneRow.add(0, zVOS[j].getZipcode());
				oneRow.add(1, zVOS[j].getAddress());
				dtm_zipcode.addRow(oneRow);
//				dtm_zipcode.addRow(zVOS);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			dbMgr.freeConnection(con, pstmt, rs);
		}
	}

	// 화면처리부
	public void initDisplay() {

		jtb_zipcode.requestFocus();
		jtb_zipcode.addMouseListener(this);
		jbtn_search.addActionListener(this);
		jtf_search.addFocusListener(this);
		jtf_search.addActionListener(this);
		jp_north.setLayout(new FlowLayout());

		for (String s : vzdos) {
			System.out.println("s===>" + s);
		}
		/*
		 * String배열에 있는 정보를 굳이 벡터에 담아야 한다.
		 * 생성자 선택을 Vector타입으로 결정했기 때문이다.
		 * 벡터 자체는 값을 가지고 있지 않는 상태이다.
		 * 값은 1차 배열 안에 초기화 되어 있다. 이것을 벡터에 재초기화 한다.
		 * 그 후에 콤보박스를 생성하고 화면에 장착해야 리스트에서 값을 볼 수 있을 것이다.
		 */
		jcb_zdo.addItemListener(this);
		jcb_sigu.addItemListener(this);
		jcb_dong.addItemListener(this);
		jp_north.add(jcb_zdo);
		jp_north.add(jcb_sigu);
		jp_north.add(jcb_dong);
		jp_north.add(jtf_search);
		jp_north.add(jbtn_search);
		this.add("North", jp_north);
		this.add("Center", jsp_zipcode);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setTitle("우편번호 검색");
		this.setSize(600, 400);
		this.setVisible(true);
	}

	// 메인메소드
//	public static void main(String[] args) {
//
//		JFrame.setDefaultLookAndFeelDecorated(true);
//		ZipCodeSearch zcs = new ZipCodeSearch();
//		zcs.initDisplay();
//	}

	@Override
	public void focusGained(FocusEvent e) {

		System.out.println("focusGained 호출 성공");

		if (e.getSource() == jtf_search) {
			jtf_search.setText("");
		}
	}

	@Override
	public void focusLost(FocusEvent e) {

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Object obj = e.getSource();

		if (obj == jbtn_search || obj == jtf_search) {

//			String myDong = jtf_search.getText();
			refreshData(zdo, sigu, dong);
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {

		Object obj = e.getItem();

		if (obj == jcb_zdo.getSelectedItem()) {
			zdo = zdos[jcb_zdo.getSelectedIndex()];
			jcb_sigu.removeAllItems();
			sigus = getSIGUList();

			for (int i = 0; i < sigus.length; i++) {
				jcb_sigu.addItem(sigus[i]);
			}
			jcb_dong.removeAllItems();
			jcb_dong.addItem(totals[0]);
		}
		else if (obj == jcb_sigu.getSelectedItem()) {

			if ("전체".equals(obj) == false) {
				sigu = sigus[jcb_sigu.getSelectedIndex()];
				jcb_dong.removeAllItems();
				dongs = getDONGList();

				for (int j = 0; j < dongs.length; j++) {
					jcb_dong.addItem(dongs[j]);
				}
			}
			else {
				sigu = "";
			}
		}
		else if (obj == jcb_dong.getSelectedItem()) {

			if ("전체".equals(obj) == false) {
				dong = dongs[jcb_dong.getSelectedIndex()];
			}
			else {
				dong = "";
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {

		if (e.getClickCount() == 2) {
			String	zipcode	= dtm_zipcode.getValueAt(jtb_zipcode.getSelectedRow(),
										jtb_zipcode.getColumnCount() - 2).toString();
			String	address	= (String) dtm_zipcode.getValueAt(jtb_zipcode.getSelectedRow(),
										jtb_zipcode.getColumnCount() - 1);

			memberShip.jtf_zipcode.setText(zipcode);
			memberShip.jtf_address.setText(address);

			this.dispose();
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}
}