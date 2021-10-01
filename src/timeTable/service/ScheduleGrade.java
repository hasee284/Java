package service;

public class ScheduleGrade {
	private  ScheduleGrade(){}
	private static  ScheduleGrade instance;
	public static  ScheduleGrade getInstance(){
		if(instance == null){
			instance = new  ScheduleGrade();
		}
		return instance;
}
	

}
