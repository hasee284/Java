package packageDAO;

import java.sql.DriverManager;
import java.sql.SQLException;

import oracle.jdbc.driver.OracleDriver;
import packageVO.MemberVO;

public class MemberDAO {
	/**
	 * 회원 가입
	 */
	public int insertMember(MemberVO vo) {
		try {
			DriverManager.registerDriver(new OracleDriver());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
