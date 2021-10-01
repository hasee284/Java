package member;

public class MemberService {
	private static MemberService instance;
	public static MemberService getInstance() {
		if (instance == null) {
			instance = new MemberService();
		}
		return instance;
	}
	private MemberService() {}
	
	private MemberDao dao = MemberDao.getInstance();
	
	public MemberVO login(MemberVO vo) {
		return dao.login(vo);
	}
	public int inputNoticeMenu(MemberVO menu) {
		return dao.inputNoticeMenu(menu);
	}
}
