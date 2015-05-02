import java.util.Scanner;


public class Fibonacci {
	
	static int fib(int number){
		if (number == 0){
			return 0;
		} else if (number == 1){
			return 1;
		} else {
			return fib(number - 1) + fib(number - 2);
		}
	}
	
	public static void main(String[] args){
		System.out.println("Enter a number to compute");
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		System.out.println("The fibonacci number is: "+fib(n));
	}
}
