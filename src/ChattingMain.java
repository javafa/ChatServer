
public class ChattingMain {
	public static void main(String args[]){
		// ���� ����
		Server server = new Server(10004);
		server.process();
		
		// Ŭ���̾�Ʈ ����
		Client client = new Client();
		client.setConnect();
	}
}
