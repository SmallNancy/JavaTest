package httpServerDemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * ��д������
 * ����������������
 *  get/post����ʽ������
 *  post�������󣬰�ȫ
 * @author Small
 *
 */
public class Server2 {
	private ServerSocket server;
    public static void main(String[] args) {
    	Server2 server = new Server2();
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
			String msg = null;//���տͻ���������Ϣ
			byte[] data = new byte[1024];
			int len = client.getInputStream().read(data);
			StringBuilder sb = new StringBuilder();
			String requInfo = new String(data,0,len).trim();
			System.out.println(requInfo);//trimȥ��һ�¿ո�
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
    }
    public void stop() {
    	
    }
}
