package member;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;


public class MemberDao {
	private static MemberDao instance;
	public static MemberDao getInstance() {
		if (instance == null) {
			instance = new MemberDao();
		}
		return instance;
	}
	private MemberDao() {}
	
	private JdbcTemplate template = DBApplication.getTemplate();
	
	public MemberVO login(MemberVO vo) {
		return template.queryForObject("SELECT * FROM MEMBER WHERE ID=? AND PW=?"
				, new BeanPropertyRowMapper<>(MemberVO.class)
				,vo.getId()
				,vo.getPwd());
	}
	public int inputNoticeMenu(MemberVO vo) {
		return vo.getInputNoticeMenu();
	}
}
