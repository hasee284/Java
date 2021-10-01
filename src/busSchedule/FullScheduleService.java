package busSchedule;

import java.sql.SQLException;
import java.util.List;

public class FullScheduleService {
	FullScheduleDao dao = FullScheduleDao.getInstance();
	private static FullScheduleService instance = new FullScheduleService();
	public static FullScheduleService getInstance() {
		return instance;
	}
	private FullScheduleService() {}
	
	public List<FullScheduleVO> fullScheduleReturn(String input3) throws ClassNotFoundException, SQLException {
		return dao.fullScheduleReturn(input3);
	}
//	public List<FullScheduleVO> fullScheduleReturn(int input4i) throws ClassNotFoundException, SQLException {
//		return dao.fullScheduleReturn(input4i);
//	}
	
	
	

}
