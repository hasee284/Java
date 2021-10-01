package service;

//import timeTable.util.ScanUtil;

public class ScheduleCompanyService {
	private ScheduleCompanyService(){}
	private static ScheduleCompanyService instance;
	public static ScheduleCompanyService getInstance(){
		if(instance == null){
			instance = new ScheduleCompanyService();
		}
		return instance;
}
//	private UserDao userDao = UserDao.getInstance();
	
//	public void ScheduleCompany() {
//		System.out.println("--------------------------");
//		System.out.println("         버스 회사           ");
//		System.out.println("--------------------------");
//		System.out.println("1.천일고속\t2.동양고속\t3.금호고속\t4.중앙고속");
//		String companyNum = ScanUtil.nextLine();
//	}

}
