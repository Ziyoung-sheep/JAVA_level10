package _09제네틱클래스;
//타입이 컴파일이 아니라 런타임에서 정해진다

class Box<T>{ //꺽쇠와 함게 한글자로 이루어짐: 대체로 타입의 약자
	private T t;

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}
	
}

class Tv{
	String brand;
	int serialNo;
	Tv(String brand, int serialNo){
		super();
		this.brand=brand;
		this.serialNo=serialNo;
	}
	@Override
	public String toString() {
		return "Tv [brand=" + brand + ", serialNo=" + serialNo + "]";
	}
}

class Product<T,M>{
	private T kind;
	private M model;
	
	public T getKind() {
		return kind;
	}
	public void setKind(T kind) {
		this.kind = kind;
	}
	public M getModel() {
		return model;
	}
	public void setModel(M model) {
		this.model = model;
	}
	
	@Override
	public String toString() {
		return "Product [kind=" + kind + ", model=" + model + "]";
	}
	
}

public class _01제네릭클래스이론 {
	public static void main(String[] args) {
		Box<Integer>test=new Box();
		test.setT(10);//set 하면 타입이 integer로 바뀌어있음
		System.out.println(test.getT());
		
		Box<String>test2=new Box();
		test2.setT("딸기");
		System.out.println(test2.getT());
		
		Box<Tv>test3=new Box();
		test3.setT(new Tv("MBC", 10));
		System.out.println(test3.getT());
		
		Product<Integer,String>test4=new Product();
		test4.setKind(1000);
		test4.setModel("모델명");
		System.out.println(test4);
		
		Product<Tv,String>test5=new Product();
		test5.setKind(new Tv("LG", 222222));
		test5.setModel("스탠바이미");
		System.out.println(test5);
		
		
		
		
		
	}
}
