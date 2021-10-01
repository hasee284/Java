package util;


import service.ScheduleDayService;
import service.ScheduleDestination;

public class Schedule {
	public static void main(String[] args) {
		new Schedule().start();
	}

	private ScheduleDestination scheduleDestination = ScheduleDestination.getInstance();
	private ScheduleDayService scheduleDay = ScheduleDayService.getInstance();

	public int start() {
		int view = View.Schedule;

		while (true) {
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
			}
		}
	}

	public int mainMenu() {
		System.out.println("--------------------------");
		System.out.println("시간표 조회");
		System.out.println("--------------------------");
		System.out.println("1.도착지\t2.가는날");
		System.out.println("--------------------------");
		System.out.println("번호를 선택하여 입력하세요");
		int input = ScanUtil.nextInt();

		switch (input) {
		case 1:
			return View.ScheduleDestination;
		case 2:
			return View.ScheduleDay;
		case 0:
			System.out.println("이용해주셔서 감사합니다.");
			System.exit(0);
		default:
			System.out.println("다시 입력해주세요");
			break;
		}
		return View.Schedule;
	}
}
