import java.util.ArrayList;
import java.util.Scanner;


public class Sorter {
	
	private static ArrayList<String> userInput = new ArrayList<String>();
	
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
	
	private static void Count(ArrayList<String> array, String word){
		int count = 0;
		for (String arrayWord : array){
			if (arrayWord == word) { count++; }
		}
		System.out.printf("The word \"&s\" occurs %n times.",word,count);
	}
	
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
		boolean reverse = false;
		boolean alphabetize = false;
		boolean count = false;
		loop:
		while(in.hasNextLine()){
			input = in.nextLine();
			switch(input){
			case "-r":
				reverse = true;
				break loop;
			case "-a":
				alphabetize = true;
				break loop;
			case "-c":
				count = true;
				word = input.substring(2, input.length()-1);
				break loop;
			case "-q":
				break loop;
			case "-h":
				System.out.println("Need some help huh? "
						+ "Don't worry!\nThe commands for this program are: \n"
						+ "\"-q\": END INPUT INTO THE PROGRAM AND ECHO BACK\n"
						+ "\"-r\": REVERSE INPUT AND ECHO BACK\n"
						+ "\"-a\": ALPHABETIZE INPUT IN ACENDING ORDER AND ECHO BACK\n"
						+ "\"-c\" + \"word to be found\": FINDS OCCURANCES OF A SPECIFIC WORD AND GIVES COUNT\n");
				break;
			default:
				userInput.add(input.toLowerCase());
			}
		}
		if (reverse){
			Reverse(userInput);
			Print(userInput);
		} else if (count) {
			Count(userInput,word);
		} else if (alphabetize) {
			Alphabetize(userInput);
			Print(userInput);
		} else {
			Print(userInput);
		}
	}
	
}
