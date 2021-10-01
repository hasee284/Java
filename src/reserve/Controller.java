package reserve;

import join.JoinService;

public class Controller {
	public static void main(String[] args) throws Exception {
		new Controller().start();
	}
	
	private JoinService joinService = JoinService.getInstance();
	private ReservationService reservationService = ReservationService.getInstance();
	
	public void start() throws Exception {
		int view = View.HOME;
		while (true) {
			switch (view) {
			case View.HOME:
				view = home();
				break;
				
			case View.JOIN:
				view = joinService.join();
				break;
			
			case View.RESERVATION:
				view = reservationService.resrv();
				break;
			}
		}
	}
	
	private int home() {
		System.out.println("==========================================================================");
		System.out.println("=                                                                        =");
		System.out.println("=------------------------------ 버스예약시스템 ------------------------------=");
		System.out.println("=                                                                        =");
		System.out.println("==========================================================================");
		System.out.println("1.회원가입  2. 예매하기");
		System.out.println("==========================================================================");
		System.out.print("입력 > ");
		int select = ScanUtil.nextInt();
		
		while(true) {
			switch (select) {
			case 1:
				return View.JOIN;
			case 2:
				return View.RESERVATION;
			default:
				return View.HOME;
			}
		}
	}
}
