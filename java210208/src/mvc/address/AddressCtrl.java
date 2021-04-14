package mvc.address;

import java.util.List;
import java.util.Map;

public class AddressCtrl {

	private AddressVO		returnVO	= new AddressVO();

	// 아래와 비교되는 값들은 모두 AddressBook에서 받아오거나 ModifyDialog에서 받아와야 한다.
	// ModifyDialog에서는 입력, 수정만 처리한다.
	// 입력일 때는 INSERT INTO [table](column1, column2, ...) VALUES (?, ?, ...)
	// 수정일 때는 UPDATE [table] SET address = '서울시 마포구 공덕동', ... WHERE ano = 5;
	// 삭제는 AddressBook의 JTable에서 직접 처리한다.
	// DELETE FROM [table] WHERE ano = 5;
	// command = delete;
	// ano = 5;
	private static String	_DEL		= "delete";
	private static String	_INS		= "insert";
	private static String	_MOD		= "update";
	private static String	_SEL		= "select";
	private static String	_ALL		= "selectall";

	public AddressCtrl() {

	}

	public AddressVO send(AddressVO pvo) throws Exception {
		String command = pvo.getCommand();

		if (_DEL.equals(command)) {
			System.out.println("_DEL 호출 성공");
			DeleteEntity del = new DeleteEntity();
			del.delete(pvo);
		}
		else if (_INS.equals(command)) {
			System.out.println("_INS 호출 성공");
			RegisterEntity regi = new RegisterEntity();
			regi.insert(pvo);
		}
		else if (_MOD.equals(command)) {
			System.out.println("_MOD 호출 성공");
			ModifyEntity modi = new ModifyEntity();
			modi.update(pvo);
		}
		else if (_SEL.equals(command)) {
			System.out.println("_SEL 호출 성공");
			RetrieveEntity ret = new RetrieveEntity();
			ret.select(pvo);
		}
		return returnVO;
	}

	public AddressVO[] send() throws Exception {
		AddressVO[] returnVOs = null;
		System.out.println("send() 호출 성공 - return type : AddressVO[]");
		return returnVOs;
	}

	public List<AddressVO> sendAll() {
		List<AddressVO>	selectAll	= null;
		RetrieveEntity	ret			= new RetrieveEntity();
		AddressVO		pVO			= new AddressVO();
		pVO.setCommand("selectAll");
		selectAll = ret.selectList(pVO);
		System.out.println("sendAll() 호출 성공 - return type : List<AddressVO>");
		return selectAll;
	}

	public List<Map<String, Object>> sendAllMap() throws Exception {
		List<Map<String, Object>>	selectAll	= null;
		RetrieveEntity				ret			= new RetrieveEntity();
//		selectAll = ret.selectList();
		System.out.println("sendAllMap() 호출 성공 - return type : List<Map<String, Object>>");
		return selectAll;
	}
}
