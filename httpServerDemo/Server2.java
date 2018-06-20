package httpServerDemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * 手写服务器
 * 创建服务器并启动
 *  get/post请求方式都可以
 *  post数据量大，安全
 * @author Small
 *
 */
public class Server2 {
	private ServerSocket server;
    public static void main(String[] args) {
    	Server2 server = new Server2();
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
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
    }
    public void stop() {
    	
    }
}
