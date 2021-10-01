package member;

public class MemberController {
	
	private static MemberController instance;
	
	public static MemberController getInstance() {
		if (instance == null) {
			instance = new MemberController();
		}
		return instance;
	}
	
	private MemberController() {}
	
	private MemberService service = MemberService.getInstance();
	
	public MemberVO login(MemberVO vo) {
		return service.login(vo);
	}

	public int inputNoticeMenu(MemberVO menu) {
		return service.inputNoticeMenu(menu);
	}
}
