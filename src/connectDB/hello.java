package connectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class hello {
	private static Connection con = null;

	public static void main(String[] args) throws SQLException {
		String url = "jdbc:sqlserver://localhost:1433;databasename = QLBangDia";
		String user  = "sa";
		String password = "minh0709";
		con  = DriverManager.getConnection(url,user,password);
		System.out.println(con);
	}

}
