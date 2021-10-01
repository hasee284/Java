package member;

import java.util.Scanner;

import org.springframework.dao.EmptyResultDataAccessException;

import packageMain.Database;
import packageMain.Menu;

public class LoginConsole {
	Scanner scn = new Scanner(System.in);
	private MemberController ck = MemberController.getInstance();
	private MemberVO session = Database.getSession();
	private static LoginConsole instance;
	public static LoginConsole getInstance() {
		if (instance == null) {
			instance = new LoginConsole();
		}
		return instance;
	}
	
	public int login() {
		System.out.print("─────────१✌˚◡˚✌५─────────१✌˚◡˚✌५─────────"+"\n");
		boolean run = true;
		
		while (run) {
			System.out.println("아이디를 입력하세요.");
			System.out.print("> ");
			String id = scn.nextLine();
			
			System.out.println("비밀번호를 입력하세요.");
			System.out.print("> ");
			String pw = scn.nextLine();
			
			session.setId(id);
			session.setPwd(pw);
			
			try {
				//성공
				MemberVO result = ck.login(session);
				if(result.getId() == null) {
					System.out.println("로그인에 실패했습니다.");
					System.out.println("아이디와 비밀번호를 확인해주세요.");
					System.out.println("==========================");
					return Menu.HOME;
				} else {
					System.out.println("로그인 성공 >.<");
					//while문 종료
					run = false;
					System.out.println("─────────१✌˚◡˚✌५─────────१✌˚◡˚✌५─────────");
					return Menu.MAINMENU;
				}
			} catch (EmptyResultDataAccessException e) {
				System.out.println("로그인에 실패했습니다.");
				System.out.println("아이디와 비밀번호를 확인해주세요.");
				System.out.println("==========================");
				return Menu.HOME;
			}
		}
		return Menu.HOME;
	}
}
