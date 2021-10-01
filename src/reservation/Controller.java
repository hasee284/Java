package reservation;

import packageMain.Menu;

public class Controller {
	private static Controller instance;
	public static Controller getInstance() {
		if (instance == null) {
			instance = new Controller();
		}
		return instance;
	}
	private ReservationService reservationService = ReservationService.getInstance();
	
//	public static void main(String[] args) throws Exception {
//		new Controller().start();
//	}
	
	public int start() {
		int view = View.HOME;
		while (true) {
			switch (view) {
			case View.HOME:
				view = home();
				break;
			case View.RESERVATION:
				view = reservationService.resrv();
				break;
			case View.MAINMENU:
				return Menu.MAINMENU;
			}
		}
	}
	
	private int home() {
		System.out.println("======================");
		System.out.println("1.승차권 예매  2.이전 화면");
		System.out.println("======================");
		System.out.print("> ");
		int select = ScanUtil.nextInt();
		
		while(true) {
			switch (select) {
			case 1:
				return View.RESERVATION;
			case 2:
				return View.MAINMENU;
			default:
				return Menu.MAINMENU;
			}
		}
	}
}
