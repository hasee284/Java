package reservationChange;

public class ReservationVO {
		
		private int rowNum;
		private long reserveNo; 			
		private String startTime;		
		private int adultTk;			
		private int childTk;			
		private int totalFee;			
		private String reservationDate;	
		private int useMileage;			
		private int savingMileage;		
		private String id;				
		private int seatNo;			
		private String timeCode;		
		private String routeNo;			
		private String arrival;			
		private int normalFee;
		private int distance;
		private String requiredTime;
		private int busNo;
		
		public ReservationVO() {
		}
		
		public ReservationVO(long reserveNo, String arrival, int normalFee, int distance, String requiredTime) {
			super();
			this.reserveNo = reserveNo;
			this.arrival = arrival;
			this.normalFee = normalFee;
			this.distance = distance;
			this.requiredTime = requiredTime;
		}
		
		public ReservationVO(int rowNum, long reserveNo, String startTime, int seatNo, String arrival, int normalFee) {
			this.rowNum = rowNum;
			this.reserveNo = reserveNo;
			this.startTime = startTime;
			this.seatNo = seatNo;
			this.arrival = arrival;
			this.normalFee = normalFee;
		}
		
		public int getRowNum() {
			return rowNum;
		}
		public void setRowNum(int rowNum) {
			this.rowNum = rowNum;
		}
		public long getReserveNo() {
			return reserveNo;
		}
		public void setReserveNo(long reserveNo) {
			this.reserveNo = reserveNo;
		}
		public String getStartTime() {
			return startTime;
		}
		public void setStartTime(String startTime) {
			this.startTime = startTime;
		}
		public int getAdultTk() {
			return adultTk;
		}
		public void setAdultTk(int adultTk) {
			this.adultTk = adultTk;
		}
		public int getChildTk() {
			return childTk;
		}
		public void setChildTk(int childTk) {
			this.childTk = childTk;
		}
		public int getTotalFee() {
			return totalFee;
		}
		public void setTotalFee(int totalFee) {
			this.totalFee = totalFee;
		}
		public String getReservationDate() {
			return reservationDate;
		}
		public void setReservationDate(String reservationDate) {
			this.reservationDate = reservationDate;
		}
		public String getArrival() {
			return arrival;
		}
		public void setArrival(String arrival) {
			this.arrival = arrival;
		}
		public int getUseMileage() {
			return useMileage;
		}
		public void setUseMileage(int useMileage) {
			this.useMileage = useMileage;
		}
		public int getSavingMileage() {
			return savingMileage;
		}
		public void setSavingMileage(int savingMileage) {
			this.savingMileage = savingMileage;
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public int getSeatNo() {
			return seatNo;
		}
		public void setSeatNo(int seatNo) {
			this.seatNo = seatNo;
		}
		public String getTimeCode() {
			return timeCode;
		}
		public void setTimeCode(String timeCode) {
			this.timeCode = timeCode;
		}
		public String getRouteNo() {
			return routeNo;
		}
		public void setRouteNo(String routeNo) {
			this.routeNo = routeNo;
		}
		public int getNormalFee() {
			return normalFee;
		}
		public void setNormalFee(int normalFee) {
			this.normalFee = normalFee;
		}
		public int getDistance() {
			return distance;
		}
		public void setDistance(int distance) {
			this.distance = distance;
		}
		public String getRequiredTime() {
			return requiredTime;
		}
		public void setRequiredTime(String requiredTime) {
			this.requiredTime = requiredTime;
		}
		public int getBusNo() {
			return busNo;
		}
		public void setBusNo(int busNo) {
			this.busNo = busNo;
		}
		@Override
		public String toString() {
			return "번호 : " + rowNum +", 예약번호 : " + reserveNo + ", 도착지 : " + arrival + ", 출발 시간 : " + startTime +  ", 좌석 번호 : " + seatNo + ", 요금 : " + normalFee;
		}
		

}
