package execution;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import database.ExcelParserPOI;

public class TestDAOClass {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("application-servlet.xml", TestDAOClass.class);
		ExcelParserPOI excelParserPOI = (ExcelParserPOI) ctx.getBean("excelParserPOI");
        excelParserPOI.populateDatabase();
	}
}
