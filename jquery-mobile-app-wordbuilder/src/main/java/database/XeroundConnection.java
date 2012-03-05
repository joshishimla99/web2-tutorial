package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class XeroundConnection {

        public static void main(String[] args) {
                Connection con = null;

                try {
                        con = DriverManager
                                        .getConnection("jdbc:mysql://instance6731.db.xeround.com:4896/words?"
                                                        + "user=vaidyaa&password=principia");
                        Statement stat = con.createStatement();
                        ResultSet rs = stat.executeQuery("select * from wordlist where alphabet = '"+"a"+"'");
                        while(rs != null && rs.next()) {
                                System.out.println(rs.getString(1));
                        }
                        // rest of the code . . .
                } catch (SQLException ex) {
                        ex.printStackTrace();
                }

        }
}
