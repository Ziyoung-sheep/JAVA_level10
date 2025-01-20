package _04추상_개념2;

public class MyCafe extends MyBrand{
	
	private static int myNum = 0;
	
	public static String getSlogan() {
		return String.format(SLOGAN, "연미카페");
	}

	private boolean takeOut;
	
	public MyCafe( String name, boolean takeOut ) {
		super(++myNum, name);
		this.takeOut=takeOut;
	}

	@Override
	public void takeOrder() {
		System.out.printf(" 연미카페 %s 커피를 %s로 주문했습니다 \n" , super.info(), takeOut==true?"테이크아웃":"매장 식사");
	}

}
