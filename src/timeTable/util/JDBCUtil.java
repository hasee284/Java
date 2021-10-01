package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCUtil {

	private JDBCUtil() {
	}

	private static JDBCUtil instance;

	public static JDBCUtil getInstance() {
		if (instance == null) {
			instance = new JDBCUtil();
		}
		return instance;
	}
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "";
	String password = "";

	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

}
