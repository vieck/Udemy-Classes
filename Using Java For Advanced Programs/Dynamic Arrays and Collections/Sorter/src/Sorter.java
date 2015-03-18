import java.util.ArrayList;
import java.util.Scanner;


public class Sorter {

	private static ArrayList<String> userInput = new ArrayList<String>();

	/**
	 * Number One
	 */
	private static void Reverse(ArrayList<String> array){
		for (int i = 0; i  < array.size(); i++){
			String element = array.get(i);
			String setter = "";
			for (int k = 0; k < element.length(); k++){
				char tempLetter = element.charAt(element.length() - k - 1);
				setter += tempLetter;
			}
			array.set(i, setter);
		}
	}

	/**
	 * Number Two
	 */
	private static void Alphabetize(ArrayList<String> array){
		int arrayLength = array.size();
		for (int i = 0; i < arrayLength; i++){
			int minIndex = i;
			for (int j = i+1; j < arrayLength; j++){
				String indexI = array.get(i);
				String indexJ = array.get(j);
				if (indexJ.compareTo(indexI) < 0){
					minIndex = j;
				}
			}
			String tempHold = array.get(i);
			array.set(i,array.get(minIndex));
			array.set(minIndex, tempHold);
		}
		userInput = array;
	}

	/**
	 * Number Three
	 */
	private static void Print(ArrayList<String> userInput){
		for (String line : userInput){
			System.out.println(line);
		}
	}

	public static void main(String[] args) {
		System.out.println("Type your input. Enter in \"-h\" if you need help.");
		Scanner in = new Scanner(System.in);
		String input = "";
		String word = "";
		
		//Number Four
		
		boolean reverse = false;
		boolean alphabetize = false;
		while(in.hasNextLine()){
			input = in.nextLine();
			if (input.contains("-r")){
				reverse = true;
				break;
			}else if (input.contains("-a")){
				alphabetize = true;
				break;
			} else if (input.contains("-q")) {
				break;
			} else if (input.contains("-h")){
				System.out.println("Need some help huh? "
						+ "Don't worry!\nThe commands for this program are: \n"
						+ "\"-q\": END INPUT INTO THE PROGRAM AND ECHO BACK\n"
						+ "\"-r\": REVERSE INPUT AND ECHO BACK\n"
						+ "\"-a\": ALPHABETIZE INPUT IN ACENDING ORDER AND ECHO BACK\n");
			} else {
				userInput.add(input.toLowerCase());
			}    
		}
		in.close();
		if (reverse){
			Reverse(userInput);
			Print(userInput);
		} else if (alphabetize) {
			Alphabetize(userInput);
			Print(userInput);
		} else {
			Print(userInput);
		}
		System.out.println("---------------------------");
		System.out.println("Thank you for using Sorter.");
		System.out.println("---------------------------");
	}
}
