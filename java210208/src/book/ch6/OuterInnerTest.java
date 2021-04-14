package book.ch6;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.xml.XmlConfigurationFactory;

class Outer {
	Logger	logger	= LogManager.getLogger(Outer.class);
	int		i		= 5;

	class Inner {
		int j = 10;

		public void go() {
			logger.info("go() called successfully.");
		}
	}

	public void print() {
		logger.info("print() called successfully.");
	}
}

public class OuterInnerTest {
	Logger logger = LogManager.getLogger(OuterInnerTest.class);

	public void methodA() {
		logger.info("methodA() called successfully.");
	}

	public static void main(String[] args) {
		System.setProperty(XmlConfigurationFactory.CONFIGURATION_FILE_PROPERTY, "log4j.xml");
		OuterInnerTest oi = new OuterInnerTest();
		oi.methodA();
		Outer outer = new Outer();
		outer.print();
		Outer.Inner inner = outer.new Inner();
		inner.go();
	}
}