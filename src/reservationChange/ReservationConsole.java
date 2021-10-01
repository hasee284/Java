package reservationChange;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import member.MemberVO;
import packageMain.Database;
import packageMain.Menu;

public class ReservationConsole {
	Scanner scn = new Scanner(System.in);
	private ReservationController ck = ReservationController.getInstance();
	private MemberVO vo = Database.getSession();
	private reservationChange.ReservationVO reservationChangeVO = Database.getReservationChangeSession();
	private static ReservationConsole instance;
	public static ReservationConsole getInstance() {
		if (instance == null) {
			instance = new ReservationConsole();
		}
		return instance;
	}
	
//	private static Schedule schedule = Schedule.getInstance();

	public int reservation() {
		
		boolean run = true;
		
		while (run) {
			
			int userMenu;
			try {
				System.out.println("────────────१✌˚◡˚✌५────────────१✌˚◡˚✌५────────────");
				System.out.println("1.예약 조회	2.예약 취소	0.이전 화면");
				System.out.println("────────────१✌˚◡˚✌५────────────१✌˚◡˚✌५────────────");
				System.out.print("> ");
				userMenu = Integer.parseInt(scn.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("다시 입력해주세요.");
				run = false;
				return Menu.RESERVATION;
			}
			
			reservationChangeVO.setId(vo.getId());
			
			switch (userMenu) {
//			case 1:
				
//				System.out.println("버스 예약을 시작합니다.");
//				
//				
//				System.out.println("<출발지: 대전복합");
//				System.out.println("----------------------------------------------------------");
//				System.out.print("<도착지: ");
//				System.out.println("서울경부 광주 부산 동서울 전주 동대구 인천 강릉 당진 당진기지시 상봉 "
//						        +"\n\t"+"서대구 서산 전주호남제일문 천안 태안 포항 횡성하행 성남 김천");
//				
//				System.out.println("----------------------------------------------------------");
//				System.out.println("도착지를 입력하세요.");
//				System.out.print("> ");
//				String insertArrival = scn.nextLine();
//				reservationVO.setArrival(insertArrival);
//				List<ReservationVO> selectResult = null;
//				try {
//					selectResult = ck.getScheduleList(insertArrival);
//				} catch (Exception e) {
//					System.out.println("오류가 발생하였습니다.");
//					System.out.println("이전 화면으로 돌아갑니다.");
//					run = false;
//					return Menu.RESERVATION;
//				}
//				
//				for (ReservationVO vo : selectResult) {
//					System.out.println(vo);
//				}
//				
//				System.out.println("----------------------------------------------------------");
//				System.out.println("예약일자를 입력하세요(YYYYMMDD)");
//				System.out.print("> ");
//				String insertDate = scn.nextLine();
//				reservationVO.setReservationDate(insertDate);
//				
//				System.out.println("----------------------------------------------------------");
//				System.out.println("1~20번 : 일반버스, 101~116번 : 우등버스입니다.");
//				System.out.print("<예약할 버스번호를 입력하세요: ");
//				String insertRouteNo = scn.nextLine();
//				reservationVO.setRouteNo(insertRouteNo);
//				break;
				
			case 1:
				System.out.println("예약 내역을 조회합니다.");
//				System.out.print("아이디를 입력하세요: ");
//				String selectId = scn.next();
//				reservationVO.setId(selectId);
				List<ReservationVO> result2 = null;
				try {
					result2 = ck.reservationInquiry(reservationChangeVO.getId());
					if (result2 == null) {
						System.out.println("예약 내역이 존재하지 않습니다.");
					} else {
						System.out.println(reservationChangeVO.getId() + "님의 예약 내역입니다");						
						for (ReservationVO vo : result2) {
							System.out.println(vo);
						}
					}
				} catch (ClassNotFoundException e) {
					System.out.println("오류가 발생했습니다.");
					System.out.println("다시 시도해주세요.");
					return Menu.CHANGE;
				} catch (SQLException e) {
					System.out.println("오류가 발생했습니다.");
					System.out.println("다시 시도해주세요.");
					return Menu.CHANGE;
				}
				return Menu.CHANGE;
				
			case 2:
				System.out.println("예약을 취소합니다.");
				
//				System.out.print("아이디를 입력하세요: ");
//				String deleteId = scn.next();
//				scn.nextLine();
				
				List<ReservationVO> result3 = null;
				try {
					result3 = ck.reservationInquiry(reservationChangeVO.getId());
					System.out.println(reservationChangeVO.getId() + "님의 예약 내역입니다");
				} catch (ClassNotFoundException e) {
					System.out.println("오류가 발생했습니다.");
					System.out.println("다시 시도해주세요.");
					return Menu.RESERVATION;
				} catch (SQLException e) {
					System.out.println("오류가 발생했습니다.");
					System.out.println("다시 시도해주세요.");
					return Menu.RESERVATION;
				}
				
				for (ReservationVO vo : result3) {
				System.out.println(vo);
				}
				
				System.out.print("취소하실 번호를 입력하세요: ");
				int deleteNum = 0;
				try {
					deleteNum = Integer.parseInt(scn.nextLine());
				} catch (NumberFormatException e) {
					System.out.println("오류가 발생했습니다.");
					System.out.println("다시 시도해주세요.");
					return Menu.RESERVATION;
				}
				
				System.out.println("번호 " + deleteNum + "번의 예약 내역을 취소하시겠습니까? : ");
				System.out.println("[1]예		[2]아니오");
				System.out.print("> ");
					int deleteResult = 0;
					
					try {
						int answer = Integer.parseInt(scn.nextLine());
						
						if (answer == 1) {
							reservationChangeVO.setRowNum(deleteNum);
							deleteResult = ck.reservationCancel(reservationChangeVO);
							if (deleteResult>0) {
								System.out.println("예약이 취소되었습니다.");
							}
						} else if(answer == 2){
							System.out.println("예약 취소서비스를 종료합니다.");
						} else {
							System.out.println("잘못된 입력입니다.");
						}
					} catch (ClassNotFoundException e) {
						System.out.println("오류가 발생했습니다.");
						System.out.println("다시 시도해주세요.");
						return Menu.RESERVATION;
					} catch (SQLException e) {
						System.out.println("오류가 발생했습니다.");
						System.out.println("다시 시도해주세요.");
						return Menu.RESERVATION;
					}
				break;
			case 0:
				System.out.println("이전 화면으로 돌아갑니다.");
				System.out.println("");
				return Menu.MAINMENU;
			default:
				System.out.println("잘못된 입력입니다.");
				return Menu.RESERVATION;
			}
		}
		return Menu.MAINMENU;
	}
}
