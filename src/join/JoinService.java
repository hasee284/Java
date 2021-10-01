package join;

import member.MemberVO;
import packageMain.Database;

public class JoinService {
	private UserDAO userDao = UserDAO.getInstance();
	private static JoinService instance;
	public static JoinService getInstance() {
		if (instance == null) {
			instance = new JoinService();
		}
		return instance;
	}
	private JoinService() {}
	
	public int join() {
		MemberVO session = Database.getSession();
		System.out.println(">>>>>회원가입<<<<<");
		while(true) {
			System.out.print("아이디 : ");
			String memId = ScanUtil.nextLine();
			System.out.print("패스워드 : ");
			String memPw = ScanUtil.nextLine();
			session.setId(memId);
			try {
				userDao.insertMember(session);
			} catch (Exception e) {
				System.out.println("다시 입력해주세요.");
			}
			break;
		}
		System.out.print("이름 : ");
		String memNm = ScanUtil.nextLine();
		System.out.print("나이(숫자만 입력) : ");
		int memAge = ScanUtil.nextInt();
		System.out.print("주소 : ");
		String memAddress = ScanUtil.nextLine();
		System.out.print("메일 : ");
		String memMail = ScanUtil.nextLine();
		System.out.print("전화번호 : ");
		String memPhone = ScanUtil.nextLine();
		System.out.print("충전할 금액 : ");
		int memBalance = ScanUtil.nextInt();
		session.setName(memNm);
		session.setPwd(memPw);
		session.setAge(memAge);
		session.setAddress(memAddress);
		session.setMail(memMail);
		session.setPhone(memPhone);
		session.setBalance(memBalance);
		int result = 0;
		try {
			result = userDao.updateMember(session);
		} catch (Exception e) {
			System.out.println("다시 입력해주세요.");
			System.out.println("==============");
			return View.JOIN;
		}
		if (result > 0) {
			System.out.println("회원가입을 축하드립니다~!");
			System.out.println("===================");
		}
		else {
			System.out.println("회원가입에 실패하였습니다.");
			System.out.println("===================");
		}
	return View.HOME;
	}
}