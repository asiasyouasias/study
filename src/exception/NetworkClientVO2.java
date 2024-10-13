package exception;

public class NetworkClientVO2 {

	private final String address;
	public boolean connectError;
	public boolean sendError;
	
	public NetworkClientVO2(String adress) {
		this.address = adress;
	}
	
	public String connect(String data) {
		initError(data);
		if(connectError) {
			System.out.println(address + "서버 연결 실패");
			return "connect Error";
		}
		System.out.println(address + " 서버 연결 성공");
		return "success";
	}

	public String send(String data) {
		initError(data);
		if(sendError) {
			System.out.println(address + " 서버에 데이터 전송 실패");
			return "sendError";
		}
		System.out.println(address + " 서버에 데이터 전송 " + "\"" + data + "\"");
		return "success";
	}
	
	public void disconnect() {
		System.out.println(address + " 서버 연결 해제");
	}
	
	public void initError(String data) {
		if(data.contains("error1")) {
			connectError = true;
			sendError = true;
		}
		
		if(data.contains("error2")) {
			sendError = true;
		}
	}
	
	
	
	
	
}
