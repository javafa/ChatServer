import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	ServerSocket serverSocket = null;

	
	// 1. ������ ����
	public Server(int port){ // �������� ����� ��Ʈ
		try {
			serverSocket = new ServerSocket(port);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// 2. ��������
	public void process(){
		// ���⼭ ������ ���� ���
		System.out.println("Server is running...");
		while(true){
			// 3. ���� thread ���� ������ ���� ���
			Socket socket;
			try {
				socket = serverSocket.accept(); // <- ���⼭ ���α׷��� �����
				System.out.println(socket.getInetAddress()+" : Connected");
				subProcess(socket); // ���� thread ���� ������ ó���ϴ� �Լ��� �Ѱ��ش�
			} catch (IOException e) {
				e.printStackTrace();
			} 
		}
	}
	
	private void subProcess(Socket socket){
		new Thread(){
			public void run(){
				InputStream os;
				try {
					os = socket.getInputStream();
					// ��Ʈ���� ���� ������ ����� �غ�
					BufferedReader br = new BufferedReader(new InputStreamReader(os));
					// �ٴ����� �����͸� �޾Ƽ� ȭ�鿡 ���
					while(true){
						String message= br.readLine();
						System.out.println(socket.getInetAddress()+":"+message);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}.start();
	}
}
