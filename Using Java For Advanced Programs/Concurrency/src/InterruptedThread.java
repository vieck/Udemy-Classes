
public class InterruptedThread {

	public static void main(String[] args) throws InterruptedException{
		Thread thread1 = new Thread(new ThreadOne());
		Thread thread2 = new Thread(new ThreadTwo());
		thread1.start();
		thread2.start();
		thread1.interrupt();
		thread2.interrupt();
	}

}
