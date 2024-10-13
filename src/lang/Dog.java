package lang;

public class Dog {

	private String dogName;
	private int age;
	
	public void sound() {
		System.out.println("멍멍");
	}
	
	public Dog(String name, int a) {
		dogName = name;
		age = a;
	}
	
	@Override
	public String toString() {
		
		return "강아지 이름 : " + dogName + " / 강아지 나이 : " + age;
	}
}
