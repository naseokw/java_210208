package book.ch5;

import java.awt.event.ActionEvent;
import java.util.Vector;

import com.quiz0222.DeptVO;
import com.quiz0222.EmpVO;

public class SalaryMgrLogic {
	
	Vector oneRow = new Vector();
	
	public void getEmpList(SalaryMgrView smView, ActionEvent e) {
		Object obj = e.getSource();
		String command = e.getActionCommand();
		if ("조회".equals(command)) {
			System.out.println("조회 버튼 눌렸음");
			EmpVO evo = new EmpVO();
			evo.setEname("유성열");
			DeptVO dvo = new DeptVO();
			dvo.setDname("KOSMO80");
			evo.setDvo(dvo);
			
			oneRow.addElement(evo.getEname());
			oneRow.addElement(evo.getDvo().getDname());
			smView.dtm.addRow(oneRow);
			//view에서 this참조하고 생성자로 인스턴스 받아와도 됨.
			
			for (int row = 0; row < 1; row++) {
				smView.dtm.setValueAt(evo.getEname(), row, 0);
				smView.dtm.setValueAt(evo.getDvo().getDname(), row, 1);
			}
			System.out.println(oneRow.size());
		}
		else if ("입력".equals(command)) {
			System.out.println("입력 버튼 눌렸음");
		}
		else if ("수정".equals(command)) {
			System.out.println("수정 버튼 눌렀음");
		}
		
		else if ("삭제".equals(command)) {
			System.out.println("삭제 버튼 눌렸음");
			System.out.println(oneRow.size());
			smView.dtm.removeRow(0);
		}
		else {
			System.exit(0);
		}
	}/////////////////end of method getEmpList
}/////////////////////end of class SalaryMgrLogic
