package _16유용한클래스;

import java.math.BigDecimal;
import java.math.BigInteger;

public class _05빅데시멀 {
	
	public static void main(String[] args) {
		
		//integer가 저장할 수 있는 데이터의 한계
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		//Long이 저장할 수 있는 데이터의 한계
		System.out.println(Long.MAX_VALUE);
		System.out.println(Long.MIN_VALUE);
		
		//이보다 더 많은 데이터를 저장하고 싶을때 사용하는 클래스
		//정수용
		BigInteger bigNum1= new BigInteger("5468483454643843864634");
		BigInteger bigNum2= new BigInteger("99999999999999999999999999999999999");
		System.out.println(bigNum1);
		System.out.println(bigNum2);
		System.out.println(bigNum1.add(bigNum2));
		System.out.println(bigNum1.subtract(bigNum2));
		System.out.println(bigNum1.multiply(bigNum2));
		System.out.println(bigNum1.divide(bigNum2));
		
		//실수용
		double num=0.1;
		BigDecimal num2=new BigDecimal("0.0");
		
		for (int i = 0; i < 1000; i++) {
			num+=0.1;
			num2=num2.add(new BigDecimal("0.1"));
		}
		System.out.println(num);
		System.out.println(num2);
		
	}

}
