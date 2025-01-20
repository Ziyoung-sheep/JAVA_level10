package _07ZombiGame;

public class Zombie extends Unit {
	
	protected int repair;

	public Zombie(String name, int pos, int hp, int power, int repair) {
		super(name, pos, hp, power);
		this.repair=repair;
	}

	public int getRepair() {
		return repair;
	}

}
