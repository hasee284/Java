package payment;

import java.sql.SQLException;
import java.util.List;

public class PaymentService {
	private PaymentDao dao = PaymentDao.getInstance();
	private static PaymentService instance;
	public static PaymentService getInstance() {
		if (instance == null) {
			 instance = new PaymentService();
		}
		return instance;
	}
	private PaymentService() {}

//	public List<PaymentVO> checkReservation(int reserveNo) throws ClassNotFoundException, SQLException {
//		return dao.checkReservation(reserveNo);
//	}
	public int useBalance(PaymentVO vo) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return dao.useBalance(vo);
	}
	public int checkBalance(PaymentVO vo) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return dao.checkBalance(vo);
	}
	public int autopay(int reserveNo) throws ClassNotFoundException, SQLException{
		// TODO Auto-generated method stub
		return dao.autopay(reserveNo);
	}
	public List<PaymentVO> checkReserNo(String user_id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return dao.checkReserNo(user_id);
	}
	public int insertPayment(PaymentVO vo) throws ClassNotFoundException, SQLException {
		return dao.insertPayment(vo);
	}

}
