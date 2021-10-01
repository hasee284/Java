package packageMain;

import java.util.Scanner;

import busSchedule.FullScheduleConsole;
import myPage.MypageConsole;
import payment.PaymentConsole;
import reservation.Controller;
import reservationChange.ReservationConsole;

public class MainMenu {
	private static Scanner scanner = new Scanner(System.in);
	private static MainMenu instance;
	public static MainMenu getInstance() {
		if (instance == null) {
			instance = new MainMenu();
		}
		return instance;
	}
	
	private MypageConsole myPageConsole = MypageConsole.getInstance();
	private Controller reservationController = Controller.getInstance();
	private PaymentConsole paymentConsole = PaymentConsole.getInstance();
	private ReservationConsole reservationConsole = ReservationConsole.getInstance();
	private FullScheduleConsole fullScheduleConsole = FullScheduleConsole.getInstance();
	
	public int service() {
		int menu = Menu.MAINMENU;
		boolean run = true;
		
		while (run) {
			switch (menu) {
			case Menu.MAINMENU:
				menu = mainMenu();
				break;
			case Menu.RESERVATION:
				menu = reservationController.start();
				break;
			case Menu.CHANGE:
				menu = reservationConsole.reservation();
				break;
			case Menu.TIMETABLE:
				menu = fullScheduleConsole.timeTable();
				break;
			case Menu.MYPAGE:
				menu = myPageConsole.service();
				break;
			case Menu.PRINTTICKET:
				menu = paymentConsole.payment();
				break;
			case Menu.EXIT:
				System.out.println("로그아웃 하였습니다.");
				System.out.println("==================");
				run = false;
				return Menu.HOME;
			default:
				System.out.println("다시 선택해주세요.");
				System.out.println("===============");
				return Menu.MAINMENU;
			}
		}
		return Menu.MAINMENU;
	}
	
	
	public int mainMenu() {
		int select;
		try {
			System.out.println("[1] 승차권 예매");
			System.out.println("[2] 예매 확인 및 취소");
			System.out.println("[3] 결제");
			System.out.println("[4] 시간표 조회");
			System.out.println("[5] 마이페이지");
			System.out.println("[9] 로그아웃");
			System.out.println("[0] 프로그램 종료");
			System.out.print("> ");
			select = Integer.parseInt(scanner.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("다시 입력해주세요");
			System.out.println("==================");
			return Menu.MAINMENU;
		}
		
		System.out.println("");
		
		switch (select) {
		case 1:
			return Menu.RESERVATION;
		case 2:
			return Menu.CHANGE;
		case 3:
			return Menu.PRINTTICKET;
		case 4:
			return Menu.TIMETABLE;
		case 5:
			return Menu.MYPAGE;
		case 9:
			return Menu.EXIT;
		case 0:
			System.out.println("");
			System.out.println("프로그램을 종료합니다.");
			System.out.println("이용해주셔서 감사합니다.");
			System.exit(0);
		default:
			System.out.println("다시 입력해주세요.");
			System.out.println("==================");
			return Menu.MAINMENU;
		}
	}
}
