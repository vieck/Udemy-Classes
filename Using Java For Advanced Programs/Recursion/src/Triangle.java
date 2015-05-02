import java.util.Scanner;


public class Triangle {

	static int compute(int x, int y){
		if (y == 0){
			return 1;
		} else if (x == y){
			return 1;
		} else {
			return compute(x-1,y-1) + compute(x-1,y);
		}
	}

	static void print(int n) {
		for (int i = 0; i < n; i++){
			System.out.format("%"+(n-i)*2+"s","");
			for (int j = 0; j <= i; j++) {
				System.out.format("%4d",compute(i,j));
			}
			System.out.println();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("What row would you like to compute?");
		Scanner scan = new Scanner(System.in);
		int number = scan.nextInt();
		print(number);
	}
}
