package modul;
/**
 * һ������
 * wait()�ͷ���
 * @author Small
 *
 */
public class Movie {
	private String pic;
	//�źŵ�  == T �����������������ߵȴ�
	private boolean flag = true;
	/**
	 * ����
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
		System.out.println("������"+ pic);
		//�������
		this.pic = pic;
		//֪ͨ����
		this.notify();
		//������ͣ��
		this.flag = false;
	}
	public synchronized void watch() {
		if(flag) {//�����ߵȴ�
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
		System.out.println("���ѣ�"+pic);
		//�������
		this.notifyAll();
		//֪ͨ����
		this.flag = true;
	}

}
