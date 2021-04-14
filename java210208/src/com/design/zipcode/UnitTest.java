package com.design.zipcode;

import java.util.ArrayList;

public class UnitTest {

	public static void main(String[] args) {
		ZipCodeDAO				zcDAO		= new ZipCodeDAO();
		ArrayList<ZipCodeVO>	zipCodeList	= null;
		zipCodeList = zcDAO.getZipCodeList("가산동");
		zipCodeList = zcDAO.getZipCodeList("당산동");
		zipCodeList = zcDAO.getZipCodeList("개봉동");

		System.out.println(zipCodeList);
	}

}
