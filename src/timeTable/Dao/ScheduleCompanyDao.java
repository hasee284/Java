package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import oracle.jdbc.driver.OracleDriver;
import vo.ScheduleCompanyVo;

public class ScheduleCompanyDao {
	public List<ScheduleCompanyVo> getScheduleList(String searchWord)throws Exception{
		DriverManager.registerDriver(new OracleDriver());
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@112.220.114.130:1521:xe","team5_20210809s","java");
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("SELECT COM_NO, NAME FROM BCOMPANY where com_no = ?");
		List<ScheduleCompanyVo> list = new ArrayList<ScheduleCompanyVo>();
		while (resultSet.next()) {
			int comNO = resultSet.getInt("comNo");
			String name = resultSet.getString("name");
			list.add(new ScheduleCompanyVo(comNO,name));
		}
		resultSet.close();
		statement.close();
		connection.close();
		return list;

	}

}
