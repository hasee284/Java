package reservation;

import java.sql.SQLException;
import java.util.List;
import java.util.Random;

import member.MemberVO;
import packageMain.Database;

public class ReservationService {
	private static ReservationService instance;
	public static ReservationService getInstance() {
		if (instance == null) {
			instance = new ReservationService();
		}
		return instance;
	}
	reservationChange.ReservationVO reservationVO = Database.getReservationChangeSession();
	MemberVO memberVO = Database.getSession();
	private ReservationService() {}
	
	private ReservationDAO reservationDao = ReservationDAO.getInstance();
	
	public int resrv() {
		Random random = new Random();
		List<RouteVO> arrivalList = null;
		try {
			arrivalList = reservationDao.getArrivalSpotList();
		} catch (SQLException e1) {
			System.out.println("오류가 발생했습니다.(1)");
			System.out.println("다시 시도해주세요.");
			return View.HOME;
		}
		System.out.println();
		System.out.println("\t<<<<<<<<<<<<<<<<<< 도착지 선택 >>>>>>>>>>>>>>>>>>");
		for (RouteVO routeVO : arrivalList) {
			System.out.println("\t"+routeVO);
			System.out.println("------------------------------------------------------");
		}
		System.out.println();
		String routeNo = "";
		while(true) {
			System.out.println("노선번호를 입력하세요.");
			System.out.print(">> ");
			routeNo = ScanUtil.nextLine();
			//routeNo 값을 가지고 select 하여 리턴된 값이 일치하면 go아님 back
			String resultRouteNo = null;
			try {
				resultRouteNo = reservationDao.getRouteNo(routeNo);
			} catch (SQLException e) {
				System.out.println("오류가 발생했습니다.(2)");
				System.out.println("다시 시도해주세요.");
				return View.HOME;
			}
			if (routeNo.equals(resultRouteNo)) {
				reservationVO.setRouteNo(routeNo); //노선번호
				break;
			} else {
				System.out.println("경고 : 해당 노선이 존재하지 않습니다.");
				System.out.println("다시 입력해주세요^^");
				System.out.println("");
			}
		}
		
		int seatNo = random.nextInt(36)+1;
		reservationVO.setSeatNo(seatNo);
		
		System.out.println("\t<<<<<<<<<<<<< 시간 선택 >>>>>>>>>>>>>");
		List<OperationVO> timeList = null;
		try {
			timeList = reservationDao.getTimeList(reservationVO.getRouteNo());
		} catch (SQLException e1) {
			System.out.println("오류가 발생했습니다.(3)");
			System.out.println("다시 시도해주세요.");
			return View.HOME;
		}
		for (OperationVO operationVO : timeList) {
			System.out.println("\t"+operationVO);
			System.out.println("------------------------------------------------------");
		}
		
		String routeTime;
		while (true) {
			System.out.println("희망 시간을 선택하세요(':' 포함하여 입력)");
			System.out.print(">> ");
			routeTime = ScanUtil.nextLine();
			String resultRouteTime;
			try {
				resultRouteTime = reservationDao.getRouteTime(routeTime);
			} catch (SQLException e) {
				System.out.println("오류가 발생했습니다.(4)");
				System.out.println("다시 시도해주세요.");
				return View.HOME;
			}
			if (routeTime.equals(resultRouteTime)) {
				reservationVO.setStartTime(routeTime);
				if (routeTime.length() == 4) {
					reservationVO.setTimeCode(routeTime.substring(0, 1));
				} else if (routeTime.length() == 5) {
					reservationVO.setTimeCode(routeTime.substring(0, 2));
				}
				break;
			} else {
				System.out.println("경고 : 배차 시간이 존재하지 않습니다.");
				System.out.println("다시 입력해주세요^^");
			} 
		}
//		System.out.print("ID : "); //아이디
//		String memId = ScanUtil.nextLine();
		reservationVO.setId(memberVO.getId());
		System.out.println("1.성인 / 2.아동");
		System.out.print(">> ");
		int ac = ScanUtil.nextInt();
		if (ac == 1) {
			int insertAdultReservation;
			try {
				int getAdultFee = reservationDao.getTicket(routeNo);
				System.out.println("성인 요금은 "+getAdultFee +"원 입니다.");
				System.out.println();
				reservationVO.setAdultTk(getAdultFee); //티켓
				reservationVO.setTotalFee(getAdultFee);
				insertAdultReservation = reservationDao.insertAdultReservation(reservationVO);
			} catch (SQLException e) {
				System.out.println("오류가 발생했습니다.(5)");
				System.out.println("다시 시도해주세요.");
				return View.HOME;
			}
			if (insertAdultReservation > 0) {
				System.out.println("예매가 완료되었습니다.");
				System.out.println("이용해주셔서 감사합니다 ♥ ");
				return View.MAINMENU;
			} else {
				System.out.println("예매 불가능!");
				System.out.println("다시 실행해주세요.");
				return View.HOME;
			}
		} else if(ac == 2) {
			int insertChildReservation = 0;
			try {
				int getChildFee = reservationDao.getTicket(routeNo);
				System.out.println("아동 요금은 "+ getChildFee/2 +"원 입니다.");
				System.out.println();
				reservationVO.setChildTk(getChildFee/2);
				reservationVO.setTotalFee(getChildFee/2);
				insertChildReservation = reservationDao.insertChildReservation(reservationVO);
			} catch (SQLException e) {
				System.out.println("오류가 발생했습니다.(6)");
				System.out.println("다시 시도해주세요.");
				return View.HOME;
			}
			if (insertChildReservation > 0) {
				System.out.println("예매가 완료되었습니다.");
				System.out.println("이용해주셔서 감사합니다 ♥ ");
				System.out.println();
				return View.MAINMENU;
			} else {
				System.out.println("예매 불가능!");
				System.out.println("다시 실행해주세요.");
				return View.HOME;
			}
		}
		return View.HOME;
	}
	
	public int resrv2(String getTime, String getRouteNum) {
		Random random = new Random();
		while(true) {

			String resultRouteNo = null;
			try {
				resultRouteNo = reservationDao.getRouteNo(getRouteNum);
			} catch (SQLException e) {
				System.out.println("오류가 발생했습니다.(2)");
				System.out.println("다시 시도해주세요.");
				return View.HOME;
			}
			if (getRouteNum.equals(resultRouteNo)) {
				reservationVO.setRouteNo(getRouteNum); //노선번호
				break;
			} else {

			}
		}
		
		int seatNo = random.nextInt(36)+1;
		reservationVO.setSeatNo(seatNo);
		

		while (true) {

			String resultRouteTime;
			try {
				resultRouteTime = reservationDao.getRouteTime(getTime);
			} catch (SQLException e) {
				System.out.println("오류가 발생했습니다.(4)");
				System.out.println("다시 시도해주세요.");
				return View.HOME;
			}
			if (getTime.equals(resultRouteTime)) {
				reservationVO.setStartTime(getTime);
				if (getTime.length() == 4) {
					reservationVO.setTimeCode(getTime.substring(0, 1));
				} else if (getTime.length() == 5) {
					reservationVO.setTimeCode(getTime.substring(0, 2));
				}
				break;
			} else {
			} 
		}
		
		reservationVO.setId(memberVO.getId());
		System.out.println("1.성인 / 2.아동");
		System.out.print(">> ");
		int ac = ScanUtil.nextInt();
		if (ac == 1) {
			int insertAdultReservation;
			try {
				int getAdultFee = reservationDao.getTicket(getRouteNum);
				System.out.println("성인 요금은 "+getAdultFee +"원 입니다.");
				System.out.println();
				reservationVO.setAdultTk(getAdultFee); //티켓
				reservationVO.setTotalFee(getAdultFee);
				insertAdultReservation = reservationDao.insertAdultReservation(reservationVO);
			} catch (SQLException e) {
				System.out.println("오류가 발생했습니다.(5)");
				System.out.println("다시 시도해주세요.");
				return View.HOME;
			}
			if (insertAdultReservation > 0) {
				System.out.println("예매가 완료되었습니다.");
				System.out.println("이용해주셔서 감사합니다 ♥ ");
				return View.MAINMENU;
			} else {
				System.out.println("예매 불가능!");
				System.out.println("다시 실행해주세요.");
				return View.HOME;
			}
		} else if(ac == 2) {
			int insertChildReservation = 0;
			try {
				int getChildFee = reservationDao.getTicket(getRouteNum);
				System.out.println("아동 요금은 "+ getChildFee/2 +"원 입니다.");
				System.out.println();
				reservationVO.setChildTk(getChildFee/2);
				reservationVO.setTotalFee(getChildFee/2);
				insertChildReservation = reservationDao.insertChildReservation(reservationVO);
			} catch (SQLException e) {
				System.out.println("오류가 발생했습니다.(6)");
				System.out.println("다시 시도해주세요.");
				return View.HOME;
			}
			if (insertChildReservation > 0) {
				System.out.println("예매가 완료되었습니다.");
				System.out.println("이용해주셔서 감사합니다 ♥ ");
				System.out.println();
				return View.MAINMENU;
			} else {
				System.out.println("예매 불가능!");
				System.out.println("다시 실행해주세요.");
				return View.HOME;
			}
		}
		return View.HOME;
	}
}