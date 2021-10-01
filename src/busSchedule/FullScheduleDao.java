package busSchedule;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FullScheduleDao {
	private String url = "jdbc:oracle:thin:@112.220.114.130:1521:xe";
	private String forName = "oracle.jdbc.driver.OracleDriver";
	private String id = "team5_20210809s";
	private String ps = "java";
	
	private static FullScheduleDao instance;
//	FullScheduleVO vo = new FullScheduleVO();
	
	public static FullScheduleDao getInstance() {
		if (instance == null) {
			instance = new FullScheduleDao();
		}
		return instance;
	}
	private FullScheduleDao() {}
	public List<FullScheduleVO> fullScheduleReturn(String input3) throws SQLException, ClassNotFoundException {
		String query = "SELECT ROW_NUMBER() OVER(ORDER BY times) as ronum, "
				+ " z.namess, z.times, z.spot, z.route, z.fee, z.childfee, z.distance, z.retime "
				+ " FROM (SELECT BO.CO_NAME namess, OP.OP_TIME times, "
				+ " RO.ARRIVAL_SPOT spot, RO.ROUTE_NO route, RO.NORMAL_FEE fee, "
				+ " TRUNC(RO.NORMAL_FEE/2,-2) childfee, RO.DISTANCE distance, RO.REQUIRED_TIME retime "
				+ " FROM ROUTE RO "
				+ " INNER JOIN OPERATION OP ON (RO.ROUTE_NO = OP.ROUTE_NO) "
				+ " INNER JOIN BCOMPANY BO ON (BO.COM_NO = OP.COM_NO) "
				+ " WHERE RO.ARRIVAL_SPOT = (select arrival_spot"
				+ "                                from route"
				+ "                                where route_no = "+ input3 +")"
				+ " ORDER BY OP.OP_TIME) Z";
		Class.forName(forName);
		Connection connection = DriverManager.getConnection(url,id,ps);
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(query);
		List<FullScheduleVO> list = new ArrayList<FullScheduleVO>();
		while (resultSet.next()) {
			int ronum = resultSet.getInt(1);
			String comName = resultSet.getString(2);
			String time = resultSet.getString(3);
			String arrival = resultSet.getString(4);
			String routeNum = resultSet.getString(5);
			int normalFee = resultSet.getInt(6);
			int childFee = resultSet.getInt(7);
			int distance = resultSet.getInt(8);
			String requiredTime = resultSet.getString(9);
		    list.add(new FullScheduleVO(ronum, comName, time, arrival,  routeNum, normalFee, childFee, distance, requiredTime));
			
		}
		resultSet.close();
		statement.close();
		connection.close();
		
		return list;
	}
//	public List<FullScheduleVO> fullScheduleReturn(int input4i) throws SQLException, ClassNotFoundException {
//		String query = " SELECT "
//				+ " Y.ronum, Y.na, Y.tis, Y.sps, Y.ros, Y.fes, Y.cfs, Y.dis, Y.rts "
//				+ " FROM "
//				+ " (SELECT ROW_NUMBER() OVER(ORDER BY times) as ronum, "
//				+ " z.namess na, z.times tis, z.spot sps, z.route ros, z.fee fes, z.childfee cfs, z.distance dis, z.retime rts "
//				+ " FROM (SELECT BO.CO_NAME namess, OP.OP_TIME times, "
//				+ " RO.ARRIVAL_SPOT spot, RO.ROUTE_NO route, RO.NORMAL_FEE fee, "
//				+ " TRUNC(RO.NORMAL_FEE/2,-2) childfee, RO.DISTANCE distance, RO.REQUIRED_TIME retime "
//				+ " FROM ROUTE RO "
//				+ " INNER JOIN OPERATION OP ON (RO.ROUTE_NO = OP.ROUTE_NO) "
//				+ " INNER JOIN BCOMPANY BO ON (BO.COM_NO = OP.COM_NO) "
//				+ " WHERE RO.ARRIVAL_SPOT = '" + vo.getArrival() + "'"
//				+ " ORDER BY OP.OP_TIME) Z) Y "
//				+ " WHERE Y.ronum = '" + input4i + "'";
//
//		Class.forName(forName);
//		Connection connection = DriverManager.getConnection(url,id,ps);
//		Statement statement = connection.createStatement();
//		ResultSet resultSet = statement.executeQuery(query);
//		List<FullScheduleVO> list = new ArrayList<FullScheduleVO>();
//		while (resultSet.next()) {
//			int ronum = resultSet.getInt(1);
//			String comName = resultSet.getString(2);
//			String time = resultSet.getString(3);
//			String arrival = resultSet.getString(4);
//			String routeNum = resultSet.getString(5);
//			int normalFee = resultSet.getInt(6);
//			int childFee = resultSet.getInt(7);
//			int distance = resultSet.getInt(8);
//			String requiredTime = resultSet.getString(9);
//		    list.add(new FullScheduleVO(ronum, comName, time, arrival,  routeNum, normalFee, childFee, distance, requiredTime));
//			
//		}
//		resultSet.close();
//		statement.close();
//		connection.close();
//
//		return list;
//	} //필요가없다....
}
