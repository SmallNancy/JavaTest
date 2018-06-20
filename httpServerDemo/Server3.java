package httpServerDemo;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * ������Ӧ
 * ����������������
 *  get/post����ʽ������
 *  post�������󣬰�ȫ
 * @author Small
 *
 */
public class Server3 {
	private ServerSocket server;
	private static String CRLF = "\r\n";
	private static String BLANK = " ";
    public static void main(String[] args) {
    	Server3 server = new Server3();
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
			
			//��Ӧ
			StringBuilder responseContext = new StringBuilder();
			responseContext.append("<html lang=\"en\">\r\n" + 
					"<head>\r\n" + 
					"	<meta charset=\"UTF-8\">\r\n" + 
					"	<title>http��Ӧdemo</title>\r\n" + 
					"</head>\r\n" + 
					"<body>\r\n" + 
					"	Hello Tomcat\r\n" + 
					"</body>\r\n" + 
					"</html>");
			StringBuilder response = new StringBuilder();
			//HTTPЭ��汾��״̬���롢����
			response.append("HTTP/1.1").append(BLANK).append("200").append(BLANK).append("ok").append(CRLF);
			//��Ӧͷ
			response.append("Server:nancy Server/0.0.1").append(CRLF);
			response.append("Date:").append(new Date()).append(CRLF);
			//��Ӧ��������
			response.append("Content-type:text/html;charset=GBK").append(CRLF);
			//���ĳ��ȣ��ֽڳ���
			response.append("Content-Length:").append(responseContext.toString().getBytes().length).append(CRLF);
			//����֮ǰ
			response.append(CRLF);
			//����
			response.append(responseContext);
			
			
			//�����
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
			bw.flush();
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
    }
    public void stop() {
    	
    }
}
