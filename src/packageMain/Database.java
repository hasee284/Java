package packageMain;

import member.MemberVO;
import payment.PaymentVO;
import reservationChange.ReservationVO;

public class Database {
	private static MemberVO session;
	
	public static MemberVO getSession() {
		if (session == null) {
			session = new MemberVO();
		}
		return session;
	}
	
	private static PaymentVO paymentSession;
	
	public static PaymentVO getPaymentSession() {
		if (paymentSession == null) {
			paymentSession = new PaymentVO();
		}
		return paymentSession;
	}
	
	private static ReservationVO reservationChangeSession;
	
	public static reservationChange.ReservationVO getReservationChangeSession() {
		if (reservationChangeSession == null) {
			reservationChangeSession = new ReservationVO();
		}
		return reservationChangeSession;
	}
	
//	private static reservation.ReservationVO reserveSession;
//	
//	public static reservation.ReservationVO getReservationSession() {
//		if (reserveSession == null) {
//			reserveSession = new reservation.ReservationVO();
//		}
//		return reserveSession;
//	}
}
