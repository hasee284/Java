package join;

public class UserVO {
	private String memId;
	private String memName;
	private String memPw;
	private int memAge;
	private String memAddress;
	private String memMail;
	private String memPhone;
	private int memMileage;
	private int memBalance;
	
	public UserVO() {
	}

	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public String getMemName() {
		return memName;
	}
	public void setMemName(String memName) {
		this.memName = memName;
	}
	public String getMemPw() {
		return memPw;
	}
	public void setMemPw(String memPw) {
		this.memPw = memPw;
	}
	public int getMemAge() {
		return memAge;
	}
	public void setMemAge(int memAge) {
		this.memAge = memAge;
	}
	public String getMemAddress() {
		return memAddress;
	}
	public void setMemAddress(String memAddress) {
		this.memAddress = memAddress;
	}
	public String getMemMail() {
		return memMail;
	}
	public void setMemMail(String memMail) {
		this.memMail = memMail;
	}
	public String getMemPhone() {
		return memPhone;
	}
	public void setMemPhone(String memPhone) {
		this.memPhone = memPhone;
	}
	public int getMemMileage() {
		return memMileage;
	}
	public void setMemMileage(int memMileage) {
		this.memMileage = memMileage;
	}
	public int getMemBalance() {
		return memBalance;
	}
	public void setMemBalance(int memBalance) {
		this.memBalance = memBalance;
	}
	@Override
	public String toString() {
		return "MemberVO [memId=" + memId + ", memName=" + memName + ", memPw=" + memPw + ", memAge=" + memAge
				+ ", memAddress=" + memAddress + ", memMail=" + memMail + ", memPhone=" + memPhone + ", memMileage="
				+ memMileage + ", memBalance=" + memBalance + "]";
	}

}