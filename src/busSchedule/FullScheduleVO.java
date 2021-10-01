package busSchedule;

public class FullScheduleVO {
	int ronum;//순번
	String DeDate;//사용자출발시간 user
	int comNo;//회사 bcompany
	String comName;//회사이름 bcompany
	String timeCode;//10시 11시 등 operation
	String time;// 실제 출발 시간(시+분) operation
	String Arrival;//도착지 route
	String routeNum;//노선번호 route
	int normalFee;//정규요금 route
	int childFee;//어린이요금 route(1/2)
	int distance;//거리 route
	String requiredTime;//총소모시간 route
	public FullScheduleVO() {
	}
	public FullScheduleVO(int ronum, String comName, String time, String arrival, String routeNum, int normalFee, 
						  int childFee, int distance, String requiredTime) {
		this.ronum = ronum;
		this.comName = comName;
		this.time = time;
		this.Arrival = arrival;
		this.routeNum = routeNum;
		this.normalFee = normalFee;
		this.childFee = childFee;
		this.distance = distance;
		this.requiredTime = requiredTime;
	}
	
	public int getRonum() {
		return ronum;
	}
	public void setRonum(int ronum) {
		this.ronum = ronum;
	}
	public String getDeDate() {
		return DeDate;
	}
	public void setDeDate(String deDate) {
		DeDate = deDate;
	}
	public int getComNo() {
		return comNo;
	}
	public void setComNo(int comNo) {
		this.comNo = comNo;
	}
	public String getComName() {
		return comName;
	}
	public void setComName(String comName) {
		this.comName = comName;
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
	public String getArrival() {
		return Arrival;
	}
	public void setArrival(String arrival) {
		Arrival = arrival;
	}
	public String getRouteNum() {
		return routeNum;
	}
	public void setRouteNum(String routeNum) {
		this.routeNum = routeNum;
	}
	public int getNormalFee() {
		return normalFee;
	}
	public void setNormalFee(int normalFee) {
		this.normalFee = normalFee;
	}
	public int getChildFee() {
		return childFee;
	}
	public void setChildFee(int childFee) {
		this.childFee = childFee;
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
	@Override
	public String toString() {
		return String.format("순번[%d]\t 회사명:%S,\t 출발시간:%S,\t 도착지:%S,\t 노선번호:%s\n\t 정규요금:%,5d원, 어린이요금:%,5d원, 거리:%dkm,\t 소요시간:%s시간", 
				ronum,comName,time,Arrival,routeNum,normalFee,childFee,distance,requiredTime);
		
//		return "순번["+ ronum + "]\t 회사명:" + comName + ",\t 출발시간:" + time + ",\t 도착지:" + Arrival + ",\t 노선번호:"
//				+ routeNum + "\n\t 정규요금:" + normalFee + ",\t 어린이요금:" + childFee + ",\t 거리:" + distance + "km"
//				+ ",\t 소요시간:" + requiredTime + "시간";
	}
	
	
	
	

}
