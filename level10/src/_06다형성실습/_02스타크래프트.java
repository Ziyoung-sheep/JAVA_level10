package _06다형성실습;

import java.util.Random;

// damage() 메소드를 가진 
// Interface Damageable 를 정의하고
// 최하위 유닛들 (모든) 에게 Damageable 상속 
// main에서 각각의 유닛들을 손상시킨 후 -> repair() 돌려보기

interface Damageable{}

class Unit implements Damageable{
	int no;
	String name;
	final int MAX_HP;
	int hp;
	int power;
	boolean dead;
	public Unit(String name, int hp, int power) {
		no=0;
		this.name=name;
		MAX_HP = hp;
		this.hp = MAX_HP;
		this.power=power;
		this.dead=false;
	}
	public void damageUnit(int demage) {
		hp-=demage;
	}

}

class Tank extends Unit{

	public Tank() {
		super("탱크",200,30);
	}
	
	@Override
	public String toString() {
		return name+no+"(" +hp+ "/" + MAX_HP + ")";
	}
}
class Soldier extends Unit{

	public Soldier() {
		super("병사",100,20);
	}
	
	@Override
	public String toString() {
		return name+no+"(" +hp+ "/" + MAX_HP + ")";
	}

	
}
class Dropship extends Unit{

	public Dropship() {
		super("드랍쉽",250,50);
	}
	
	@Override
	public String toString() {
		return name+no+"(" +hp+ "/" + MAX_HP + ")";
	}
}
class SCV extends Unit{

	public SCV() {
		super("SCV", 220,60);
	}
	
	@Override
	public String toString() {
		return name+no+"(" +hp+ "/" + MAX_HP + ")";
	}
	
}

class Utiles{
	static private Random rd=new Random();
	public static Random getRd() {
		return rd;
	}
}

class DAO{
	int cnt;
	int player;

	Unit[]list;
	boolean[]check;
	
	private void init() {
		cnt=1;
		player=10;
		list=new Unit[player];
		check=new boolean[player];
	}

	private Unit[] makePlayer() {
		for (int i = 0; i < player ; i++) {
			int num=Utiles.getRd().nextInt(4);
			if (num==0) {
				list[i]=new Tank();
			}else if(num==1) {
				list[i]=new Soldier();
			}else if(num==2) {
				list[i]=new Dropship();
			}else if(num==3) {
				list[i]=new SCV();
			}
			list[i].no+=i+1;
			System.out.println("[생성]"+list[i].toString());
		}
		return list;
	}
	
	private void bettlePalyer(Unit[]list) {
		while(true) {
			int attackerIdx=-1;
			int diffenderdx=-1;
			while (true) {
				attackerIdx=Utiles.getRd().nextInt(10);
				diffenderdx=Utiles.getRd().nextInt(10);
				if (attackerIdx!=diffenderdx&&list[attackerIdx].dead==false&&list[diffenderdx].dead==false) {
					break;
				}
			}
			//데미지 입는 매서드
			Unit attackerUnit=list[attackerIdx];
			Unit diffenderUnit=list[diffenderdx];
			
			int damege=Utiles.getRd().nextInt(attackerUnit.power)+1;
			System.out.println(attackerUnit.toString()+"이 "+diffenderUnit.toString()+"에게 "+damege+"의 피해를 입혔다!");
			diffenderUnit.damageUnit(damege);
			if (diffenderUnit.hp<=0) {
				diffenderUnit.hp=0;
				diffenderUnit.dead=true;
				player-=1;
			}
			if (diffenderUnit.dead==true) {
				System.err.println(diffenderUnit.toString()+" 사망!");
			}
			
			if (player==1) {
				System.err.println("=======게임 종료=======");
				System.out.println("최후의 승자는 "+attackerUnit.toString());
				break;
			}
		}
	}
	
	public void run() {
		init();
		bettlePalyer(makePlayer());
	}
}


public class _02스타크래프트 {
	public static void main(String[] args) {
		
		// 10개 유닛 만들어서 
		// 서로 랜덤하게 공격하다가 
		// 한명 살아남을때까지 반복! 
		DAO dao=new DAO();
		dao.run();
		
	}
}