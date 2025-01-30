package _14다형성게임_실습;

public class StageTitle extends Stage {

	@Override
	public boolean update() {
		System.out.println("=========================");
		System.out.println("=   파이널텍스트판타지1.4   =");
		System.out.println("=========================");
		String go=Utiles.getInstance().inString("[go]를 입력하세요");
		if (go.equals("go")) {
			return true;
		}
		System.err.println("입력 오류");
		return false;
	}

	@Override
	public void init() {
		
	}
}