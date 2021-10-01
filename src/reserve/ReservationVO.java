package reserve;

public class ReservationVO {
	private int reserveNo;
	private String startTime;
	private int adultTk ;
	private int childTk;
	private String memId;
	private int seatNo;
	private String timeCode;
	private String routeNo;
	private int totalFee;
	
	public ReservationVO() {
		super();
	}
	
	public ReservationVO(int adultTk) {
		super();
		this.adultTk = adultTk;
	}

	public ReservationVO(String startTime) {
		super();
		this.startTime = startTime;
	}

	public int getReserveNo() {
		return reserveNo;
	}
	public void setReserveNo(int reserveNo) {
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
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
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
	public int getTotalFee() {
		return totalFee;
	}
	public void setTotalFee(int totalFee) {
		this.totalFee = totalFee;
	}

	@Override
	public String toString() {
		return null;
	}
	
}