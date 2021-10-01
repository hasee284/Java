package vo;

public class ScheduleDestinationVo {
	   private String routeNo;
	   private String arrivalSpot;
	   private int time;
	   private int timechild;
	   private int distance;
	   private String requiredTime;
	   
	   public ScheduleDestinationVo() {
	      
	   }

	   public ScheduleDestinationVo(String routeNo, String arrivalSpot, int time, int timechild, int distance, String requiredTime) {
	      this.routeNo = routeNo;
	      this.arrivalSpot = arrivalSpot;
	      this.time = time;
	      this.timechild = timechild;
	      this.distance = distance;
	      this.requiredTime = requiredTime;
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

	   public int getTime() {
	      return time;
	   }

	   public void setTime(int time) {
	      this.time = time;
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
	   
	   
	   public int getTimechild() {
	      return timechild;
	   }

	   public void setTimechild(int timechild) {
	      this.timechild = timechild;
	   }

	   @Override
	   public String toString() {
	      return String.format("버스번호=%4s번\t도착지=%s\t어른요금=%,d원\t어린이요금=%,d원\t거리=%,dkm\t소요시간=%s분", routeNo, arrivalSpot, time, timechild, distance, requiredTime);
	   }

	   

	   
	}