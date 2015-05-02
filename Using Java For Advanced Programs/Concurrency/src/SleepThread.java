
public class SleepThread{

	public static void main(String[] args) throws Exception{
		Thread thread1 = new Thread(new ThreadOne());
		Thread thread2 = new Thread(new ThreadTwo());
		thread1.run();
		thread2.run();
	}

}
