package thread.syn;
/**
 * ���ȵ�ͬ�������������
 * @author Small
 *
 */
public class SynDemo02 {
    public static void main(String[] args) {
		Object g = new Object();
		Object m = new Object();
		Test t1 = new Test(g,m);
		Test t2 = new Test(g,m);
		Thread proxy = new Thread(t1);
		Thread proxy2 = new Thread(t2);
		proxy.start();
		//���proxy2�߳�������� 
		//proxy2.start(); 
	}

}
class Test implements Runnable{
	Object goods;
	Object money;
	
	public Test(Object goods, Object money) {
		super();
		this.goods = goods;
		this.money = money;
	}
	@Override
	public void run() {
        while(true) {
        	test();
        }
	}
	public void test() {
		synchronized(money) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			synchronized(goods) {
				
			}
		}
		synchronized(goods) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			synchronized(money) {
				
			}
		}
		System.out.println("һ�ָ�Ǯ");
	}
}
