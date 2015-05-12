import java.util.Scanner;
import java.util.Stack;


public class StackCalculator {
	/*
	Stack<Character> stack = new Stack<Character>();
	String line = "";
	
	public StackCalculator(String line) {
		this.line = line;
	}
	
	private void addToStack(){
		for (int i = 0; i < line.length(); i++){
			stack.push(line.charAt(i));
		}
	}
	
	private char compute(char c) {
		if (stack.size() == 1){
			return stack.pop();
		} else if (stack.size() < 3){
			return ' ';
		}else {
			char b = stack.pop();
			switch (b){
			case ')':
				
				break;
			case '*':
				char a = stack.pop();
				int a = Integer.parseInt(a);
				stack.push(a * c);
				break;
			case '/':
				
			case '+':
				
				break;
			case '-':
				
				break;
			
				
			default:
				compute(c);
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.println("Enter in a single digit equation to be solved.\n"
				+ "Example: 3 * (8 / 7) + 1");
		Scanner scan = new Scanner(System.in);
		StackCalculator calculator = new StackCalculator(scan.nextLine());
		calculator.addToStack();
		calculator.compute();
		
	}

	
**/
}
