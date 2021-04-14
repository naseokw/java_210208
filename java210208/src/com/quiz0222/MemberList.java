package com.quiz0222;

import com.google.gson.Gson;

public class MemberList {

	public static void main(String[] args) {
		Member80VO mvo = new Member80VO();
		mvo.setMem_id("apple");
		mvo.setMem_pw("abcd1234");
		mvo.setGender(true);
//		mvo = new Member80VO("tomato", "123", true);
		Gson gson = new Gson();
		String temp = gson.toJson(mvo);
		System.out.println(temp);
		
	}

}
