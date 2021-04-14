package com.design.zipcode;

import java.util.ArrayList;

public class A {
	
	/*
	 * 컬렉션 프레임워크에서 제고아는 클래스 중 하나
	 * 여기 담을 수 있는 것들은 기본적으로 오브젝트급이다
	 * 원시타입은 담을 수가 없다
	 * 
	 * 배열과 차이점
	 * 길이 가변
	 * 객체타입이면 무엇이든
	 * 끼워넣기가 가능하다
	 */

	public static void main(String[] args) {
		ArrayList<String> yesGeneric = new ArrayList<String>();
		ArrayList noGeneric = new ArrayList();

		yesGeneric.add("수박");
		yesGeneric.add("딸기");
		yesGeneric.add("키위");
		noGeneric.add("수박");
		noGeneric.add("딸기");
		noGeneric.add("키위");

//		for (String s : al) {
//			System.out.println(s);
//		}

		yesGeneric.add(1, "딸기앞?");

		for (String s : yesGeneric) {
			System.out.println(s);
		}
		System.out.println();
		for (Object o : noGeneric) {
			System.out.println(o);
		}
		
		ArrayList<ZipCodeVO> al_zVO = new ArrayList<ZipCodeVO>();
		ZipCodeVO zVO = new ZipCodeVO();
		
		zVO.setZipcode(14052);
		zVO.setAddress("경기도 안양시 동안구 달안로 124");
		al_zVO.add(zVO);
		
		zVO = new ZipCodeVO();
		zVO.setZipcode(14053);
		zVO.setAddress("경기도 안양시 동안구 달안로 125");
		al_zVO.add(zVO);
		
		zVO = new ZipCodeVO();
		zVO.setZipcode(14054);
		zVO.setAddress("경기도 안양시 동안구 달안로 126");
		al_zVO.add(zVO);
		
		for (ZipCodeVO z : al_zVO) {
			System.out.println(z);
			System.out.println(z.getAddress());
		}
	}
}
