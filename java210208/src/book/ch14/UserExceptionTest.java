package book.ch14;

public class UserExceptionTest {
	public void test(String[] a) throws UserException{
		System.out.println("test 호출");
		if(a.length <1)
			throw new UserException("형 아무것도 없어요.");
		else
			throw new UserException("최종 예선", 7000);
	}
	public static void main(String[]args) {
		UserExceptionTest uet = new UserExceptionTest();
		try {
			uet.test(args);
		}catch (UserException ue) {
			ue.printStackTrace();
		}catch (Exception e) {
			e.toString();
			e.getMessage();
			e.printStackTrace();
		}finally {
			System.out.println("finally");
		}
	}
}
