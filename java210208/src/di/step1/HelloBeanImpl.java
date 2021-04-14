package di.step1;

public class HelloBeanImpl implements HelloBean {
	private String msg = null;

	// setter 객체주입법(자바코드에 적용)
	// 생성자 객체주입법(xml코드 활용)
	public void setMsg(String msg) {
		this.msg = msg;
	}

	// bean이 초기화된 후 호출되는 메서드
	@Override
	public String getGreeting(String msg) {
		return "Spring " + this.msg;
	}

	public void initMethod() {
		System.out.println("initMethod() called successfully");
	}

	public void destroyMethod() {
		System.out.println("destroyMethod() called successfully");
	}
}
