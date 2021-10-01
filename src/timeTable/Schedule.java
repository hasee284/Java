import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import Dao.ScheduleDestinationDao;
import service.ScheduleDayService;
import service.ScheduleDestination;
import util.ScanUtil;
import util.View;
import vo.ScheduleDestinationVo;
import vo.ScheduleVO;

public class Schedule {
	private static Schedule instance;
	public static Schedule getInstance() {
		if (instance == null) {
			instance = new Schedule();
		}
		return instance;
	}
	
	public static void main(String[] args) throws Exception {
		new Schedule().start();
	}

	private ScheduleDestination scheduleDestination = ScheduleDestination.getInstance();
	private ScheduleDayService scheduleDay = ScheduleDayService.getInstance();

	public int start() {
		int view = View.Schedule;
		boolean run = true;
		
		while (run) {
			try {
				switch (view) {
				case View.Schedule:
					view = mainMenu();
					break;
				case View.ScheduleDestination:
					view = scheduleDestination.destination();
					break;
				case View.ScheduleDay:
					view = scheduleDay.ScheduleDay();
					break;
				case View.ScheduleBack:
					run = false;
					return Menu.MAINMENU;
				}
			} catch (SQLException e) {
				System.out.println("오류가 발생하였습니다.");
				System.out.println("메인 메뉴로 돌아갑니다.");
				return Menu.MAINMENU;
			}
		}
		return 0;
	}

	public int mainMenu() throws SQLException {
		ScheduleDestinationDao dao = new ScheduleDestinationDao();
		
		System.out.println("----------------------------------------------------------");
		System.out.println("<<시간표 조회");
		System.out.println("----------------------------------------------------------");
		System.out.println("<출발지: 대전복합");
		System.out.println("----------------------------------------------------------");
		System.out.print("<도착지: ");
		System.out.println("서울경부 광주 부산 동서울 전주 동대구 인천 강릉 당진 당진기지시 상봉 "
				        +"\n\t"+"서대구 서산 전주호남제일문 천안 태안 포항 횡성하행 성남 김천");
		System.out.println("----------------------------------------------------------");
		System.out.print("<도착지를 입력하세요: ");
		String scheduleDestination = ScanUtil.nextLine();
		List<ScheduleDestinationVo> result = dao.getScheduleList(scheduleDestination);
//		System.out.println(result);
		result.forEach(System.out::println);
		System.out.println("----------------------------------------------------------");
		System.out.print("가는날 : ");
		System.out.println(LocalDate.now());
		System.out.println("----------------------------------------------------------");
		System.out.println("1~20번 일반버스  101~116번 우등버스입니다.");
		System.out.print("<해당버스번호를 입력하세요: ");
		String routeNo = ScanUtil.nextLine();
		List<ScheduleVO> list = dao.getSchedule(routeNo);
		for (ScheduleVO vo : list) {
			System.out.println(vo);
		}
//		vo.setArrivalSpot(scheduleDestination);
//		System.out.printf("출발시간:%s 회사:%s 잔여석:%d",vo.getTime(),vo2.getName(), vo.getDistance());
		
		System.out.println("");
		System.out.println("[1] 다시 조회하기");
		System.out.println("[9] 이전 화면");
		System.out.println("[0] 프로그램 종료");
		System.out.print("> ");
		int select = 0;
		boolean run2 = true;
		
		while (run2) {
			try {
				select = Integer.parseInt(ScanUtil.nextLine());
				switch (select) {
				case 1:
					run2 = false;
					return View.Schedule;
				case 9:
					run2 = false;
					return View.ScheduleBack;
				case 0:
					System.out.println("프로그램을 종료합니다.");
					System.out.println("이용해주셔서 감사합니다.");
					System.exit(0);
				default:
					System.out.println("다시 입력해주세요.");
				}
			} catch (NumberFormatException e) {
				System.out.println("다시 입력해주세요.");
			}
		}
		return 0;
	}
}
