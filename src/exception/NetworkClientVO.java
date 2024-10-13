package exception;

public class NetworkClientVO {
	
	private final String address;
	
	public NetworkClientVO(String adress) {
		this.address = adress;
	}
	
	public void connect() {
		System.out.println(address + " 서버 연결 성공");
	}

	public String send(String data) {
		System.out.println(address + " 서버에 데이터 전송 " + "\"" + data + "\"");
		return "success";
	}
	
	public void disconnect() {
		System.out.println(address + " 서버 연결 해제");
	}
	
	
}
