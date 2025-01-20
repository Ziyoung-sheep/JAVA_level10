package _07ZombiGame;

public class Hero extends Unit {
	
	private int potion;

	public Hero(String name, int pos, int hp, int power, int potion) {
		super(name, pos, hp, power);
		this.potion=potion;
	}
	
	public void attack(Zombie diffenser) {//쉴드가 잇을 경우 쉴드부터 깨기
		super.attack(diffenser);
		if (diffenser.getHp()>0) {
			int plusHp=playRandom(diffenser.getRepair(), 1);
			diffenser.setHp(getHp()+plusHp);
			System.out.printf("%s가 hp를 %d 회복했습니다.", diffenser.getName(), plusHp);
			diffenser.toString();
		}
	}
}
