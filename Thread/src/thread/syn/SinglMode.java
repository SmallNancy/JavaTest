package thread.syn;
/**
 * �������ģʽ;ȷ��һ����ֻ��һ������
 * @author Small
 *
 */
public class SinglMode {
    public static void main(String[] args) {
    	//���߳�ͬ��ʱ����ͬ�ĵ�ַ
//		Jvm jvm1 = Jvm.getInstance(50);
//		Jvm jvm2 = Jvm.getInstance(100);
    	//���߳� ��ַ�Ͳ���ͬ��
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
		System.out.println(Thread.currentThread().getName()+"����"+Jvm.getInstance(time));
	}
}
/**
 * �������ģʽ
 * ȷ��һ����ֻ��һ������
 * ����ʽ double check˫�ؼ��
 * 1��������˽�л��������ⲿֱ�Ӵ�������
 * 2������һ��˽�о�̬����
 * 3������һ������Ĺ����ľ�̬����
 * @author Small
 *
 */
class Jvm{
    //����һ��˽�о�̬����
    private static Jvm instance = null;
    //������˽�л��������ⲿֱ�Ӵ�������
    private Jvm() {
    }
    //ͬ������
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