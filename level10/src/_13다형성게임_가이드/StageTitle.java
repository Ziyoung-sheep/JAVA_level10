package _13다형성게임_가이드;

public class StageTitle extends Stage {

	@Override
	public boolean update() {
		System.out.println("==== TEXT RPG ====");
		System.out.println("[시작] 을 입력하세요");
		String start = GameManager.scan.next();
		if (start.equals("시작")) 
			return false;
		GameManager.nextStage = "LOBBY";
		return true;
	}

	@Override
	public void init() {

	}

}