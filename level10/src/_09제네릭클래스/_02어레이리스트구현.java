package _09제네릭클래스;

import java.util.Arrays;

class MyArrayList<T>{
	private T[] arr;
	int size;
	private int capacity=10;
	MyArrayList(){
		//arr=new T[capacity]; //제네릭 클래스로 배열선언을 할 수 없다!
		arr=(T[])new Object[10];//오브젝트로 생성해서 T타입으로 강제 변환
	}
	public void print() {
		System.out.println(Arrays.toString(arr));
	}
	
	public int size() {
		int cnt=0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i]!=null) cnt++;
			else break;
		}
		return cnt;
	}
	
	public int capacity() {
		int cnt=arr.length/capacity;
		if (arr.length%capacity!=0) cnt++;
		return cnt*capacity;
	}
	
	public void add(T thing) {
		int cnt=0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i]==null) {
				arr[i]=thing;
				break;
			}
			cnt++;
		}
		if (cnt==arr.length) {
			T[] temp=arr;
			arr=(T[])new Object[arr.length+10];
			int idx=0;
			for (int i = 0; i < temp.length; i++) {
				arr[i]=temp[i];
			}
			arr[arr.length-10+1]=thing;
		}
	}
	
	public T get(int idx) {
		return arr[idx];
	}
	@Override
	public String toString() {
		return "MyArrayList [arr=" + Arrays.toString(arr) ;
	}
	
	public void set(int idx, T thing) {
		arr[idx]=thing;
	}
	
	public void remove(int idx) {
		for (int i = idx; i < arr.length-1; i++) {
			arr[i]=arr[i+1];
		}
		arr[arr.length-1]=null;
	}
	
	public void clear() {
		arr=(T[])new Object[10];
	}
	
}

public class _02어레이리스트구현 {
	public static void main(String[] args) {
		
//		MyArrayList<Integer>list2=new MyArrayList();
//		list2.print();
		MyArrayList<Double>v1=new MyArrayList();
//		list1.print();

		System.out.println(v1.toString());
		System.out.println(v1.size());
		System.out.println(v1.capacity());
		
		for (int i = 0; i < 10; i++) {
			v1.add((i+1)*10*1.0);
		}
		
		System.out.println(v1.toString());
		System.out.println(v1.size());
		System.out.println(v1.capacity());
		System.out.println(v1.get(1));
		
		v1.set(1,1000.0);
		System.out.println(v1.toString());
		
		v1.remove(3);
		System.out.println(v1.toString());
		System.out.println(v1.size());
		System.out.println(v1.capacity());
		
		v1.clear();
		System.out.println(v1.toString());
		System.out.println(v1.size());
		System.out.println(v1.capacity());
	}
}
