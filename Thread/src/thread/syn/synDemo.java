package thread.syn;
/**
 * ģ��12306��Ʊ  
 * �̰߳�ȫ�Ͳ���ȫģ��
 * @author Small
 *
 */
public class synDemo {
    public static void main(String[] args) {
    	//���ǽ�ɫ
    	web12306 web1 = new web12306();
    	web12306 web2 = new web12306();
    	//����
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
	//�̰߳�ȫ
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
		System.out.println(Thread.currentThread().getName()+"������"+num--);
	}
	//�߳�����
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
		    System.out.println(Thread.currentThread().getName()+"������"+num--);
	    }
    }
	//�̲߳���ȫЧ�ʸ�
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
		System.out.println(Thread.currentThread().getName()+"������"+num--);
	}
    
}