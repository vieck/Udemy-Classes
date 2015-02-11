import java.util.Scanner;


public class Calculate {
	
	static double a,b,c = 0;
	static double positiveAnswer, negativeAnswer = 0;
	
	private static void getNumbers(){
		Scanner scan = new Scanner(System.in);
		String one,two,three = "";
		System.out.println("Type in your quadratic equation: ");
		System.out.println("Enter a:");
		one = scan.nextLine();
		System.out.println("Enter b:");
		two = scan.nextLine();
		System.out.println("Enter c:");
		three = scan.nextLine();
		
		a = one.
	}
	
	private static void evaluatePositive(double a, double b, double c){
		double top, bottom = 0;
		top = -b + Math.sqrt(b - (a * c));
		bottom = 2 * a;
		positiveAnswer = top / bottom;
	}
	
	private static void evaluateNegative(double a, double b, double c){
		double top, bottom = 0;
		top = -b - Math.sqrt(b - (a * c));
		bottom = 2 * a;
		negativeAnswer = top / bottom;
	}
	
	private static void printAnswer(double negativeAnswer, double positiveAnswer){
		System.out.printf("Positive Answer: %d, Negative Answer: %d\n",positiveAnswer,negativeAnswer);
	}
	
	public static void main(String[] args){
		getNumbers();
		evaluateNegative(a, b, c);
		evaluatePositive(a, b, c);
		printAnswer(negativeAnswer,positiveAnswer);
	}
	
}
