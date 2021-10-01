package payment;

public class PaymentVO {
		int rownum;
		long reserve_no;
		int adult_tk;
		int child_tk;
		String time_code;
		String ROUTE_NO;
		int MILEAGE;
		int BALANCE;
		String id;
		int totalfee;
		
		private static PaymentVO instance;

		public static PaymentVO getInstance() {
			if (instance == null) {
				instance = new PaymentVO();
			}
			return instance;
		}
		
		public PaymentVO() {}
		
		public PaymentVO(int rownum, long reserve_no, String ROUTE_NO, int totalfee) {
			super();
			this.rownum = rownum;
			this.reserve_no = reserve_no;
			this.ROUTE_NO = ROUTE_NO;
			this.totalfee = totalfee;
		}

		public PaymentVO(long reserve_no, int adult_tk, int child_tk, String time_code, String ROUTE_NO) {
			super();
			this.reserve_no = reserve_no;
			this.adult_tk = adult_tk;
			this.child_tk = child_tk;
			this.time_code = time_code;
			this.ROUTE_NO = ROUTE_NO;
		}
		

		public int getRownum() {
			return rownum;
		}

		public void setRownum(int rownum) {
			this.rownum = rownum;
		}

		public long getReserve_no() {
			return reserve_no;
		}

		public void setReserve_no(long reserve_no) {
			this.reserve_no = reserve_no;
		}

		public int getAdult_tk() {
			return adult_tk;
		}

		public void setAdult_tk(int adult_tk) {
			this.adult_tk = adult_tk;
		}

		public int getChild_tk() {
			return child_tk;
		}

		public void setChild_tk(int child_tk) {
			this.child_tk = child_tk;
		}

		public String getTime_code() {
			return time_code;
		}

		public void setTime_code(String time_code) {
			this.time_code = time_code;
		}

		public String getROUTE_NO() {
			return ROUTE_NO;
		}

		public void setROUTE_NO(String rOUTE_NO) {
			ROUTE_NO = rOUTE_NO;
		}

		public int getMILEAGE() {
			return MILEAGE;
		}

		public void setMILEAGE(int mILEAGE) {
			MILEAGE = mILEAGE;
		}

		public int getBALANCE() {
			return BALANCE;
		}

		public void setBALANCE(int bALANCE) {
			BALANCE = bALANCE;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public int getTotalfee() {
			return totalfee;
		}

		public void setTotalfee(int totalfee) {
			this.totalfee = totalfee;
		}

		@Override
		public String toString() {
			return "PaymentVO [번호=" + rownum + ", 예약번호=" + reserve_no + ", 노선번호=" + ROUTE_NO
					+ ", 총 결제금액=" + totalfee + "]";
		}

	
	

		

	
	
}
