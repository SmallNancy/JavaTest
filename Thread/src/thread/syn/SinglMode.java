package thread.syn;
/**
 * 单例设计模式;确保一个类只有一个对象
 * @author Small
 *
 */
public class SinglMode {
    public static void main(String[] args) {
    	//单线程同步时有相同的地址
//		Jvm jvm1 = Jvm.getInstance(50);
//		Jvm jvm2 = Jvm.getInstance(100);
    	//多线程 地址就不相同了
    	jvmThread jvm1 = new jvmThread(100);
    	jvmThread jvm2 = new jvmThread(500);
    	jvm1.start();
    	jvm2.start();
	}
}
class jvmThread extends Thread{
	private long time;
	public jvmThread(long time) {
		this.time = time;
	}
	@Override
	public void run() {
		super.run();
		System.out.println(Thread.currentThread().getName()+"创建"+Jvm.getInstance(time));
	}
}
/**
 * 单例设计模式
 * 确保一个类只有一个对象
 * 懒汉式 double check双重检查
 * 1、构造器私有化，避免外部直接创建对象
 * 2、声明一个私有静态变量
 * 3、创建一个对外的公共的静态方法
 * @author Small
 *
 */
class Jvm{
    //声明一个私有静态变量
    private static Jvm instance = null;
    //构造器私有化，避免外部直接创建对象
    private Jvm() {
    }
    //同步方法
    public static synchronized Jvm getInstance1(long time) {
    	if(null == instance) {
    		try {
				Thread.sleep(time);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		instance = new Jvm();
    	}
    	return instance;
    }
    
    public static Jvm getInstance(long time) {
    	if(null == instance) {
    		try {
				Thread.sleep(time);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		instance = new Jvm();
    	}
    	return instance;
    }
    
}