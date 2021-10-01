package reservation;

public class RouteVO {
	private String routeNo;
	private String arrivalSpot;
	private int normalFee;
	private int distance;
	private String requiredTime;
	public RouteVO() {
	}
	
	public RouteVO(int normalFee) {
		this.normalFee = normalFee;
	}

	public RouteVO(String routeNo, String arrivalSpot) {
		super();
		this.routeNo = routeNo;
		this.arrivalSpot = arrivalSpot;
	}

	public String getRouteNo() {
		return routeNo;
	}
	public void setRouteNo(String routeNo) {
		this.routeNo = routeNo;
	}
	public String getArrivalSpot() {
		return arrivalSpot;
	}
	public void setArrivalSpot(String arrivalSpot) {
		this.arrivalSpot = arrivalSpot;
	}
	public int getNormalFee() {
		return normalFee;
	}
	public void setNormalFee(int normalFee) {
		this.normalFee = normalFee;
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
		return "노선번호 : " + routeNo + ",\t 도착지명 : " + arrivalSpot;
	}
	
}