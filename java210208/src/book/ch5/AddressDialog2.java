package book.ch5;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import com.quiz0222.DeptVO;
import com.util.DBConnectionMgr;

public class AddressDialog2 extends JDialog implements ActionListener{
	
	static DBConnectionMgr dbMgr = null;
	Connection con = null;
	PreparedStatement ipstmt = null;
	PreparedStatement upstmt = null;
//	ResultSet rs = null;
	
	/*
	 * INSERT INTO dept(deptno, dname, loc)
		VALUES(51, '자택경비 둘', '집 둘')
	 * 
	 * 
	 */
	StringBuilder sql_ins = new StringBuilder();
	//스트링빌더 좋음, 스트링은 원본 안바껴서 +할때마다 객체 추가된다 = 메모리 질질샌다
//	StringBuffer sql_ins2 = new StringBuffer();	//멀티스레드에 안전 속도 비교적 느림
	StringBuilder sql_upd = new StringBuilder();//싱글스레드에 안전 속도 비교적 빠름
	JPanel 		jp_center 		= new JPanel();
	JPanel 		jp_south 		= new JPanel();
	JScrollPane jsp 			= null;
	//화면을 처리할 때 해당 옵션을 두 가지로 설정할 수 있음 - getter/setter 형식으로 해보기
	JLabel 		jlb_deptno 		= new JLabel("부서번호");
	JTextField 	jtf_deptno	 	= new JTextField();
	JLabel 		jlb_dname 		= new JLabel("부서이름");
	JTextField 	jtf_dname 		= new JTextField();
	JLabel 		jlb_loc 		= new JLabel("지역");
	JTextField 	jtf_loc 		= new JTextField();
	JButton 	jb_account 		= new JButton("처리");
	JButton 	jb_close 		= new JButton("닫기");
	DeptVO 		dVO 			= null;
	static AddressBook2 aBook 	= null;
	static AddressDialog2 aDia 	= null;
	
	
	/*
	 * @param str - 사용자가 선택한 요청에 대한 제목을 정함
	 * @param aBook - 부모창에서 화면처리에 대한 원본 주소번지가 필요
	 * 입력일 때 새 창을 열어서 입력을 받음
	 * 수정일 때는 오라클을 경유해서 그 결과를 화면에 출력해놓고 수정할 정보만 입력받음
	 * 상세조회일 때 오라클 경유하여 한 건만 출력해야 함 read only
	 * 수정과 입력일 때는 writable
	 * 수정과 상세조회 하나로 묶고 입력을 묶어서 처리
	 * 오라클을 경유했을 때 VO 유지해야 함
	 * 그 값을 가진 주소번지를 부모창에서 받아 자식창의 이벤트처리 메서드인
	 * actionPerformed에서 재사용해야 하므로 전역변수로 선언한 다음 지역변수와 초기화하여 사용하도록 한다
	 */
	public void set(String title, DeptVO dVO, AddressBook2 aBook, boolean isFlag) {
		this.aBook = aBook;		//전역변수
		this.dVO = dVO;			//전역변수
		this.setTitle(title);	//전역변수일 필요 x
		//입력모드 | 수정모드 | 상세조회모드
		this.setEnabled(isFlag);
		this.setValue(this.dVO);
	}
	/*
	 * set메서드를 통해서 넘어온 4번째 값에 따라서 화면을 처리하는
	 * 컴포넌트 클래스의 수정 모드에 대한 설정을 바꾸어준다
	 * 만일 true이면 setEnabled(true)로 설정하고
	 * 만일 false가 넘어오면 수정할 수 없도록 할 거임
	 */
	
	private void setValue(DeptVO dVO) {
		//입력을 위한 다이얼로그창 설정, 모든 값을 널로 세팅한다
		if (dVO == null) {
			setJtf_deptno("");
			setJtf_dname("");
			setJtf_loc("");
		}
		else {
			setJtf_deptno(String.valueOf(dVO.getDeptno()));
			setJtf_dname(dVO.getDname());
			setJtf_loc(dVO.getLoc());
		}
		
		//상세조회, 수정 시 오라클에서 조회된 값으로 초기화해야 함 
	}
	
	public void setEnabled(boolean isFlag) {
		jtf_deptno.setEditable(isFlag);
		jtf_dname.setEditable(isFlag);
		jtf_loc.setEditable(isFlag);
	}
	///////////////////////[화면처리 get set]/////////////////////////
	
	public String getJtf_deptno() {
		return jtf_deptno.getText();
	}
	
	public void setJtf_deptno(String deptno) {
		jtf_deptno.setText(deptno);
	}
	
	public String getJtf_dname() {
		return jtf_dname.getText();
	}
	
	public void setJtf_dname(String dname) {
		jtf_dname.setText(dname);
	}
	
	public String getJtf_loc() {
		return jtf_loc.getText();
	}
	
	public void setJtf_loc(String loc) {
		jtf_loc.setText(loc);
	}
	///////////////////////[화면처리 get set]/////////////////////////
	
//	public AddressDialog2() {
//		try {
//			dbMgr = DBConnectionMgr.getInstance();
//			con = dbMgr.getConnection();
//			con.setAutoCommit(false);
//		} catch (Exception e) {
//			System.out.println(e.toString());
//		}
//		initDisplay();
//	}
	private AddressDialog2() {
		try {
			dbMgr = DBConnectionMgr.getInstance();
			con = dbMgr.getConnection();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		initDisplay();
	}
	
	public static AddressDialog2 getDiaLogInstance() {
		if (aDia == null) {
			aDia = new AddressDialog2();
		}
		return aDia;
	}
	
	public void initDisplay() {
		this.setSize(400, 500);
		this.setVisible(false);
		
		jp_center.setLayout(null);
		jlb_deptno.setBounds(20, 20, 100, 20);
		jtf_deptno.setBounds(130, 20, 100, 20);
		jp_center.add(jlb_deptno);
		jp_center.add(jtf_deptno);
		jlb_dname.setBounds(20, 45, 100, 20);
		jtf_dname.setBounds(130, 45, 100, 20);
		jp_center.add(jlb_dname);
		jp_center.add(jtf_dname);
		jlb_loc.setBounds(20, 70, 100, 20);
		jtf_loc.setBounds(130, 70, 100, 20);
		jp_center.add(jlb_loc);
		jp_center.add(jtf_loc);
		
		jsp = new JScrollPane(jp_center);
		
		jp_south.add(jb_account);
		jp_south.add(jb_close);
		jb_account.addActionListener(this);
		jb_close.addActionListener(this);
		this.add("Center", jsp);
		this.add("South", jp_south);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String command = e.getActionCommand();
		con = aBook.reConnect();
		
		
		if ("처리".equals(command)) {
			ipstmt = null;
			if (dVO == null) {			//입력일 때
				DeptVO pdVO = new DeptVO();
				
				//Dialog에서 사용자가 텍스트필드에 입력한 값 전달 
				pdVO.setDeptno(Integer.parseInt(getJtf_deptno()));//NumberFormatException 가능성 존재
				pdVO.setDname(getJtf_dname());
				pdVO.setLoc(getJtf_loc());
				
				sql_ins.append("INSERT INTO dept(deptno, dname, loc)"
						+ " VALUES(?, ?, ?)");
				try {
					ipstmt = con.prepareStatement(sql_ins.toString());
					int i = 0;
					ipstmt.setInt(++i, pdVO.getDeptno());
					ipstmt.setString(++i, pdVO.getDname());
					ipstmt.setString(++i, pdVO.getLoc());
					int iResult = ipstmt.executeUpdate();
					sql_ins.setLength(0);
					
					if(iResult == 1) {
						JOptionPane.showMessageDialog(aBook.jf, "등록하였습니다.");
					}
					
					dbMgr.freeConnection(con, ipstmt);
					
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(aBook.jf, "Exception : " + e2.toString());
					e2.printStackTrace();
				}
			} else {					//수정일 때
				DeptVO pdVO = new DeptVO();
				pdVO.setDeptno(Integer.parseInt(getJtf_deptno()));
				pdVO.setDname(getJtf_dname());
				pdVO.setLoc(getJtf_loc());
				sql_upd.append("UPDATE dept SET loc = ? WHERE deptno = ?");
				
				try {
					upstmt = con.prepareStatement(sql_upd.toString());
					
					int i = 0;
					upstmt.setString(++i, pdVO.getLoc());
					upstmt.setInt(++i, pdVO.getDeptno());
					int uResult = upstmt.executeUpdate();
					sql_upd.setLength(0);
					
					if(uResult == 1) {
						JOptionPane.showMessageDialog(aBook.jf, "수정하였습니다.");
					}
					dbMgr.freeConnection(con, upstmt);
					
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(aBook.jf, "Exception : " + e2.toString());
					e2.printStackTrace();
				}
			}//////////////////////////////처리 버튼 액션
			aBook.refresh();
			this.dispose();
		}
		
		if ("닫기".equals(command)) {
			this.dispose();
		}
		//처리버튼을 눌렀을 때
		//입력을 처리, 수정을 처리,
		//목적지가 다시 부모창의 목록페이지로 돌아가서 새로고침 일어남
		//부모창의 주소번지가 있어야 새로고침 처리하는 메서드 호출 가능
		//닫기 버튼을 눌렀을 때
		
		
	}
	
//	public static void main(String[] args) {
//		AddressDialog2 aDia = new AddressDialog2();
//		aDia.set("상세", aDia.dVO, aBook, false);
//		aDia.initDisplay();
////		aDia.setTitle("이이잉");
//		aDia.setVisible(true);
//	}
}
