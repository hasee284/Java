package payment;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import member.MemberVO;
import packageMain.Database;
import packageMain.Menu;

public class PaymentConsole {
	private static PaymentConsole instance;
	public static PaymentConsole getInstance() {
		if (instance == null) {
			instance = new PaymentConsole();
		}
		return instance;
	}
	private PaymentController pay = PaymentController.getInstance();
	private PaymentVO vo = Database.getPaymentSession();
	private MemberVO memberVO = Database.getSession();
	Scanner scanner = new Scanner(System.in); 
			
	public int payment() {
		boolean input = true;
		
start:	while (input) {
		
//		System.out.println("결제를 하겠습니까? ");
		System.out.println("1.결제정보 확인 2.결제 취소");
		System.out.print("> ");
		
		String user_choice = scanner.nextLine();
		int choice = Integer.parseInt(user_choice);
		
		switch (choice) {
		case 1:
			System.out.println("-----------------------------------");
			
//			System.out.print("아이디를 입력하세요: ");
//			String user_id = scanner.nextLine();
			vo.setId(memberVO.getId());
			List<PaymentVO> list2;
			try {
				list2 = pay.checkReserNo(vo.getId());
			} catch (ClassNotFoundException e) {
				System.out.println("오류가 발생했습니다.");
				System.out.println("다시 시도해주세요.");
				continue start;
			} catch (SQLException e) {
				System.out.println("오류가 발생했습니다.");
				System.out.println("다시 시도해주세요.");
				continue start;
			}//예약번호 받기(로그인한 아이디를 바탕으로)
			for (PaymentVO vo2 : list2) {
				System.out.println(vo2);
			}
			boolean input2 = true;
			
			System.out.println("-----------------------------------");
			System.out.println("결제할 내용을 확인해 주세요");
			System.out.println("결제할 내용이 맞다면 결제를 진행해 주세요");
			System.out.println("-----------------------------------");
			System.out.println("1.결제 2.결제취소");
			
			while (input2) {
				System.out.print(">> ");
				String user_choice2 = scanner.nextLine();
				int user_choice3 = Integer.parseInt(user_choice2);
				
				
			switch (user_choice3) {
				case 1:
					int autopay = 0;
					int checkBalance = 0;
					int result = 0;
					try {
						System.out.println("결제번호를 입력하세요.");
						System.out.print("> ");
						String reNo = scanner.nextLine();
						int reserveNo = Integer.parseInt(reNo);
						vo.setReserve_no(reserveNo);
						autopay = pay.autopay(reserveNo);
						checkBalance = pay.checkBalance(vo);
						System.out.println("-----------------------------------");
						if((checkBalance-autopay)>0) {
							System.out.println("잔액이 충분합니다. 결제를 실행합니다.");
							vo.setTotalfee(autopay);
							result = pay.useBalance(vo);
							vo.setBALANCE(checkBalance - autopay);
							pay.insertPayment(vo);
						} else {
							System.out.println("잔액이 부족합니다. 충전후 이용해 주세요");
						}
					} catch (NumberFormatException e) {
						System.out.println("결제에 실패했습니다.");
						System.out.println("다시 시도해주세요.");
					} catch (ClassNotFoundException e) {
						System.out.println("결제에 실패했습니다.");
						System.out.println("다시 시도해주세요.");
					} catch (SQLException e) {
						System.out.println("결제에 실패했습니다.");
						System.out.println("다시 시도해주세요.");
					}
						if(result>0) {
							System.out.println("결제를 완료했습니다.");
							System.out.printf("현재 잔액은: %,d 입니다.", vo.getBALANCE());
							System.out.println("");
						} else {
							System.out.println("결제에 실패했습니다.");
						}
					input2 = false;
					input = false;
					return Menu.MAINMENU;
				case 2:
					System.out.println("결제를 취소했습니다.");
					input2 = false;
					input = false;
					return Menu.MAINMENU;
				default:
					System.out.println("1~2번을 선택해 주세요");
					break;
				}//switch2 end
			}// while2 end
			break;
		case 2:
			System.out.println("결제를 취소했습니다.");
			input = false;
			return Menu.MAINMENU;
		default:
			System.out.println("1~2번을 선택해 주세요");
			break;
		}
	}//while end
	return Menu.MAINMENU;
}//main end
}//class end
