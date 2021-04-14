package book.ch5;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SalaryMgrEventHandler implements ActionListener{
	SalaryMgrView smView = null;
	SalaryMgrLogic smLogic = null;
	SalaryMgrEventHandler(SalaryMgrView smView) {
		this.smView = smView;
		smLogic = new SalaryMgrLogic();
	}
	
//	SalaryMgrEventHandler(SalaryMgrLogic sml) {
//		this.sml = sml;
//	}

	@Override
	public void actionPerformed(ActionEvent e) {
		smLogic.getEmpList(smView, e);
	}
}
