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
		// 서브 thread 에서 서버연결을 통해 키보드 입력값을 서버로 전달한다.
		new Thread(){
			public void run(){
				Scanner scanner = new Scanner(System.in); // 키보드 입력 생성
				try {
					
					while(true){
						String word = scanner.nextLine(); // 입력을 대기하고 있다가 enter 키가 입력되면
						OutputStream os = socket.getOutputStream();
						os.write(word.getBytes()); // stream을 통해 서버측으로 전달한다.
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}.start();
	}
}
