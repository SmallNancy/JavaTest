package thread.syn;
/**
 * ����ģʽ������ʽ
 * 1������ʽ
 * 1) ������˽�л�
 * 2) ����˽�еľ�̬����
 * 3) �����ṩ�������Եľ�̬������ȷ���ö������
 * @author Small
 *
 */
public class MyJvm {
	private static MyJvm instance;
    private MyJvm() {
    	
    }
    public static MyJvm getInstance() {
    	if(null==instance) {//���Ч��
    		synchronized(MyJvm.class) {//��ȫ
    			if(null==instance) {
    				instance = new MyJvm();
    			}
    		}
        }
        return instance;
    }
}

/**
 * Runtime���ǵ��͵ĵ���ģʽ--����ʽ
 * ����ʽ
 * 1) ������˽�л�
 * 2) ����˽�еľ�̬���ԣ�ͬʱ�����ö���
 * 3) �����ṩ�������Եľ�̬����
 * @author Small
 *
 */
class MyJvm2 {
	private static MyJvm2 instance = new MyJvm2();
   private MyJvm2() {
   	
   }
   public static MyJvm2 getInstance() {
       return instance;
   }
}
