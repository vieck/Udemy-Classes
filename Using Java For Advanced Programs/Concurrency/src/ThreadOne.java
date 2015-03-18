
public class ThreadOne implements Runnable {

	public void run() {
		System.out.println("Thread One");
		try {
			for (int i = 0; i < 5; i++){
				System.out.print("Running One");
				Thread.sleep(50);
				System.out.print(".");
				Thread.sleep(50);
				System.out.print(".");
				Thread.sleep(50);
				System.out.print(". ");
				Thread.sleep(10);
				}
			System.out.println();
		} catch (InterruptedException exception){
			System.out.println();
			System.out.println("Thread One Interrupted ");
		}
		System.err.println("Thread One Done");
	}

}
