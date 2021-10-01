package service;

public class ScheduleDeparturetime {
	private ScheduleDeparturetime(){}
	private static ScheduleDeparturetime instance;
	public static ScheduleDeparturetime getInstance(){
		if(instance == null){
			instance = new ScheduleDeparturetime();
		}
		return instance;
}
//	private UserDao userDao = UserDao.getInstance();



}
