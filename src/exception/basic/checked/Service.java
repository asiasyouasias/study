package exception.basic.checked;

public class Service {
	Client client = new Client();
	
	public void callCatch() {
		try {
			client.call();
		}catch (Exception e) {
			System.out.println("예외처리 메시지 : " + e.getMessage());
		}
		
		System.out.println("정상 동작");
	}

	
	public void callThrwo() throws MyCheckedException {
		client.call();
	}
	
	
}
