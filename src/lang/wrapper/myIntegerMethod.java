package lang.wrapper;

public class myIntegerMethod {
	
	public static void main(String[] args) {
		
		int value = 10;
		int i1 = compareTo(value, 5);
		int i2 = compareTo(value, 10);
		int i3 = compareTo(value, 20);

		
		System.out.println("i1 : " + i1);
		System.out.println("i2 : " + i2);
		System.out.println("i3 : " + i3);

		
	}

	private static int compareTo(int v, int i) {
		
		if(v < i) {
			return -1;
		}else if(i < v) {
			return 1;
		}else return 0;
	}
	
}
