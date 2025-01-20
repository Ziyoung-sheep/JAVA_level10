package _06다형성실습;

import java.util.Random;

abstract class Shape {
	
	String name;
	String color;
	double size;
	Shape(String name, String color, double size) {
		super();
		this.name = name;
		this.color = color;
		this.size = size;
	}
	abstract void draw();
}

class Line extends Shape {
	Line(String color, int size) {
		super("직선", color, size);
	}
	@Override
	void draw() {
		System.out.println("선을 긋는다 ");
		System.out.printf("(%s,%s,%.2f)\n",name,color,size);
	}
	
}

class point extends Shape {
	point(String color) {
		super("점",color,0);
	}
	@Override
	void draw() {
		System.out.println("점을 찍는다");
		System.out.printf("(%s)\n", color);
	}
}

class Circle extends Shape {

	int radius;

	Circle(String color, int radius) {
		super("원", color, radius*radius*3.14);
	}
	@Override
	void draw() {
		System.out.println("원을 그린다");
		System.out.printf("(%s,%s,%.2f)\n",name,color,size);
	}
}

class Rect extends Shape {

	int height;
	int width;
	Rect(String color, int height, int width) {
		super("사각형", color, height*width);
	}
	@Override
	void draw() {
		System.out.println("사각형을 그린다");
		System.out.printf("(%s,%s,%.2f)\n",name,color,size);
	}
}
class Triangle extends Shape {
	int height;
	int width;
	Triangle(String color,  int height, int width) {
		super("삼각형", color,height*width/2);
	}
	@Override
	void draw() {
		System.out.println("삼각형을 그린다");
		System.out.printf("(%s,%s,%.2f)\n",name,color,size);
	}
}

public class _01도형 {
	public static void main(String[] args) {
		// 모양도 랜덤하게 색깔 사이즈 랜덤해게 도형 10개를 출력하세요 
		// 점 , 선 기존 size 출력 
		// 원, 네모, 세모 => size 넓이를 계산해서 출력 
		String[] colors = {"파란색", "빨간색","보라색","분홍색","노란색"};
		Shape[] list = new Shape[10];
		Random rd=new Random();
		//[문제1] 10 랜덤하게 생성해서 출력하기 
		for (int i = 0; i < list.length; i++) {
			int pick=rd.nextInt(5);
			String color=colors[rd.nextInt(colors.length)];
			if (pick==0) {
				list[i]=new Line(color, rd.nextInt(5)+1);
			}else if(pick==1) {
				list[i]=new point(color);
			}else if(pick==2) {
				list[i]=new Circle(color, rd.nextInt(5)+1);
			}else if(pick==3) {
				list[i]=new Rect(color, rd.nextInt(5)+1, rd.nextInt(5)+1);
			}else if(pick==4) {
				list[i]=new Triangle(color, rd.nextInt(5)+1, rd.nextInt(5)+1);
			}
			list[i].draw();
		}
		//[문제2] 원만 출력하기 
		System.out.println("======================");
		list=new Shape[10];
		for (int i = 0; i < list.length; i++) {
			String color=colors[rd.nextInt(colors.length)];
			list[i]=new Circle(color, rd.nextInt(10)+1);
			list[i].draw();
		}
		System.out.println("======================");
		
	}
}