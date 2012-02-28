package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class XeroundDataAccess {

	Connection con = null;
	
	XeroundDataAccess() {
		con = getConnection();
	}
	
	public Connection getConnection() {

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection con = DriverManager
					.getConnection("jdbc:mysql://instance6731.db.xeround.com:4896/words?"
							+ "user=vaidyaa&password=principia");
			System.out.println("Connected to the database");
			return con;
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void getResults() {
		Statement dbStatement;
		try {
			dbStatement = con.createStatement();
			String queryString = "SELECT * from words.wordlist";
			ResultSet rs = dbStatement.executeQuery(queryString);
			while (rs.next()) {
				System.out.println(rs.getString(2) + " , " + rs.getString(3)
						+ " , " + rs.getString(4));
			}
			rs.close();
		} catch (SQLException e) {
			shutdown();
			e.printStackTrace();
		}

	}

	public void insert(String word, String usage, String meaning) {

		Statement dbStatement = null;
		try {
			dbStatement = con.createStatement();
			String queryString = "insert into words.wordlist values (0, '"
					+ word + "','" + meaning + "','" + usage + "')";
			int updateQuery = dbStatement.executeUpdate(queryString);
			if (updateQuery != 0) {
				System.out.println("Database table successfully updated");
			}
		} catch (SQLException e) {
			shutdown();
			e.printStackTrace();
		}

	}
	
	public void shutdown() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
