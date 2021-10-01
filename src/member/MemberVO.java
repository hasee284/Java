package member;

import java.util.Objects;

public class MemberVO {
	private String id;
	private String name;
	private String pwd;
	private int age;
	private String address;
	private String mail;
	private String phone;
	private int mileage;
	private int balance;
	private int inputNoticeMenu;
	private int recharge;
	
	public MemberVO() {
	}
	
	public MemberVO(String id, String pwd) {
		super();
		this.id = id;
		this.pwd = pwd;
	}
	
	public MemberVO(String address, String mail, String phone) {
		super();
		this.address = address;
		this.mail = mail;
		this.phone = phone;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getMileage() {
		return mileage;
	}
	public void setMileage(int mileage) {
		this.mileage = mileage;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public int getInputNoticeMenu() {
		return inputNoticeMenu;
	}
	public void setInputNoticeMenu(int inputNoticeMenu) {
		this.inputNoticeMenu = inputNoticeMenu;
	}
	public int getRecharge() {
		return recharge;
	}
	public void setRecharge(int recharge) {
		this.recharge = recharge;
	}
	@Override
	public String toString() {
		return String.format("회원명 : %s, 나이 : %d, 전화번호 : %s, 이메일주소 : %s\n주소 : %s, 마일리지 : %,d, 잔액 : %,d", getName(), getAge(), getPhone(), getMail(), getAddress(), getMileage(), getBalance());
	}
	@Override
	public int hashCode() {
		return Objects.hash(id, pwd);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MemberVO other = (MemberVO) obj;
		return Objects.equals(id, other.id) && Objects.equals(pwd, other.pwd);
	}
	
}
