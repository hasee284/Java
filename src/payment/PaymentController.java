package payment;

import java.sql.SQLException;
import java.util.List;

public class PaymentController {
	PaymentService service = PaymentService.getInstance();
	private static PaymentController instance;
	public static PaymentController getInstance() {
		if (instance == null) {
			 instance = new PaymentController();
		}
		return instance;
	}
	private PaymentController() {}
	
//	public List<PaymentVO> checkReservation(int reserveNo) throws ClassNotFoundException, SQLException {
//		return service.checkReservation(reserveNo);
//		
//	}
	public int useBalance(PaymentVO vo) throws ClassNotFoundException, SQLException {
		return service.useBalance(vo);
		
	}
	public int checkBalance(PaymentVO vo) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return service.checkBalance(vo);
	}
	public int autopay(int reserveNo) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return service.autopay(reserveNo);
	}
	public List<PaymentVO> checkReserNo(String user_id) throws ClassNotFoundException, SQLException{
		// TODO Auto-generated method stub
		return service.checkReserNo(user_id);
	}
	public int insertPayment(PaymentVO vo) throws ClassNotFoundException, SQLException {
		return service.insertPayment(vo);
	}

}
