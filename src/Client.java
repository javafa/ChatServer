import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	Socket socket;
	public Client() {
		try {
			socket = new Socket("192.168.10.240", 10004);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void setConnect(){
		// ���� thread ���� ���������� ���� Ű���� �Է°��� ������ �����Ѵ�.
		new Thread(){
			public void run(){
				Scanner scanner = new Scanner(System.in); // Ű���� �Է� ����
				try {
					OutputStream os = socket.getOutputStream();
					while(true){
						String word = scanner.nextLine(); // �Է��� ����ϰ� �ִٰ� enter Ű�� �ԷµǸ�
						os.write(word.getBytes()); // stream�� ���� ���������� �����Ѵ�.
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}.start();
	}
}
