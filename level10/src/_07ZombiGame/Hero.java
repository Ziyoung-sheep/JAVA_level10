package _07ZombiGame;

public class Hero extends Unit {
	
	private int potion;

	public Hero(String name, int pos, int hp, int power, int potion) {
		super(name, pos, hp, power);
		this.potion=potion;
	}
	
	public int getPotion() {
		return potion;
	}

	public void setPotion(int potion) {
		this.potion = potion;
	}

	public void attack(Zombie diffenser) {//쉴드가 잇을 경우 쉴드부터 깨기
		super.attack(diffenser);
	}
	
	public void repair(Zombie diffenser) {
		if (diffenser.getHp()>0&&diffenser.getHp()!=diffenser.getMAX_HP()) {
			int plusHp=playRandom(diffenser.getRepair(), 1);
			diffenser.setHp(diffenser.getHp()+plusHp);
			if (diffenser.getMAX_HP()<diffenser.getHp()) {
				diffenser.setHp(diffenser.getMAX_HP());
			}
			System.out.printf("%s가 hp를 %d 회복했습니다.\n", diffenser.getName(), plusHp);
//			diffenser.toString();
		}
	}
}
