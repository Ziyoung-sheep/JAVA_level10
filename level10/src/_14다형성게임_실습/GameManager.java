package _14다형성게임_실습;

public class GameManager {
	
	static boolean exit=false;
	Stage stageNow = new StageTitle();
	
	public void run(){
		while(true) {
			if (stageNow.update()) {
				stageNow=new StageLobby();
				if (stageNow.update()) {
					stageNow=new StageBattle();
				}else {
					exit=true;
				}
			}
			if (exit) {
				System.err.println("게임 종료");
				break;
			}
		}
	}
}