package myPage;

import java.sql.SQLException;
import java.util.Scanner;

import member.MemberVO;
import packageMain.Database;
import packageMain.Menu;

public class MypageConsole {
	Scanner scn = new Scanner(System.in);
	private MypageController ck = MypageController.getInstance();
	private MemberVO session = Database.getSession();
	private MypageService myPageService = MypageService.getInstance();
	private static MypageConsole instance;
	public static MypageConsole getInstance() {
		if (instance == null) {
			instance = new MypageConsole();
		}
		return instance;
	}
	
	
	public int service() {
		int userMenu = Menu.MYPAGE_HOME;
		boolean run = true;
		
		while (run) {
			switch (userMenu) {
			case Menu.MYPAGE_HOME:
				userMenu = home();
				break;
			case Menu.MYPAGE_INFO:
				userMenu = info();
				break;
			case Menu.MYPAGE_CHANGE:
				userMenu = change();
				break;
			case Menu.MYPAGE_CHARGE:
				userMenu = charge();
				break;
			case Menu.MYPAGE_WITHDRAWAL:
				userMenu = withdrawal();
				break;
			case Menu.MYPAGE_BACK:
				run = false;
				return Menu.MAINMENU;
			case Menu.EXIT:
				System.exit(0);
			}
		}
		return Menu.MAINMENU;
	}
	
	
	public int home() {
		int select = 0;
		try {
			System.out.println("────────────१✌˚◡˚✌५────────────१✌˚◡˚✌५────────────");
			System.out.println("[1]내 정보 조회, [2]내 정보 변경, [3]잔액 충전, [4]회원 탈퇴, [0]이전 화면");
			System.out.println("────────────१✌˚◡˚✌५────────────१✌˚◡˚✌५────────────");
			System.out.print("> ");
			select = Integer.parseInt(scn.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("다시 입력해주세요");
			return Menu.MYPAGE_HOME;
		}
		
		switch (select) {
		case 1:
			return Menu.MYPAGE_INFO;
		case 2:
			return Menu.MYPAGE_CHANGE;
		case 3:
			return Menu.MYPAGE_CHARGE;
		case 4:
			return Menu.MYPAGE_WITHDRAWAL;
		case 0:
			return Menu.MYPAGE_BACK;
		default:
			System.out.println("다시 입력해주세요.");
			System.out.println("==================");
			return Menu.MYPAGE_HOME;
		}
	}
	
	
		public int info() {
			System.out.println("회원님의 정보를 조회합니다.");
			MemberVO selectresult = ck.selectInfo(session);
			System.out.println(selectresult);
			return Menu.MYPAGE_HOME;
		}
		
		
		public int withdrawal() {
			System.out.println("회원에서 탈퇴합니다.");
			System.out.print("탈퇴하시려면 '탈퇴'를 입력해주세요.");
			System.out.println("> ");
			String deleteid = scn.next();
			scn.nextLine();
			if ("탈퇴".equals(deleteid)) {
				int result;
				try {
					result = ck.deleteInfo(session);
					if(result > 0) {
						System.out.println("");
						System.out.println("회원탈퇴에 성공했습니다.");
						System.out.println("프로그램을 종료합니다.");
						return Menu.EXIT;
					}
				} catch (ClassNotFoundException e) {
					System.out.println("회원탈퇴에 실패했습니다.");
					System.out.println("다시 시도해주세요.");
				} catch (SQLException e) {
					System.out.println("회원탈퇴에 실패했습니다.");
					System.out.println("다시 시도해주세요.");
				}
			}
			System.out.println("잘못 입력하셨습니다.");
			System.out.println("메인 메뉴로 돌아갑니다.");
			return Menu.MYPAGE_BACK;
		}
		
		
		public int change() {
			int select = 0;
				System.out.println("내 정보를 변경합니다.");
				try {
					session.setAddress(myPageService.importInfo(session).get(0).getAddress());
					session.setMail(myPageService.importInfo(session).get(0).getMail());
					session.setPhone(myPageService.importInfo(session).get(0).getPhone());
					System.out.println("변경하고 싶은 정보를 선택해주세요.");
					System.out.println("[1] 비밀번호");
					System.out.println("[2] 주소");
					System.out.println("[3] 이메일");
					System.out.println("[4] 전화번호");
					System.out.print("> ");
					select = Integer.parseInt(scn.nextLine());
				} catch (NumberFormatException e) {
					System.out.println("다시 입력해주세요.");
					System.out.println("==================");
					return Menu.MYPAGE_HOME;
				} catch (ClassNotFoundException e) {
					System.out.println("오류가 발생했습니다.");
					System.out.println("다시 시도해주세요.");
					return Menu.MYPAGE_HOME;
				} catch (SQLException e) {
					System.out.println("오류가 발생했습니다.");
					System.out.println("다시 시도해주세요.");
					return Menu.MYPAGE_HOME;
				}
				
			switch (select) {
			
			case 1:
			System.out.println("비밀번호를 입력하세요.");
			System.out.print("> ");
			String updatePw = scn.nextLine();
			session.setPwd(updatePw);
			break;
			
//			System.out.print("나이를 입력하세요: ");
//			int updateAge = scn.nextInt();
//			session.setAge(updateAge);
//			scn.nextLine();
			
			case 2:
			System.out.println("주소를 입력하세요.");
			System.out.print("> ");
			String updateAdd = scn.nextLine();
			session.setAddress(updateAdd);
			break;
			
			case 3:
			System.out.println("메일을 입력하세요.");
			System.out.print("> ");
			String updateMail = scn.nextLine();
			session.setMail(updateMail);
			break;
			
			case 4:
			System.out.println("전화번호를 입력하세요.");
			System.out.print("> ");
			String updateNum = scn.nextLine();
			session.setPhone(updateNum);
			break;
			}
			
			try {
				int result2 = ck.updateInfo(session);
					if(result2>0) {
						System.out.println("회원정보 변경에 성공했습니다.");
					}
			} catch (ClassNotFoundException e) {
				System.out.println("회원정보 변경에 실패했습니다.");
				System.out.println("다시 시도해주세요.");
			} catch (SQLException e) {
				System.out.println("회원정보 변경에 실패했습니다.");
				System.out.println("다시 시도해주세요.");
			}
			return Menu.MYPAGE_HOME;
		}
		
		
		public int charge() {
			System.out.println("계정에 잔액을 충전합니다.");
			try {
				System.out.println("충전할 금액을 입력하세요.");
				System.out.print("> ");
				int recharge = Integer.parseInt(scn.nextLine());
				session.setRecharge(recharge);
				int result3 = ck.rechargeInfo(session);
				if(result3>0) {
					System.out.println("충전이 완료 되었습니다.");
				}
			} catch (ClassNotFoundException e) {
				System.out.println("잔액충전에 실패하였습니다.");
				System.out.println("다시 시도해주세요.");
			} catch (SQLException e) {
				System.out.println("잔액충전에 실패하였습니다.");
				System.out.println("다시 시도해주세요.");
			} catch (NumberFormatException e) {
				System.out.println("다시 입력해주세요");
				System.out.println("==================");
			}
			return Menu.MYPAGE_HOME;
		}
}