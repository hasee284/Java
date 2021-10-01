package packageVO;

public class MemberVO {
	private String memId;
	private String memPw;
	private String memName;
	private String memHp;
	private int memAge;
	private int memMileage;
	
	public MemberVO(String memId, String memPw, String memName, String memHp, int memAge) {
		this.memId = memId;
		this.memPw = memPw;
		this.memName = memName;
		this.memHp = memHp;
		this.memAge = memAge;
		this.memMileage = 0;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getMemPw() {
		return memPw;
	}

	public void setMemPw(String memPw) {
		this.memPw = memPw;
	}

	public String getMemName() {
		return memName;
	}

	public void setMemName(String memName) {
		this.memName = memName;
	}

	public String getMemHp() {
		return memHp;
	}

	public void setMemHp(String memHp) {
		this.memHp = memHp;
	}

	public int getMemAge() {
		return memAge;
	}

	public void setMemAge(int memAge) {
		this.memAge = memAge;
	}

	public int getMemMileage() {
		return memMileage;
	}

	public void setMemMileage(int memMileage) {
		this.memMileage = memMileage;
	}

	@Override
	public String toString() {
		return "회원정보\n아이디 : " + memId + ", 성명 : " + memName + ", 전화번호 : " + memHp + "\n나이 : " + memAge + ", 마일리지 : " + memMileage;
	}
	
}
