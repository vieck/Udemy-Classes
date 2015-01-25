import java.util.Scanner;


public class Reverser {

	private static String stringBuilder(String input){
		StringBuilder builder = new StringBuilder(input);
		String output = (builder.reverse()).toString();
		return output;
	}
	
	private static String reverse(String input){
		String output = "";
		for (int i = 0; i < input.length(); i++){
			//input="key" (y = input.length() - 1) (e and k = input.length() - 1 - i)
			char letter = input.charAt(input.length() - 1 - i);
			output += letter;
		}
		return output;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		String output = reverse(input);
		System.out.println("Before: "+input);
		System.out.println("After: "+output);
		
		output = stringBuilder(input);
		System.out.println("Builder Output: "+output);
	}

}
