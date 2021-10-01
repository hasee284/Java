package vo;

public class ScheduleCompanyVo {
	private int comNo;
	private String name;

	public ScheduleCompanyVo() {

	}

	public ScheduleCompanyVo(int comNo, String name) {
		this.comNo = comNo;
		this.name = name;

	}

	public int getComNo() {
		return comNo;
	}

	public void setComNo(int comNo) {
		this.comNo = comNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "ScheduleCompanyVo [comNo=" + comNo + ", name=" + name + "]";
	}

}
