package _07ZombiGame;


public class Boss extends Zombie {
	
	int shield;

	public Boss(String name, int pos, int hp, int power, int repair, int shield) {
		super(name, pos, hp, power, repair);
		this.shield=shield;
	}
	
	public void attack(Unit diffenser) {
		int num=playRandom(5, 0);
		if (num!=0) {
			super.attack(diffenser);
		}else {
			int damage=playRandom(getPower(), 0)*2;
			diffenser.setHp(diffenser.getHp()-damage);;
			if (diffenser.getHp()<=0) {
				diffenser.setHp(0);;
				System.out.println(diffenser.toString()+"이 사망했습니다.");
			}
		}
		
	}
	
	
	//필살공격!

}
