package httpServerDemo;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * 请求并响应
 * 创建服务器并启动
 *  get/post请求方式都可以
 *  post数据量大，安全
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
    
    //启动方法
    public void start() {
		try {
			server = new ServerSocket(8888);
			this.recieve();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    //接收客户端
    public void recieve() {
    	try {
			Socket client = server.accept();
			String msg = null;//接收客户端请求信息
			byte[] data = new byte[1024];
			int len = client.getInputStream().read(data);
			StringBuilder sb = new StringBuilder();
			String requInfo = new String(data,0,len).trim();
			System.out.println(requInfo);//trim去除一下空格
			
			//响应
			StringBuilder responseContext = new StringBuilder();
			responseContext.append("<html lang=\"en\">\r\n" + 
					"<head>\r\n" + 
					"	<meta charset=\"UTF-8\">\r\n" + 
					"	<title>http响应demo</title>\r\n" + 
					"</head>\r\n" + 
					"<body>\r\n" + 
					"	Hello Tomcat\r\n" + 
					"</body>\r\n" + 
					"</html>");
			StringBuilder response = new StringBuilder();
			//HTTP协议版本、状态代码、描述
			response.append("HTTP/1.1").append(BLANK).append("200").append(BLANK).append("ok").append(CRLF);
			//响应头
			response.append("Server:nancy Server/0.0.1").append(CRLF);
			response.append("Date:").append(new Date()).append(CRLF);
			//响应正文类型
			response.append("Content-type:text/html;charset=GBK").append(CRLF);
			//正文长度，字节长度
			response.append("Content-Length:").append(responseContext.toString().getBytes().length).append(CRLF);
			//正文之前
			response.append(CRLF);
			//正文
			response.append(responseContext);
			
			
			//输出流
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
