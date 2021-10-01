package reservationChange;

import java.sql.SQLException;
import java.util.List;

public class ReservationController {
	
	private static ReservationController instance;
	public static ReservationController getInstance() {
		if (instance == null) {
			instance = new ReservationController();
		}
		return instance;
	}
	private ReservationController() {
	}
	
	ReservationService service = ReservationService.getInstance();
	
	public List<ReservationVO> getScheduleList(String arrival) throws SQLException, ClassNotFoundException {
		return service.getScheduleList(arrival);
	}
	
	public List<ReservationVO> reservationInquiry(String id) throws SQLException, ClassNotFoundException {
		return service.reservationInquiry(id);
	}
	public int reservationCancel(ReservationVO delete) throws ClassNotFoundException, SQLException {
		return service.reservationCancel(delete);
	}

}
