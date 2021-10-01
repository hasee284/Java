package packageMain;

import java.util.Scanner;

import join.JoinController;
import member.LoginConsole;

public class View {
	Scanner scanner = new Scanner(System.in);
	private static View instance;
	public static View getInstance() {
		if (instance == null) {
			instance = new View();
		}
		return instance;
	}
	
	public static void main(String[] args) {
		System.out.println("==================");
		System.out.println("    대전복합터미널");
		System.out.println("  고속버스예약프로그램");
		System.out.println("==================");
		
		new View().start();
	}
	
	private MainMenu mainMenu = MainMenu.getInstance();
	private LoginConsole loginConsole = LoginConsole.getInstance();
	private JoinController joinController = JoinController.getInstance();
	
	public void start() {
		int menu = Menu.HOME;
		boolean run = true;
		
		while (run) {
			switch (menu) {
			case Menu.HOME:
				menu = home();
				break;
			case Menu.LOGIN:
				menu = loginConsole.login();
				break;
			case Menu.JOIN:
				menu = joinController.start();
				break;
			case Menu.MAINMENU:
				menu = mainMenu.service();
				break;
			case Menu.EXIT:
				System.out.println("");
				System.out.println("프로그램을 종료합니다.");
				System.out.println("이용해주셔서 감사합니다.");
				run = false;
				System.exit(0);
			}
		}
	}
	
	public int home() {
		int select;
		try {
			System.out.println("[1] 로그인");
			System.out.println("[2] 회원가입");
			System.out.println("[0] 프로그램 종료");
			System.out.print("> ");
			select = Integer.parseInt(scanner.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("다시 입력해주세요.");
			System.out.println("==============");
			return Menu.HOME;
		}
		
		System.out.println("");
		
		switch (select) {
		case 1:
			return Menu.LOGIN;
		case 2:
			return Menu.JOIN;
		case 0:
			return Menu.EXIT;
		default:
			System.out.println("다시 입력해주세요.");
			System.out.println("==============");
			return Menu.HOME;
		}
	}
}
