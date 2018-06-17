package modul;

public class Wacher implements Runnable{
	private Movie m;
	public Wacher(Movie m) {
		super();
		this.m = m;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<20;i++) {
			m.watch();
		}
	}
    
}
