package myPage;

public class MypageVO {
	private String id;
	private String name;
	private String pwd;
	private int age;
	private String address;
	private String mail;
	private String phone;
	private String mileage;
	private int balance;
	private int recharge;
	
	
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


	public String getMileage() {
		return mileage;
	}


	public void setMileage(String mileage) {
		this.mileage = mileage;
	}


	public int getBalance() {
		return balance;
	}


	public void setBalance(int balance) {
		this.balance = balance;
	}


	public int getRecharge() {
		return recharge;
	}


	public void setRecharge(int recharge) {
		this.recharge = recharge;
	}


	@Override
	public String toString() {
		return "MypageVO [id=" + id + ", name=" + name + ", age=" + age + ", address=" + address
				+ ", mail=" + mail + ", phone=" + phone + ", mileage=" + mileage + ", balance=" + balance + "]";
	}
//	public String infoString() {
//		return "MypageVO [id=" + id + ", name=" + name + ", age=" + age + ", address=" + address
//				+ ", mail=" + mail + ", phone=" + phone + ", mileage=" + mileage + ", balance=" + balance + "]";
//	}
}
