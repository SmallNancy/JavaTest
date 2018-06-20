package httpServerDemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * ��д������
 * ����������������
 * get����ʽû������
 * post����ʽ �ύ������û����ʾ����
 * @author Small
 *
 */
public class Server {
	private ServerSocket server;
    public static void main(String[] args) {
    	Server server = new Server();
    	server.start();
    	
	}
    
    //��������
    public void start() {
		try {
			server = new ServerSocket(8888);
			this.recieve();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    //���տͻ���
    public void recieve() {
    	try {
			Socket client = server.accept();
			StringBuilder sb = new StringBuilder();
			String msg = null;//���տͻ���������Ϣ
			BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
			while((msg=br.readLine()).length() > 0) {
				sb.append(msg);
				sb.append("\r\n");
			}
			System.out.println(sb.toString().trim());//ȥ��һ�¿ո�
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
    }
    public void stop() {
    	
    }
}
