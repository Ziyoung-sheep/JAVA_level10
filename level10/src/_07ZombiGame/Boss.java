package _07ZombiGame;


public class Boss extends Zombie {
	
	int shield;

	public Boss(String name, int pos, int hp, int power, int repair, int shield) {
		super(name, pos, hp, power, repair);
		this.shield=shield;
	}
	
	
	
	//필살공격!

}
