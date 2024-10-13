package lang.wrapper;

public class Main {
	public static void main(String[] args) {
		
		/*
		 * MyInteger integer = new MyInteger(10);
		 * 
		 * 
		 * int i1 = integer.compareTo(5); int i2 = integer.compareTo(10); int i3 =
		 * integer.compareTo(20);
		 * 
		 * 
		 * System.out.println("i1 : " + i1); System.out.println("i2 : " + i2);
		 * System.out.println("i3 : " + i3);
		 */

		
		int[] intArr = {-1, 0, 1, 2, 3};
		
		System.out.println(findValue(intArr, -1));
		System.out.println(findValue(intArr, 0));
		System.out.println(findValue(intArr, 1));
		System.out.println(findValue(intArr, 100));

		
	}
	
	private static int findValue(int[] intArr, int target) {
		
		for(int value : intArr) {
			if(value == target) {
				return value; 
			}
		}
		
		return -11;
	}

}
