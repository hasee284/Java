package reservationChange;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ReservationDAO {
	
	private String url = "jdbc:oracle:thin:@112.220.114.130:1521:xe";
	private String forName = "oracle.jdbc.driver.OracleDriver";
	private String userId = "team5_20210809s";
	private String ps = "java";

	private static ReservationDAO instance;

	public static ReservationDAO getInstance() {
		if (instance == null) {
			instance = new ReservationDAO();
		}
		return instance;
	}

	private ReservationDAO() {

	}

	public List<ReservationVO> getScheduleList(String searchWord) throws SQLException, ClassNotFoundException {
		ArrayList<ReservationVO> list = new ArrayList<ReservationVO>();
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection(url, userId, ps);
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(
				"SELECT ROUTE_NO, ARRIVAL_SPOT, NORMAL_FEE, DISTANCE, REQUIRED_TIME FROM ROUTE WHERE ARRIVAL_SPOT = "+"'"+searchWord+"'");

		while (resultSet.next()) {
			int routeNo = resultSet.getInt("ROUTE_NO");
			String arrival = resultSet.getString("ARRIVAL_SPOT");
			int normalFee = resultSet.getInt("NORMAL_FEE");
			int distance = resultSet.getInt("DISTANCE");
			String requiredTime = resultSet.getString("REQUIRED_TIME");
			list.add(new ReservationVO(routeNo, arrival, normalFee, distance, requiredTime));
		}

		resultSet.close();
		statement.close();
		connection.close();
		return list;
	}

	public List<ReservationVO> reservationInquiry(String id) throws SQLException, ClassNotFoundException {
		ArrayList<ReservationVO> list = new ArrayList<ReservationVO>();
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection(url, userId, ps);
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(
	            "SELECT A.RONUM, B.RESERVE_NO, B.START_TIME, B.TOTAL_FEE, B.SEAT_NO, C.ARRIVAL_SPOT"
	            + " FROM reservation B"
	            + " LEFT OUTER JOIN (SELECT ROW_NUMBER() OVER(ORDER BY RESERVE_NO) as RONUM, RESERVE_NO, ID FROM RESERVATION where id = '"+id+"') A on (A.RESERVE_NO = B.RESERVE_NO)"
	            + " LEFT OUTER JOIN ROUTE C ON(B.ROUTE_NO=C.ROUTE_NO) WHERE A.ID='"+id+"' and a.reserve_no not in (select reserve_no from payment)"
	            + " order by a.ronum");

		while (resultSet.next()) {
			int rowNum = resultSet.getInt(1);
			long reserveNo = resultSet.getLong(2);
			String startTime = resultSet.getString(3);
			int seatNo = resultSet.getInt(5);
			String arrival = resultSet.getString(6);
			int normalFee = resultSet.getInt(4);
			list.add(new ReservationVO(rowNum, reserveNo, startTime, seatNo, arrival, normalFee));
		}
		
		resultSet.close();
		statement.close();
		connection.close();
		return list;
	}

	
	public int reservationCancel(ReservationVO delete) throws ClassNotFoundException, SQLException {
		String sql = "delete from reservation c"
	            + "   where c.reserve_no=("
	            + "   SELECT"
	            + "    b.reserve_no"
	            + "   from reservation b, (SELECT ROW_NUMBER() OVER(ORDER BY RESERVE_NO) as ronum, RESERVE_NO, ID"
	            + "                    FROM RESERVATION a"
	            + "                    where id = ?"
	            + "                    and a.reserve_no not in (select reserve_no from payment)) a"
	            + "   where a.reserve_no=b.reserve_no"
	            + "   and a.ronum=?"
	            + ")";
		Class.forName(forName);
		Connection connection = DriverManager.getConnection(url, userId, ps);
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, delete.getId());
		statement.setLong(2, delete.getRowNum());
		int executeUpdate = statement.executeUpdate();
		statement.close();
		connection.close();
		return executeUpdate;
	}


}
