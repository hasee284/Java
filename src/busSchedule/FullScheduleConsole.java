package busSchedule;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import packageMain.Menu;
import reservation.ReservationService;

public class FullScheduleConsole {
	Scanner scn = new Scanner(System.in);
	private FullScheduleVO vo = new FullScheduleVO();
	private FullScheduleController con = FullScheduleController.getInstance();
	private static FullScheduleConsole instance;
	public static FullScheduleConsole getInstance() {
		if (instance == null) {
			instance = new FullScheduleConsole();
		}
		return instance;
	}
	
	
	public static void main(String[] args){
		new FullScheduleConsole().timeTable();
	}
		
	public int timeTable() {
		
		boolean run = true;
		
		while (run) {
			
				System.out.println("--------------------------");
				System.out.println("시간표 조회");
				System.out.println("--------------------------");
				System.out.println("1.조회하기,\t2.이전 화면");
				System.out.println("--------------------------");
				System.out.print("> ");
				int select = Integer.parseInt(scn.nextLine());
	
				String fullScheduleTime = null;
				String fullSchedulenum = null;
				switch (select) {
				case 1:
					System.out.println("도착지를 입력해 주세요.");
					System.out.println("----------------------------------------------------------");
				    System.out.println("[1]서울경부 	[2]광주 		[3]부산 		[4]동서울");
				    System.out.println("[5]전주		[6]동대구		[7]인천 		[8]강릉");
				    System.out.println("[9]당진 		[10]당진기지시	[11]상봉		[12]서대구");
				    System.out.println("[13]서산 		[14]전주호남제일문	[15]천안		[16]태안");
				    System.out.println("[17]포항 		[18]횡성하행 	[19]성남 		[20]김천");
				    System.out.println("----------------------------------------------------------");
					System.out.print("> ");
					
					List<FullScheduleVO> list1 = null;
					try {
						String input3= scn.nextLine();
						vo.setArrival(input3);
						list1 = con.fullScheduleReturn(input3);
					} catch (ClassNotFoundException e) {
						System.out.println("다시 선택해주세요.");
						System.out.println("===============");
						return Menu.TIMETABLE;
					} catch (SQLException e) {
						System.out.println("다시 선택해주세요.");
						System.out.println("===============");
						return Menu.TIMETABLE;
					} catch (NumberFormatException e) {
						System.out.println("다시 선택해주세요.");
						System.out.println("===============");
						return Menu.TIMETABLE;
					}//예약번호 받기(로그인한 아이디를 바탕으로)
					for (FullScheduleVO vo1 : list1) {
						System.out.println(vo1);
						System.out.println("------------------------------------------------------------------------");
					}
					
					System.out.println("[노선번호: 1~20번(일반), 101~116번(우등)]");
					System.out.println(" ๑◕‿‿◕๑  ๑◕‿‿◕๑  ๑◕‿‿◕๑  ๑◕‿‿◕๑ \n");
					System.out.println("원하시는 순번을 입력해 주세요.");
					System.out.print(">> ");
					String input4= scn.nextLine();
					int input4i = Integer.parseInt(input4);
					vo.setRonum(input4i);
					System.out.println("------------------------------------------------------------------------");
					System.out.println(list1.get(input4i-1));
					
					fullScheduleTime = list1.get(input4i-1).getTime();

					fullSchedulenum = list1.get(input4i-1).getRouteNum();

			
					boolean input5b = true; 	
					while(input5b) {
						System.out.println("------------------------------------------------------------------------");
						System.out.println("티켓 예매를 하시겠습니까? ");
						System.out.println("1.YES 2.NO");
						System.out.print(">> ");
						String input5= scn.nextLine();
						int input5i = Integer.parseInt(input5);
							
								switch (input5i) {
								case 1:
									System.out.println("예매로 이동합니다.");
									ReservationService reserser = ReservationService.getInstance();
									reserser.resrv2(fullScheduleTime, fullSchedulenum);
									input5b=false;
									return Menu.MAINMENU;
								case 2:	
									System.out.println("메인 메뉴로 이동합니다.");
									input5b=false;
									break;
								default:
									System.out.println("1~2번의 메뉴를 선택해 주세요");
									break;	
								}//switch end
							}//while end
					run = false;
					break;
					
				case 2:
					System.out.println("시간표 조회를 취소합니다.");
					run = false;
					break;	
					
				default:
					System.out.println("1~2번의 메뉴를 선택해 주세요");
					break;
				}//switch end
			
		}	//while end
	return 0;
 }// main end	
} // class end
