package book.ch7;

public class Array3 {

	public static void main(String[] args) {
		EmpVO[] eVOS = new EmpVO[3];		//EmpVO 클래스를 담는 3칸짜리 배열			풍선=인스턴스
		EmpVO eVO = new EmpVO();			//EmpVO 클래스 인스턴스화 및 초기화 (풍선 1)
		eVOS[0] = eVO;						//3칸짜리 배열 0번째칸에 인스턴스2 정보 저장
		eVO = new EmpVO();					//다시 초기화(주소값 바뀜, 풍선2)
		eVOS[1] = eVO;						//배열 1번째 칸에 인스턴스2 정보 저장
		eVO = new EmpVO();					//다시 초기화(주소값 바뀜, 풍선3)
		eVOS[2] = eVO;						//배열 2번째 칸에 인스턴스 3 정보 저장
		for (EmpVO eVO2 : eVOS) {			//EmpVO 클래스 타입의 변수 eVO2를 사용해서 객체배열 eVOS의 데이터를 순차적으로 출력 
			System.out.println(eVO2);
			//eVO2값은 명시적으로 초기화되지 않았으나 각 배열 데이터(여기서는 인스턴스 1, 2, 3의 주소번지)를 배열크기만큼 알아서 출력해줌
			System.out.println(eVO2.getEmpno() + eVO2.getEname() + eVO2.getSal());
		}
	}
}
