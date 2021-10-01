package reservationChange;

import java.sql.SQLException;
import java.util.List;


public class ReservationService {
	
	ReservationVO vo = new ReservationVO();
	
	private static ReservationService instance;
	public static ReservationService getInstance() {
		if (instance == null) {
			instance = new ReservationService();
		}
		return instance;
	}
	
	public ReservationService() {
	}
	
	private ReservationDAO dao = ReservationDAO.getInstance();
	
	public List<ReservationVO> getScheduleList(String arrival) throws SQLException, ClassNotFoundException {
		return dao.getScheduleList(arrival);
	}

	public List<ReservationVO> reservationInquiry(String id) throws SQLException, ClassNotFoundException {
		return dao.reservationInquiry(id);
	}

	public int reservationCancel(ReservationVO delete) throws ClassNotFoundException, SQLException {
		return dao.reservationCancel(delete);
	}


}
