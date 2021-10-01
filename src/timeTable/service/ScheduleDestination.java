package service;

//import timeTable.util.ScanUtil;

public class ScheduleDestination {
	private ScheduleDestination(){}
	private static ScheduleDestination instance;
	public static ScheduleDestination getInstance(){
		if(instance == null){
			instance = new ScheduleDestination();
		}
		return instance;
}
//	private UserDao userDao = UserDao.getInstance();
	
	public int destination() {
//		System.out.println("--------------------------");
//		System.out.println("          도착지            ");
//		System.out.println("--------------------------");
//		System.out.println("1.서울경부\t2.광주\t3.부산\t4.동서울\t5.전주\t6.동대구\t7.인천\t8.강릉\t9.당진\t10.당진기지시\t11.상봉\t12.서대구"
//				+ "\t13.서산\t12.서대구\t13.서산\t14.전주호남제일문\t15.천안\t16.태안\t17.포항\t18.횡성하행\t19.성남\t20.김천"); 
//		String destinationNum = ScanUtil.nextLine();
//		System.out.println("번호를 입력해주세요");
		
		return 0;
		
	
	}
}
	


