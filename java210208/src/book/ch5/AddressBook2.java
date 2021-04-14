package book.ch5;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.quiz0222.DeptVO;
import com.util.DBConnectionMgr;

import network.step1.TimeClient;
import network.step1.TimeServer;

public class AddressBook2 implements ActionListener {
	//선언부
	JFrame 				jf 			= null;
	JLabel jlb_time = new JLabel();
	Thread th = new TimeClient(jlb_time);
	JMenuBar 			jmb 		= new JMenuBar();
	JMenu 				jm_file 	= new JMenu("FILE (F)");
	JMenu 				jm_oracle 	= new JMenu("DB 연동");
	JMenuItem 			jmi_selAll 	= new JMenuItem("전체조회");
	JMenuItem 			jmi_sel 	= new JMenuItem("상세조회");
	JMenuItem 			jmi_ins 	= new JMenuItem("입력");
	JMenuItem 			jmi_upd 	= new JMenuItem("수정");
	JMenuItem 			jmi_del 	= new JMenuItem("삭제");
	JMenuItem 			jmi_exit 	= new JMenuItem("종료");
	JMenuItem 			jmi_dbTest 	= new JMenuItem("오라클 연결");
	static AddressDialog2 		aDia 		= null;
//	AddressDialog2 		aDia 		= null;
	static AddressBook2 aBook 		= null;
	DeptVO 				dVO 		= null;
	StringBuilder sql_del = new StringBuilder();
	
	String[] cols = {"부서번호", "부서명", "지역"};
	String[][] data = new String[0][3];
	//데이터셋을 담을 수 있는 클래스 생성하기
	//첫번째 파라미터 데이터영역, 두번째 컬럼 정보 초기화
	DefaultTableModel dtm_dept = new DefaultTableModel(data, cols);
	JTable jtb_dept = new JTable(dtm_dept);
	JScrollPane jsp_dept = new JScrollPane(jtb_dept);
	
	//생성자
	public AddressBook2() {
//		initDisplay();
	}
	
	//주소 목록 조회 - 새로고침 처리
	public Connection reConnect() {
		DBConnectionMgr dbMgr = DBConnectionMgr.getInstance();
		Connection con = dbMgr.getConnection();
		return con;
	}
	
	public void refresh() {
		DBConnectionMgr dbMgr = DBConnectionMgr.getInstance();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		////////////////////////////[조회결과 처리]////////////////////////////////
//		DeptVO[] dVOS = null;
		String sql = "SELECT * FROM dept";
		
		try {
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
//			DeptVO dVO = null;
			Vector<DeptVO> vecDVO = new Vector<DeptVO>();
			
			while(rs.next()) {
				dVO = new DeptVO();
				dVO.setDeptno(rs.getInt("DEPTNO"));
				dVO.setDname(rs.getString("DNAME"));
				dVO.setLoc(rs.getString("LOC"));
				vecDVO.add(dVO);
			}
//			dVOS = new DeptVO[vecDVO.size()];
//			vecDVO.copyInto(dVOS);
			
			while(dtm_dept.getRowCount() > 0) {
				dtm_dept.removeRow(0);
			}//////////////////////////이미 출력된 레코드 클리어
			
			for (int i = 0; i < vecDVO.size(); i++) {
				Vector<Object> oneRow = new Vector<Object>();
				oneRow.add(vecDVO.get(i).getDeptno());
				oneRow.add(vecDVO.get(i).getDname());
				oneRow.add(vecDVO.get(i).getLoc());
				dtm_dept.addRow(oneRow);
				
//			for (int i = 0; i < dVOS.length; i++) {
//				Vector oneRow = new Vector();
//				oneRow.add(dVOS[i].getDeptno());
//				oneRow.add(dVOS[i].getDname());
//				oneRow.add(dVOS[i].getLoc());
//				dtm_dept.addRow(oneRow);
				
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
			}
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		}
	}
	
	//화면처리부
	public void initDisplay() {
		jf = new JFrame();
		jmb.add(jm_file);
		jmb.add(jm_oracle);
		jm_file.setMnemonic('F');
		jm_file.add(jmi_selAll);
		jm_file.add(jmi_sel);
		jm_file.add(jmi_ins);
		jm_file.add(jmi_upd);
		jm_file.add(jmi_del);
		jm_file.add(jmi_exit);
		jm_oracle.add(jmi_dbTest);
		jf.setJMenuBar(jmb);
		jf.add(jsp_dept);
		jlb_time.setHorizontalAlignment(JLabel.CENTER);
		jf.add("South", jlb_time);
		jmi_sel.addActionListener(this);
		jmi_ins.addActionListener(this);
		jmi_upd.addActionListener(this);
		jmi_del.addActionListener(this);
		jmi_dbTest.addActionListener(this);
		jmi_exit.addActionListener(this);
		jmi_selAll.addActionListener(this);
		th.start();
		jf.setTitle("주소록 ver1.0");
		jf.setSize(500, 400);
		jf.setVisible(true);
	}
	
	public static void main(String[] args) {
		aBook = new AddressBook2();
		aBook.initDisplay();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object obj = e.getSource();
		aDia = AddressDialog2.getDiaLogInstance();
		
		if (obj == jmi_sel) {		//상세조회 메뉴
			int[] index = jtb_dept.getSelectedRows();
			
			if (index.length == 0) {
				JOptionPane.showMessageDialog(jf, "레코드를 선택해주세요."
												, "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			else if (index.length > 1) {
				JOptionPane.showMessageDialog(jf, "레코드를 하나만 선택해주세요."
												, "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			else {
				Integer deptno = Integer.parseInt(dtm_dept.getValueAt(index[0], 0).toString());
				
				DBConnectionMgr dbMgr = DBConnectionMgr.getInstance();
				Connection con = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				String sql = "SELECT deptno, dname, loc FROM dept"
							+ " WHERE deptno = ?";
				try {
					con = dbMgr.getConnection();
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1, deptno);
					rs = pstmt.executeQuery();
					
					if (rs.next()) {
						dVO = new DeptVO();
						dVO.setDeptno(rs.getInt("DEPTNO"));
						dVO.setDname(rs.getString("DNAME"));
						dVO.setLoc(rs.getString("LOC"));
					}
					else {
						dVO = new DeptVO();
					}
					aDia.set("상세조회", dVO, aBook, false);
					aDia.setTitle("상세조회");
					aDia.setVisible(true);
				} catch (SQLException se){
					System.out.println(se.getMessage());
				}////////////////////end of try-catch
				
			}///////////////////////end of inner if-else if-else
		}
		
		else if (obj == jmi_selAll) {		//전체조회 메뉴
			refresh();
		}
		
		else if (obj == jmi_ins) {		//입력 메뉴
			
			/*
			 * @param1 제목 바꿔주기, 2는 조회된 결과 dialog에서 재사용해야할 경우 필요
			 * 3은 dialog에서 입력이 성공하거나 수정 성공하면 부모창 새로고침해야한다고 담당자 요청
			 * 4는 dialog 화면에서 사용자로부터 입력받는 JTextField들에 대한 상태값 반영  
			 */
			aDia.set("입력", null, aBook, true);
			aDia.setTitle("입력");
			aDia.setVisible(true);
		}
		else if (obj == jmi_upd) {		//수정 메뉴
			
			
			int[] index = jtb_dept.getSelectedRows();
			
			if (index.length == 0) {
				JOptionPane.showMessageDialog(jf, "수정할 레코드를 선택해주세요."
												, "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			else if (index.length > 1) {
				JOptionPane.showMessageDialog(jf, "수정할 레코드를 하나만 선택해주세요."
												, "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			else {
				Integer deptno = Integer.parseInt(dtm_dept.getValueAt(index[0], 0).toString());
				
				DBConnectionMgr dbMgr = DBConnectionMgr.getInstance();
				Connection con = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				String sql = "SELECT deptno, dname, loc FROM dept"
							+ " WHERE deptno = ?";
				try {
					con = dbMgr.getConnection();
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1, deptno);
					rs = pstmt.executeQuery();
					
					if (rs.next()) {
						dVO = new DeptVO();
						dVO.setDeptno(rs.getInt("DEPTNO"));
						dVO.setDname(rs.getString("DNAME"));
						dVO.setLoc(rs.getString("LOC"));
					}
					else {
						dVO = new DeptVO();
					}
					aDia.setTitle("수정");
					aDia.setVisible(true);
					aDia.set("수정", dVO, aBook, true);
				} catch (SQLException se){
					System.out.println(se.getMessage());
				}////////////////////end of try-catch
				
			
			}///////////////////////end of inner if-else if-else
		}
		else if (obj == jmi_exit) {		//종료 메뉴
			System.exit(0);
		}
		else if (obj == jmi_dbTest) {		//오라클 연결 메뉴
			DBConnectionMgr dbMgr = DBConnectionMgr.getInstance();
			Connection con = dbMgr.getConnection();
			if (con != null) {
				JOptionPane.showMessageDialog(jf, "서버 연결 성공");
			}
			else
				JOptionPane.showMessageDialog(jf, "서버 연결 실패");
		}
		else {
			int[] index = jtb_dept.getSelectedRows();
			Vector<Integer> deptVec = new Vector<Integer>();
			
			for (int i = 0; i < index.length; i++) {
				Integer deptno = Integer.parseInt(dtm_dept.getValueAt(index[i], 0).toString());
				deptVec.add(deptno);
			}
			
			DBConnectionMgr dbMgr = DBConnectionMgr.getInstance();
			Connection con = null;
			PreparedStatement delpstmt = null;
			sql_del.append("DELETE FROM dept WHERE deptno IN (");
			for (int j = 0; j < deptVec.size(); j++) {
				sql_del.append(deptVec.get(j));
				if (j < deptVec.size() - 1)
					sql_del.append(", ");
			}
			sql_del.append(")");
			
			try {
				con = dbMgr.getConnection();
				delpstmt = con.prepareStatement(sql_del.toString());
				int delResult = delpstmt.executeUpdate();
				sql_del.setLength(0);
				
				if(delResult == 1) {
					JOptionPane.showMessageDialog(aBook.jf, "삭제되었습니다.");
				}
				dbMgr.freeConnection(con, delpstmt);
				
			} catch (SQLException se){
				System.out.println(se.getMessage());
			}////////////////////end of try-catch
		}
	}////////////////////end of actionPerformed
}
