
public class ThreadTwo extends Thread{
	
	public void run() {
		System.out.println("Thread Two");
		try {
			for (int i = 0; i < 10; i++){
				System.out.print("Running Two");
				Thread.sleep(100);
				System.out.print(".");
				Thread.sleep(100);
				System.out.print(".");
				Thread.sleep(100);
				System.out.print(". ");
				Thread.sleep(300);
			}
			System.out.println();
		} catch (InterruptedException exception){
			System.out.println();
			System.out.println("Thread Two Interrupted ");
		}
		System.err.println("Thread Two Done");
	}
}
