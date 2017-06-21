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
		System.out.println("SetConnect");
		Scanner scanner = new Scanner(System.in); // Ű���� �Է� ����
		try {
			System.out.println("in try");
			OutputStream os = socket.getOutputStream();
			while(true){
				String word = scanner.nextLine() + "\r\n"; // �Է��� ����ϰ� �ִٰ� enter Ű�� �ԷµǸ�
				os.write(word.getBytes()); // stream�� ���� ���������� �����Ѵ�.
				os.flush();
				System.out.println("input:"+word);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
