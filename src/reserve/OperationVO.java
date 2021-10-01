package reserve;

public class OperationVO {
	private String timeCode;
	private String time;
	public OperationVO() {
	}

	public OperationVO(String timeCode) {
		this.timeCode = timeCode;
	}

	public OperationVO(String timeCode, String time) {
		this.timeCode = timeCode;
		this.time = time;
	}
	public String getTimeCode() {
		return timeCode;
	}

	public void setTimeCode(String timeCode) {
		this.timeCode = timeCode;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "출발 시간: " + time;
	}
	
}
