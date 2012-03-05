package execution;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import database.ExcelParserPOI;

public class TestDAOClass {
	public static void main(String[] args) {
	        import java.sql.Connection;
	        import java.sql.DriverManager;
	        import java.sql.SQLException;

	        Connection con = null;

	        try {
	          con = DriverManager.getConnection(
	            "jdbc:mysql://instance123.db.xeround.com:4567/wordlist?" +
	            "user=vaidyaa&password=principia");
	          stat = con.createStatement();

	        } catch (SQLException ex) {
	          ex.printStackTrace();
	        }
	}
}
