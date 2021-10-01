package myPage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import member.DBApplication;
import member.MemberVO;

public class MypageDao {
	private String url = "jdbc:oracle:thin:@112.220.114.130:1521:xe";
	private String forName = "oracle.jdbc.driver.OracleDriver";
	private String id = "team5_20210809s";
	private String ps = "java";
	
	private static MypageDao instance;
	public static MypageDao getInstance() {
		if (instance == null) {
			instance = new MypageDao();
		}
		return instance;
	}
	
	private MypageDao() {}
	
	private JdbcTemplate template = DBApplication.getTemplate();

	public MemberVO selectInfo(MemberVO id) {
		return template.queryForObject("SELECT * FROM MEMBER WHERE ID=?"
				, new BeanPropertyRowMapper<>(MemberVO.class)
				,id.getId());
	}

	public int deleteInfo(MemberVO delete) throws ClassNotFoundException, SQLException {
		String sql = "DELETE FROM member WHERE id=?";
		
		Class.forName(forName);
		Connection connection = DriverManager.getConnection(url,id,ps);
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, delete.getId());
		int executeUpdate = statement.executeUpdate();
		statement.close();
		connection.close();
		return executeUpdate;
		
//		return template.queryForObject("DELETE FROM member WHERE id=?"
//				, new BeanPropertyRowMapper<>(MypageVO.class)
//				,delete.getId());
	}

	public int updateInfo(MemberVO change) throws SQLException, ClassNotFoundException {
		String sql = "UPDATE MEMBER SET PW = ?, ADDRESS= ?, MAIL = ?, PHONE = ? WHERE ID = ?";
		
		Class.forName(forName);
		Connection connection = DriverManager.getConnection(url,id,ps);
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, change.getPwd());
		statement.setString(2, change.getAddress());
		statement.setString(3, change.getMail());
		statement.setString(4, change.getPhone());
		statement.setString(5, change.getId());
		int executeUpdate = statement.executeUpdate();
		statement.close();
		connection.close();
		return executeUpdate;
		
		// TODO Auto-generated method stub
//		return template.queryForObject("UPDATE member m"
//				+ "SET (name, age, address, mail, phone) = (select name, age, address, mail, phone from modify_list b where m.id=b.id)"
//				+ "where m.id in (select ? from modify_list)"
//				, new BeanPropertyRowMapper<>(MypageVO.class)
//				,change.getId());
	}

	public int rechargeInfo(MemberVO recharge) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		// update member set balance = ?+? where id = ?
		String sql = "update member set balance = balance+? where id = ?";
		
		Class.forName(forName);
		Connection connection = DriverManager.getConnection(url,id,ps);
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, recharge.getRecharge());
		statement.setString(2, recharge.getId());
		int executeUpdate = statement.executeUpdate();
		statement.close();
		connection.close();
		return executeUpdate;
		
//		return template.queryForObject("UPDATE member"
//				+ "SET balance = balance+?"
//				+ "where ?"
//				, new BeanPropertyRowMapper<>(MypageVO.class)
//				,recharge.getRecharge()
//				,recharge.getId());
	}
	
	public List<MemberVO> importInfo(MemberVO info) throws ClassNotFoundException, SQLException {
		String sql = "select address, mail, phone from member where id = ?";
		
		Class.forName(forName);
		Connection connection = DriverManager.getConnection(url,id,ps);
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, info.getId());
		ResultSet resultSet = statement.executeQuery();
		List<MemberVO> list = new ArrayList<MemberVO>();
		while (resultSet.next()) {
			String address = resultSet.getString("address");
			String mail = resultSet.getString("mail");
			String phone = resultSet.getString("phone");
			list.add(new MemberVO(address, mail, phone));
		}
		statement.close();
		connection.close();
		return list;
	}
	
}
