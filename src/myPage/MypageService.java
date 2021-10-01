package myPage;

import java.sql.SQLException;
import java.util.List;

import member.MemberVO;

public class MypageService {
	private MypageDao dao = MypageDao.getInstance();	
	private static MypageService instance;
	public static MypageService getInstance() {
		if (instance == null) {
			instance = new MypageService();
		}
		return instance;
	}
	
	private MypageService() {}
	
	public MemberVO selectInfo(MemberVO id) {
		return dao.selectInfo(id);
	}

	public int deleteInfo(MemberVO delete) throws ClassNotFoundException, SQLException {
		return dao.deleteInfo(delete);
	}

	public int updateInfo(MemberVO change) throws ClassNotFoundException, SQLException {
		return dao.updateInfo(change);
	}

	public int rechargeInfo(MemberVO recharge) throws ClassNotFoundException, SQLException {
		return dao.rechargeInfo(recharge);
	}
	
	public List<MemberVO> importInfo(MemberVO info) throws ClassNotFoundException, SQLException {
		return dao.importInfo(info);
	}
}
