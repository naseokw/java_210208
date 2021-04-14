package di.step1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InsaMain {

	public static void main(String[] args) {

		ApplicationContext	context		= new ClassPathXmlApplicationContext("di\\step1\\insaBean.xml");
		InsaList			insalist	= (InsaList) context.getBean("insa");

		insalist.printList();

		System.out.println(insalist.getInsaBean());

		InsaList insalist_not_spring = new InsaList();

		insalist_not_spring.printList();

		((ClassPathXmlApplicationContext) context).close();
	}
}
