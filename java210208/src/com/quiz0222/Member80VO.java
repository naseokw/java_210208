package com.quiz0222;

public class Member80VO {
	
	private String mem_id = null;
	private String mem_pw = null;
	private boolean gender = false;
	/*
	 * 생성자는 리턴타입이 없다
	 * 클래스이름과 동일해야 함
	 * 전역변수의 초기화 담당
	 * static block에서 하는 일을 맡겨도 됨
	 * 만일 소켓통신 통해서 서버사이드과 클라이언트 사이트 구현(구축)
	 * 
	 * 메서드 오버로딩
	 * 전제조건 - 모두 같은 이름이다. 다른이름이라면 해당 무
	 * 접근제한자가 있고 없고 영향 없다
	 * 리턴타입이 있고 없고 영향 없다 - 생성자는 해당없음
	 * 
	 */
	
	public Member80VO() {		//default constructor
		
	}
	public Member80VO(String mem_id) {		//constructor(parameter 1)
		this.mem_id = mem_id;
	}
	public Member80VO(String mem_id, String mem_pw) {//constructor(parameter 2)
		this.mem_id = mem_id;
		this.mem_pw = mem_pw;
	}
	public Member80VO(String mem_id, String mem_pw, Boolean gender) {//constructor(parameter 3)
		this.mem_id = mem_id;
		this.mem_pw = mem_pw;
		this.gender = gender;
	}
	
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getMem_pw() {
		return mem_pw;
	}
	public void setMem_pw(String mem_pw) {
		this.mem_pw = mem_pw;
	}
	public boolean isGender() {
		return gender;
	}//boolean get은 is로 쓴다
//	public boolean getGender() {
//		return gender;
//	}
	public void setGender(boolean gender) {
		this.gender = gender;
	}  

}
