package langStudy;

public class CharArrayMain {
	public static void main(String[] args) {
		char[] charArr = new char[] {'h', 'e', 'l', 'l', 'o'};
		String str1 = "hel";
		String str2 = "lo";
		String[] strs = {str1, str2};
		Object object = new Object();
		object.toString();
		
		
		
		for(int i = 0; i <=strs.length - 1; i++) {
			System.out.println(strs[i]);
			
		}
		
		for(String s : strs) {
			System.out.println(s);
		}
		
	}
	

}