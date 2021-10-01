package Dao;

public class ScheduleGradeDao {
	private ScheduleGradeDao() {
	}

	private static ScheduleGradeDao instance;

	public static ScheduleGradeDao getInstance() {
		if (instance == null) {
			instance = new ScheduleGradeDao();
		}
		return instance;

	}

}
