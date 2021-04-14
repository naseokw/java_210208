package com.vo;

import com.quiz0222.EmpVO;
import com.quiz0222.DeptVO;

public class EmpVOSimulation {

	public static void main(String[] args) {
		DeptVO dVO = new DeptVO();
		dVO.setDeptno(30);
		dVO.setDname("RESEARCH");
		dVO.setLoc("BUSAN");
		
		EmpVO eVO = new EmpVO(7566, "GEUNDU", "SALES", 7800, "2000-10-26", 1000, 200, 30, dVO);
		System.out.println(eVO.getDvo().getDname());
		System.out.println(dVO.getDname());
		
		dVO = new DeptVO();
		dVO.setDeptno(40);
		dVO.setDname("DEVELOPMENT");
		dVO.setLoc("JEJU");
		System.out.println(eVO.getDvo().getDname());
		System.out.println(dVO.getDname());
	}

}
