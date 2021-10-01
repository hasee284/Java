package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import oracle.jdbc.driver.OracleDriver;
import timeTable.vo.ScheduleDestinationVo;
import timeTable.vo.ScheduleVO;

public class ScheduleDestinationDao {
	public List<ScheduleDestinationVo> getScheduleList(String searchWord) throws SQLException{
		DriverManager.registerDriver(new OracleDriver());
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@112.220.114.130:1521:xe","team5_20210809s","java");
		Statement statement = connection.createStatement();
//		PreparedStatement statement = connection.prepareStatement("SELECT CODE, NO, TIME FROM ROUTE");
//		statement.setString(0, null);
		ResultSet resultSet = statement.executeQuery("SELECT ROUTE_NO, ARRIVAL_SPOT, NORMAL_FEE, TRUNC((NORMAL_FEE/2),-2), DISTANCE, REQUIRED_TIME FROM ROUTE WHERE ARRIVAL_SPOT = "+"'"+searchWord+"'");
	    List<ScheduleDestinationVo> list = new ArrayList<ScheduleDestinationVo>();
	    while (resultSet.next()) {
	    	String routeNo = resultSet.getString("route_no");
	        String arrivalSpot = resultSet.getString("arrival_spot");
	        int time = resultSet.getInt("normal_fee");
	        int timechild = resultSet.getInt("TRUNC((NORMAL_FEE/2),-2)");
	        int distance = resultSet.getInt("distance");
	        String requiredTime = resultSet.getString("required_time");
	        list.add(new ScheduleDestinationVo(routeNo,arrivalSpot,time,timechild,distance,requiredTime));
	    }
		resultSet.close(); 
		statement.close();
		connection.close();
		return list;

	}

	public List<ScheduleVO> getSchedule(String searchRouteNo) throws SQLException {
		DriverManager.registerDriver(new OracleDriver());
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@112.220.114.130:1521:xe","team5_20210809s","java");
		String sql = "SELECT";
		sql += "    a.time,";
		sql += "    b.name com_name,";
		sql += "    45 - (select count(*) from reservation where route_no = ? and start_time = a.time) remain_seat";
		sql += " FROM";
		sql += "    operation a";
		sql += "    LEFT OUTER JOIN bcompany b";
		sql += "       ON a.com_no = b.com_no";
		sql += " WHERE";
		sql += "    route_no = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, searchRouteNo);
		statement.setString(2, searchRouteNo);
		ResultSet resultSet = statement.executeQuery();
		List<ScheduleVO> list = new ArrayList<ScheduleVO>();
		while (resultSet.next()) {
			String startTime = resultSet.getString("time");
			String companyName = resultSet.getString("com_name");
			int remainSeat = resultSet.getInt("remain_seat");
			list.add(new ScheduleVO(startTime, companyName, remainSeat));
		}
		resultSet.close();
		statement.close();
		connection.close();
		return list;
	}

}