package exception;

import java.util.Scanner;

public class MainVO {
	
	public static void main(String[] args) {
		
		NetworkServiceVO networkServiceVO = new NetworkServiceVO();
		
		Scanner sc = new Scanner(System.in);
		
		
		while(true) {
			System.out.printf("전송할 문자 : ");
			String message = sc.nextLine();
			
			if(message.equals("exit")) {
				break;
			}
			networkServiceVO.sendMessage(message);
			System.out.println();
		}
		System.out.println("프로그램 정상 종료");
	}

}
