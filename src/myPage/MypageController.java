package myPage;

import java.sql.SQLException;
import java.util.List;

import member.MemberVO;

public class MypageController {
	private MypageService service = MypageService.getInstance();
	private static MypageController instance;
	public static MypageController getInstance() {
		if (instance == null) {
			instance = new MypageController();
		}
		return instance;
	}
	
	private MypageController() {}
	
	public MemberVO selectInfo(MemberVO id) {
		return service.selectInfo(id);
	}

	public int deleteInfo(MemberVO delete) throws ClassNotFoundException, SQLException {
		return service.deleteInfo(delete);
	}

	public int updateInfo(MemberVO change) throws ClassNotFoundException, SQLException {
		return service.updateInfo(change);
	}

	public int rechargeInfo(MemberVO recharge) throws ClassNotFoundException, SQLException {
		return service.rechargeInfo(recharge);
	}
	
	public List<MemberVO> importInfo(MemberVO info) throws ClassNotFoundException, SQLException {
		return service.importInfo(info);
	}
}
