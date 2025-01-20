package _04추상_개념2;

public class _Main {
	
	public static void main(String[] args) {
		
		System.out.println(MyBakery.getSlogan());
		System.out.println(MyChicken.getSlogan());
		System.out.println(MyCafe.getSlogan());
		
		MyBakery store1 = new MyBakery("구미", false);
		MyBakery store2 = new MyBakery("강남", true);
		
		MyChicken store3 = new MyChicken("홍대");
		MyChicken store4 = new MyChicken("강남");
		MyChicken store5 = new MyChicken("신촌");
		
		MyCafe store6=new MyCafe("잠실", false);
		MyCafe store7=new MyCafe("석촌", true);

		store1.takeOrder();
		store2.takeOrder();
		store3.takeOrder();
		store4.takeOrder();
		store5.takeOrder();
		store6.takeOrder();
		store7.takeOrder();
		
		
	}
}
