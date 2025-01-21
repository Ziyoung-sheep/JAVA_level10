package _07ZombiGame;


public class Boss extends Zombie {
	
	int shield;

	public Boss(String name, int pos, int hp, int power, int repair, int shield) {
		super(name, pos, hp, power, repair);
		this.shield=shield;
	}
	
	public int getShield() {
		return shield;
	}
	public void setShield(int shield) {
		this.shield = shield;
	}

	public void attack(Unit diffenser) {
		int num=playRandom(5, 0);
		if (num!=0) {
			super.attack(diffenser);
		}else {
			int damage=playRandom(getPower(), 0)*2;
			System.out.printf("%s의 필살공격!\n",getName());
			System.out.printf("%s가 %s에게 %d의 두 배로 데미지를 주었습니다.\n", getName(), diffenser.getName(), damage);
			diffenser.setHp(diffenser.getHp()-damage);;
			if (diffenser.getHp()<=0) {
				diffenser.setHp(0);;
				System.out.println(diffenser.getName()+"가 사망했습니다.");
			}
		}
	}
}
