package reserve;

import java.util.List;
import java.util.Random;

public class ReservationService {
	private static ReservationService instance;
	public static ReservationService getInstance() {
		if (instance == null) {
			instance = new ReservationService();
		}
		return instance;
	}
	private ReservationService() {}
	
	private ReservationDAO reservationDao = ReservationDAO.getInstance();
	
	public int resrv() throws Exception {
		ReservationVO rsvVo = new ReservationVO();
		Random random = new Random();
		List<RouteVO> arrivalList = reservationDao.getArrivalSpotList();
		System.out.println();
		System.out.println("\t<<<<<<< 도착지 선택 >>>>>>>");
		for (RouteVO routeVO : arrivalList) {
			System.out.println("\t"+routeVO);
		}
		System.out.println();
		System.out.println("노선번호를 입력하세요.");
		System.out.print(">> ");
		String routeNo = ScanUtil.nextLine();
		rsvVo.setRouteNo(routeNo); //노선번호
		int seatNo = random.nextInt(36)+1;
		rsvVo.setSeatNo(seatNo);
		System.out.println("\t<<<<<<< 시간 선택 >>>>>>>");
		List<OperationVO> timeList = reservationDao.getTimeList(rsvVo.getRouteNo());
		for (OperationVO operationVO : timeList) {
			System.out.println("\t"+operationVO);
		}
		System.out.println("희망 시간을 선택하세요(':' 포함하여 입력)");
		System.out.print(">> ");
		String routeTime = ScanUtil.nextLine();
		rsvVo.setStartTime(routeTime); //출발시간
		
		if (routeTime.length()==4) {
			rsvVo.setTimeCode(routeTime.substring(0,1));  
		}else if(routeTime.length()==5) {
			rsvVo.setTimeCode(routeTime.substring(0,2));
		}
		
		System.out.print("ID : "); //아이디
		String memId = ScanUtil.nextLine();
		rsvVo.setMemId(memId);
		System.out.println("1.성인 / 2.아동");
		System.out.print(">> ");
		int ac = ScanUtil.nextInt();
		if (ac == 1) {
			int getAdultFee = reservationDao.getTicket(routeNo);
			System.out.println("성인 요금은 "+getAdultFee +"원 입니다.");
			System.out.println();			
			rsvVo.setAdultTk(getAdultFee); //티켓
			rsvVo.setTotalFee(getAdultFee);
			int insertAdultReservation = reservationDao.insertAdultReservation(rsvVo);
			if (insertAdultReservation > 0) {
				System.out.println("예매가 완료되었습니다.");
			}else {
				System.out.println("예매 불가능!");
			}
		} else if(ac == 2) {
			int getChildFee = reservationDao.getTicket(routeNo);
			System.out.println("아동 요금은 "+ getChildFee/2 +"원 입니다.");
			rsvVo.setChildTk(getChildFee/2);
			rsvVo.setTotalFee(getChildFee/2);
			int insertChildReservation = reservationDao.insertChildReservation(rsvVo);
			if (insertChildReservation > 0) {
				System.out.println("예매가 완료되었습니다.");
			} else {
				System.out.println("예매 불가능!");
			}
		}
		return View.HOME;
	}
}