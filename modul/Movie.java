package modul;
/**
 * 一个场景
 * wait()释放锁
 * @author Small
 *
 */
public class Movie {
	private String pic;
	//信号灯  == T 生产者生产，消费者等待
	private boolean flag = true;
	/**
	 * 播放
	 * @param pic
	 */
	public synchronized void play(String pic) {
		if(!flag) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("生产："+ pic);
		//生产完毕
		this.pic = pic;
		//通知消费
		this.notify();
		//生产者停下
		this.flag = false;
	}
	public synchronized void watch() {
		if(flag) {//消费者等待
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("消费："+pic);
		//消费完毕
		this.notifyAll();
		//通知生产
		this.flag = true;
	}

}
