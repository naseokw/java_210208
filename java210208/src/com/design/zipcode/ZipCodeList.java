package com.design.zipcode;

import java.util.List;
import java.util.Vector;

/*
	 * 자료구조의 종류
	 * 1) List 계열
	 * 		ArrayList - 싱글스레드에 안전, 동기화 생략, 속도 비교적 빠르다
	 * 		Vector - 멀티스레드에 안전, 동기화처리, 속도 비교적 느림
	 * 			경합, 다중접속자 처리, 순서, 동기화가 필요하다면 무적권 벡터..
	 * 2) Map 계열(해시태그)
	 * 3) Set 계열(빈도가 낮음)
	 */

public class ZipCodeList {

	public static void main(String[] args) {
		Vector<ZipCodeVO> v = new Vector<>();// 다형성을 누릴 수 없다
		List<ZipCodeVO> list = new Vector<>();// 다형성을 누릴 수 있다
		ZipCodeVO zcVO = null;
		ZipCodeVO[] zcVOs = null;
		int i = 0;
		while (i < 3) {
			zcVO = new ZipCodeVO();
			zcVO.setAddress("서울시");
//			System.out.println("zcVO 주소번지 바뀐당 " + zcVO);
			v.add(zcVO);
			zcVO.setAddress("인천광역시");
			i++;
		}

		for (int x = 0; x < v.size(); x++) {
			ZipCodeVO zcVO2 = v.get(x);
			System.out.println(zcVO2);
		}
		
		zcVOs = new ZipCodeVO[v.size()];
		
		System.out.println("객체배열의 크기는 " + zcVOs.length);
		
		v.copyInto(zcVOs);
		
		for (int j = 0; j < zcVOs.length; j++) {
			System.out.println(zcVOs[j].getAddress());
		}

	}
}
