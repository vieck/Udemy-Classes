import java.util.Arrays;


public class Operators {

	public static void main(String[] args) {
		int firstInt = 20;
		int secondInt = 10;
		int add;
		int minus;
		int division;
		int multiplication;
		
		//Arithmetic operators: +,-,/,*
		add = firstInt + secondInt;
		minus = firstInt - secondInt;
		division = firstInt / secondInt;
		multiplication = firstInt * secondInt;
		int modulus = 5 % 4;
		
		int[] results = new int[4];
		results[0] = add;
		results[1] = minus;
		results[2] = division;
		results[3] = multiplication;
		String converted = Arrays.toString(results);
		System.out.println(converted);
		
		String[] animals = {"Dog","Cat","Pony","Horse"};
		Arrays.sort(animals);
		String animalsString = Arrays.toString(animals);
		System.out.println(animalsString);
	}
}
