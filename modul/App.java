package modul;

public class App {
    public static void main(String[] args) {
    	//共同资源
		Movie m = new Movie();
        //多线程
		Player p = new Player(m);
		Wacher w = new Wacher(m);
		new Thread(p).start();
		new Thread(w).start();
    }
}
