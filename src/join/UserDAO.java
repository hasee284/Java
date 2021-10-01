package join;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import member.MemberVO;
import oracle.jdbc.driver.OracleDriver;

public class UserDAO {
	private String url = "jdbc:oracle:thin:@112.220.114.130";
	private String id = "team5_20210809s";
	private String pw = "java";
	
	private static UserDAO instance;
	public static UserDAO getInstance() {
		if (instance == null) {
			instance = new UserDAO();
		}
		return instance;
	}
	private UserDAO() {}
	
	public int insertMember(MemberVO vo) throws Exception {
		String sql = "INSERT INTO MEMBER (ID) VALUES (?)";
		DriverManager.registerDriver(new OracleDriver());
		Connection connection = DriverManager.getConnection(url,id,pw);
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, vo.getId());
		int executeUpdate = statement.executeUpdate();
		statement.close();
		connection.close();
		return executeUpdate;
	}
	
	public int updateMember(MemberVO vo) throws Exception {
		String sql = "UPDATE MEMBER SET NAME = ?, PW = ?, AGE = ?, ADDRESS = ?, MAIL = ?, PHONE = ?, BALANCE = ? WHERE ID = ?";
		DriverManager.registerDriver(new OracleDriver());
		Connection connection = DriverManager.getConnection(url,id,pw);
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, vo.getName());
		statement.setString(2, vo.getPwd());
		statement.setInt(3, vo.getAge());
		statement.setString(4, vo.getAddress());
		statement.setString(5, vo.getMail());
		statement.setString(6, vo.getPhone());
		statement.setInt(7, vo.getBalance());
		statement.setString(8, vo.getId());
		int executeUpdate = statement.executeUpdate();
		statement.close();
		connection.close();
		return executeUpdate;
	}
	
	
}