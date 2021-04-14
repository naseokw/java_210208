package book.ch12;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ListExam1 {

	public void methodA(List<String> list) {
		System.out.println("methodA called");
	}

	public void methodB(List list) {

	}

	public void methodA(Collection<String> list) {
		System.out.println("methodA(Collection) called");
	}

	public void methodA(ArrayList<String> list) {
		System.out.println("methodA(ArrayList) called");
	}

	public static void main(String[] args) {
		ListExam1			le1	= new ListExam1();
		ArrayList<String>	al	= new ArrayList<String>();
		List<String>		l	= new ArrayList<String>();
		Collection<String>	c	= new ArrayList<String>();
		System.out.println(al.size());
		al.add("딸기");
		System.out.println(al.size());

		// 가장 가까운 계층의 타입으로부터 메서드를 호출한다
		le1.methodA(l);
		le1.methodA(al);
		le1.methodA(c);
	}
}
