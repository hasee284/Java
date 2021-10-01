package reserve;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import oracle.jdbc.driver.OracleDriver;

public class ReservationDAO {
	private String url = "jdbc:oracle:thin:@112.220.114.130";
	private String id = "team5_20210809s";
	private String pw = "java";
	
	private static ReservationDAO instance;
	public static ReservationDAO getInstance() {
		if (instance == null) {
			instance = new ReservationDAO();
		}
		return instance;
	}
	private ReservationDAO() {}
	
	public List<RouteVO> getArrivalSpotList() throws Exception {
		String sql = "SELECT ROUTE_NO, ARRIVAL_SPOT FROM ROUTE";
		DriverManager.registerDriver(new OracleDriver());
		Connection connection = DriverManager.getConnection(url,id,pw);
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();
		ArrayList<RouteVO> list = new ArrayList<>();
		while(resultSet.next()) {
			String routeNo = resultSet.getString("route_no");
			String arrivalSpot = resultSet.getString("arrival_spot");
			list.add(new RouteVO(routeNo,arrivalSpot));
		}
		resultSet.close();
		statement.close();
		connection.close();
		return list;
	}
	public List<OperationVO> getTimeList(String routeNo) throws Exception {
		String sql = "SELECT B.TIME_CODE,B.TIME FROM ROUTE A, OPERATION B WHERE A.ROUTE_NO = B.ROUTE_NO AND A.ROUTE_NO = '"+routeNo+"'";
		DriverManager.registerDriver(new OracleDriver());
		Connection connection = DriverManager.getConnection(url,id,pw);
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();
		ArrayList<OperationVO> list = new ArrayList<>();
		while(resultSet.next()) {
			String timeCode = resultSet.getString("time_code");
			String time = resultSet.getString("time");
			list.add(new OperationVO(timeCode, time));
		}
		resultSet.close();
		statement.close();
		connection.close();
		return list;
	}
	public int getTicket(String routeNo) throws Exception {
		String sql = "SELECT NORMAL_FEE FROM ROUTE WHERE ROUTE_NO = '"+routeNo+"'";
		DriverManager.registerDriver(new OracleDriver());
		Connection connection = DriverManager.getConnection(url,id,pw);
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();
//		RouteVO vo = null;
		int normalFee = 0;
		if (resultSet.next()) {
			normalFee = resultSet.getInt(1);
//			vo = new RouteVO();
		}
		resultSet.close();
		statement.close();
		connection.close();
		return normalFee;
	}
	
	
	//성인표 insert
	public int insertAdultReservation(ReservationVO vo) throws Exception {
		String sql = "INSERT INTO RESERVATION "
				+ "(RESERVE_NO, START_TIME, ADULT_TK, ID, SEAT_NO, TIME_CODE, ROUTE_NO, TOTAL_FEE) "
				+ "VALUES (TO_NUMBER(TO_CHAR(SYSDATE, 'YYYYMMDD')||LPAD(?,3,'0')||?||SEQ_RESERVE_2.NEXTVAL),?,?,?,?,?,?,?)";
		DriverManager.registerDriver(new OracleDriver());
		Connection connection = DriverManager.getConnection(url,id,pw);
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, vo.getRouteNo());
		statement.setString(2, vo.getTimeCode());
		statement.setString(3, vo.getStartTime());
		statement.setInt(4, vo.getAdultTk());
		statement.setString(5, vo.getMemId());
		statement.setInt(6, vo.getSeatNo());
		statement.setString(7, vo.getTimeCode());
		statement.setString(8, vo.getRouteNo());
		statement.setInt(9, vo.getTotalFee());
		int executeUpdate = statement.executeUpdate();
		statement.close();
		connection.close();
		return executeUpdate;
	}
	
	//아동표 insert
	public int insertChildReservation(ReservationVO vo) throws Exception {
		String sql = "INSERT INTO RESERVATION "
				+ "(RESERVE_NO, START_TIME, CHILD_TK, ID, SEAT_NO, TIME_CODE, ROUTE_NO, TOTAL_FEE) "
				+ "VALUES (TO_NUMBER(TO_CHAR(SYSDATE, 'YYYYMMDD')||LPAD(?,3,'0')||?||SEQ_RESERVE_2.NEXTVAL),?,?,?,?,?,?,?)";
		DriverManager.registerDriver(new OracleDriver());
		Connection connection = DriverManager.getConnection(url,id,pw);
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, vo.getRouteNo());
		statement.setString(2, vo.getTimeCode());
		statement.setString(3, vo.getStartTime());
		statement.setInt(4, vo.getChildTk());
		statement.setString(5, vo.getMemId());
		statement.setInt(6, vo.getSeatNo());
		statement.setString(7, vo.getTimeCode());
		statement.setString(8, vo.getRouteNo());
		statement.setInt(9, vo.getTotalFee());
		int executeUpdate = statement.executeUpdate();
		statement.close();
		connection.close();
		return executeUpdate;
	}
	
	
}