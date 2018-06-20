package httpServerDemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * 手写服务器
 * 创建服务器并启动
 * get请求方式没有问题
 * post请求方式 提交的数据没有显示出来
 * @author Small
 *
 */
public class Server {
	private ServerSocket server;
    public static void main(String[] args) {
    	Server server = new Server();
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
			StringBuilder sb = new StringBuilder();
			String msg = null;//接收客户端请求信息
			BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
			while((msg=br.readLine()).length() > 0) {
				sb.append(msg);
				sb.append("\r\n");
			}
			System.out.println(sb.toString().trim());//去除一下空格
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
    }
    public void stop() {
    	
    }
}
