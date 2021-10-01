package payment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import packageMain.Database;

public class PaymentDao {
	private String url = "jdbc:oracle:thin:@112.220.114.130:1521:xe";
	private String forName = "oracle.jdbc.driver.OracleDriver";
	private String id = "team5_20210809s";
	private String ps = "java";

	private static PaymentDao instance;
	public static PaymentDao getInstance() {
		if (instance == null) {
			instance = new PaymentDao();
		}
		return instance;
	}
	
	private PaymentVO vo = Database.getPaymentSession();
	
	private PaymentDao() {}
	
	public List<PaymentVO> checkReservation(int reserveNo) throws SQLException, ClassNotFoundException {
		Class.forName(forName);
		Connection connection = DriverManager.getConnection(url,id,ps);
		Statement statement = connection.createStatement();

		ResultSet resultSet = statement.executeQuery("SELECT RESERVE_NO, ADULT_TK, CHILD_TK, TIME_CODE, ROUTE_NO from reservation where RESERVE_NO = '"+reserveNo+"'");
		List<PaymentVO> list = new ArrayList<PaymentVO>();
		while (resultSet.next()) {
			int reserve_no = resultSet.getInt("RESERVE_NO");
			int adult_tk = resultSet.getInt("ADULT_TK");
			int child_tk = resultSet.getInt("CHILD_TK");
			String time_code = resultSet.getString("TIME_CODE");
			String arrivalSpot = resultSet.getString("ROUTE_NO");
		    list.add(new PaymentVO(reserve_no,adult_tk,child_tk,time_code,arrivalSpot));
			
		}
		resultSet.close();
		statement.close();
		connection.close();
		
		return list;
	}

	public int useBalance(PaymentVO vo2) throws SQLException, ClassNotFoundException {
		String sql = "update member set BALANCE = BALANCE-? where id IN (SELECT ID FROM (SELECT ROW_NUMBER() OVER(ORDER BY RESERVE_NO) as ronum, RESERVE_NO, ID FROM RESERVATION where id = ?))";
//		PaymentVO vo =  PaymentVO.getInstance();
		
		Class.forName(forName);
		Connection connection = DriverManager.getConnection(url,id,ps);
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, vo.getTotalfee());
		statement.setString(2, vo.getId());
		int executeUpdate = statement.executeUpdate();
		statement.close();
		connection.close();
		return executeUpdate;
	}

	public int checkBalance(PaymentVO vo) throws SQLException, ClassNotFoundException {
//		PaymentVO vo1 =  PaymentVO.getInstance();
		int finalresult = 0;
		Class.forName(forName);
		Connection connection = DriverManager.getConnection(url,id,ps);
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("SELECT BALANCE FROM MEMBER WHERE ID IN (SELECT ID FROM (SELECT ROW_NUMBER() OVER(ORDER BY RESERVE_NO) as ronum, RESERVE_NO, ID FROM RESERVATION where id = '"+vo.getId()+"'))");		
		while(resultSet.next()) {
			finalresult = resultSet.getInt(1); 
			vo.setBALANCE(finalresult);
			//getInt(1)은 컬럼의 1번째 값을 Int형으로 가져온다. / getString(2)는 컬럼의 2번째 값을 String형으로 가져온다. 
			}
		resultSet.close();
		statement.close();
		connection.close();
		return finalresult;
	
	}

	public int autopay(int reserveNo) throws SQLException, ClassNotFoundException  {
//		PaymentVO vo2 =  Database.getPaymentSession();
		int result = 0;
		Class.forName(forName);
		Connection connection = DriverManager.getConnection(url,id,ps);
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("SELECT a.ronum, b.TOTAL_FEE from reservation b inner join (SELECT ROW_NUMBER() OVER(ORDER BY RESERVE_NO) as ronum, RESERVE_NO, ID FROM RESERVATION where id = '"+vo.getId()+"') a"
				+ " on (a.RESERVE_NO = b.RESERVE_NO) where a.ronum="+reserveNo);		
		while(resultSet.next()) {
			result = resultSet.getInt(2); 
			//getInt(1)은 컬럼의 1번째 값을 Int형으로 가져온다. / getString(2)는 컬럼의 2번째 값을 String형으로 가져온다. 
			}
		resultSet.close();
		statement.close();
		connection.close();
		return result;
	}

	public List<PaymentVO> checkReserNo(String user_id) throws SQLException, ClassNotFoundException {
		Class.forName(forName);
		Connection connection = DriverManager.getConnection(url,id,ps);
		Statement statement = connection.createStatement();
//		PaymentVO vo3 = PaymentVO.getInstance();
		vo.setId(user_id);
		
		ResultSet resultSet3 = statement.executeQuery("SELECT"
				+ "    distinct a.ronum,"
				+ "    b.RESERVE_NO,"
				+ "    b.ROUTE_NO,"
				+ "    b.TOTAL_FEE"
				+ "	from (SELECT ROW_NUMBER() OVER(ORDER BY RESERVE_NO) as ronum,"
				+ "                    RESERVE_NO,"
				+ "                    ID"
				+ "            FROM RESERVATION"
				+ "            where id = '" + user_id + "') a, reservation b, payment c"
				+ " where a.reserve_no=b.reserve_no"
				+ " and b.reserve_no not in (select reserve_no from payment) order by a.ronum");
		
		List<PaymentVO> list2 = new ArrayList<PaymentVO>();
		
		while (resultSet3.next()) {
			int ronum = resultSet3.getInt(1);
			long reserve_no = resultSet3.getLong(2);
			String arrivalSpot = resultSet3.getString(3);
			int total_fee = resultSet3.getInt(4);
		    list2.add(new PaymentVO(ronum,reserve_no,arrivalSpot,total_fee));
			
		}
		resultSet3.close();
		statement.close();
		connection.close();
		return list2;
	}
	
	public int insertPayment(PaymentVO vo) throws SQLException, ClassNotFoundException {
		String query = "insert into payment values(SEQ_PAYMENT_NO.NEXTVAL, (select reserve_no"
				+ " from (SELECT"
				+ "    distinct a.ronum,"
				+ "	b.RESERVE_NO,"
				+ "	b.ROUTE_NO,"
				+ "	b.TOTAL_FEE"
				+ " from (SELECT ROW_NUMBER() OVER(ORDER BY RESERVE_NO) as ronum,"
				+ "        RESERVE_NO,"
				+ "		ID"
				+ "    FROM RESERVATION"
				+ "	where id = ?) a, reservation b, payment c"
				+ " where a.reserve_no=b.reserve_no"
				+ " and b.reserve_no not in (select reserve_no from payment)"
				+ " order by a.ronum) a"
				+ " where a.ronum = ?), sysdate, 0, 0)";
		
		Class.forName(forName);
		Connection connection = DriverManager.getConnection(url,id,ps);
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setString(1, vo.getId());
		statement.setLong(2, vo.getReserve_no());
		int executeUpdate = statement.executeUpdate();
		statement.close();
		connection.close();
		return executeUpdate;
		
	}
	
}//main end