package join;

import packageMain.Menu;

public class JoinController {
	private JoinService joinService = JoinService.getInstance();
	private static JoinController instance;
	public static JoinController getInstance() {
		if (instance == null) {
			instance = new JoinController();
		}
		return instance;
	}
	
	public int start() {
		int view = View.JOIN;
		while (true) {
			switch (view) {
			case View.HOME:
				return Menu.HOME;
			case View.JOIN:
				view = joinService.join();
				break;
			}
		}
	}
}
