package vo;

public class ScheduleVO {
	private String startTime;
	private String companyName;
	private int remainSeat;
	
	public ScheduleVO(String startTime, String companyName, int remainSeat) {
		super();
		this.startTime = startTime;
		this.companyName = companyName;
		this.remainSeat = remainSeat;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public int getRemainSeat() {
		return remainSeat;
	}
	public void setRemainSeat(int remainSeat) {
		this.remainSeat = remainSeat;
	}
	@Override
	public String toString() {
		return String.format("출발시간:%5s\t회사:%15s\t잔여석:%d", startTime, companyName, remainSeat);
	}
	
}
