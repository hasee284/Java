package service;

import java.time.LocalDate;

public class ScheduleDayService {
	private ScheduleDayService(){}
	private static ScheduleDayService instance;
	public static ScheduleDayService getInstance(){
		if(instance == null){
			instance = new ScheduleDayService();
		}
		return instance;
	}
	
	public int ScheduleDay() {
		System.out.println("--------------------------");
		System.out.println("         가는 날            ");
		System.out.println("--------------------------");
		System.out.println(LocalDate.now());
		return 0;
	}

}
