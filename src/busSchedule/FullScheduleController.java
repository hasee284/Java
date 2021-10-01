package busSchedule;

import java.sql.SQLException;
import java.util.List;

public class FullScheduleController {
	FullScheduleService service = FullScheduleService.getInstance();
	private static FullScheduleController instance = new FullScheduleController();
	public static FullScheduleController getInstance() {
		return instance;
	}
	private FullScheduleController() {}
	public List<FullScheduleVO> fullScheduleReturn(String input3) throws ClassNotFoundException, SQLException {
		return service.fullScheduleReturn(input3);
	}
//	public List<FullScheduleVO> selectResultReturn(int input4i) throws ClassNotFoundException, SQLException {
//		return service.fullScheduleReturn(input4i);
//	}

	
	
	

}
