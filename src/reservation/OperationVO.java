package reservation;

public class OperationVO {
	private String timeCode;
	private String opTime;
	public OperationVO() {
	}

	public OperationVO(String timeCode) {
		this.timeCode = timeCode;
	}

	public OperationVO(String timeCode, String time) {
		this.timeCode = timeCode;
		this.opTime = time;
	}
	public String getTimeCode() {
		return timeCode;
	}

	public void setTimeCode(String timeCode) {
		this.timeCode = timeCode;
	}

	public String getTime() {
		return opTime;
	}

	public void setTime(String time) {
		this.opTime = time;
	}

	@Override
	public String toString() {
		return "출발 시간: \t" + opTime;
	}
	
}
