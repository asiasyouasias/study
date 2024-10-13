package exception;

public class NetworkServiceVO {
	
	public void sendMessage(String data) {
		
		String address = "http://example.com";
		NetworkClientVO2 clientVO2 = new NetworkClientVO2(address);
		
		clientVO2.initError(data);
		clientVO2.connect(data);
		clientVO2.send(data);
		clientVO2.disconnect();
		
	}

}
