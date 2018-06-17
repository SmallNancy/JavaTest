package thread.syn;
/**
 * 模拟12306抢票  
 * 线程安全和不安全模拟
 * @author Small
 *
 */
public class synDemo {
    public static void main(String[] args) {
    	//真是角色
    	web12306 web1 = new web12306();
    	web12306 web2 = new web12306();
    	//代理
    	Thread t1 = new Thread(web1,"user 01");
    	Thread t2 = new Thread(web2,"user 02");
    	Thread t3 = new Thread(web1,"user 03");
    	t1.start();
    	t2.start();
    	t3.start();
		
	}
    
}
class web12306 implements Runnable{
    private int num = 50;
    private boolean flag = true;
	@Override
	public void run() {
		while(flag) {
			test2();
		}
		
	}
	//线程安全
	public synchronized void test2() {
		if(num <= 0) {
			flag = false;
		}
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+"抢到了"+num--);
	}
	//线程锁定
	public void test1() {
		synchronized(this) {
	        if(num <= 0) {
			    flag = false;
		    }
		    try {
			    Thread.sleep(500);
		    } catch (InterruptedException e) {
				// TODO Auto-generated catch block
			    e.printStackTrace();
		    }
		    System.out.println(Thread.currentThread().getName()+"抢到了"+num--);
	    }
    }
	//线程不安全效率高
	public void test3() {
		
	    if(num <= 0) {
			flag = false;
		}
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+"抢到了"+num--);
	}
    
}