import java.util.Arrays;


public class ArrayManipulator {
	
	private static int fill(int i){
		i++;
		return i;
	}
	
	private static int[] multiply(int[] integerArray){
		//arrayLength is 10 but our array elements end at nine
		for (int i = 0; i < integerArray.length; i++){
			integerArray[i] = integerArray[i] * 5;
		}
		return integerArray;
	}
	
	private static int[] modulate(int[] integerArray){
		int count = integerArray.length-1;
		do {
			integerArray[count] = integerArray[count] % 5;
			count--;
		} while (count >= 0);
		return integerArray;
	}
	
	private static void print(int[] integerArray, String inputString){
		String array = Arrays.toString(integerArray);
		System.out.println(inputString + array);
	}
	
	public static void main(String[] args){
		int[] integerArray = new int[10];
		int i = 0;
		while(i < 10){
			integerArray[i] = fill(i);
			i++;
		}		
		
		String filled = "Filled Array ";
		print(integerArray,filled);
		
		String multiplied = "Multiplied Array ";
		integerArray = multiply(integerArray);
		print(integerArray, multiplied);
		
		String modulated = "Modulated Array ";
		integerArray = modulate(integerArray);
		print(integerArray, modulated);
	}
}
