package modul;

public class App {
    public static void main(String[] args) {
    	//��ͬ��Դ
		Movie m = new Movie();
        //���߳�
		Player p = new Player(m);
		Wacher w = new Wacher(m);
		new Thread(p).start();
		new Thread(w).start();
    }
}
