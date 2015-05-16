import java.util.Scanner;


public class Plotter {

	public static < T > void  printArray( T[] array ){
		for ( T block : array) {
			System.out.printf("%s " , block);
		}
		System.out.println("");
	}
	
	public static void main(String[] args) {
		Integer[] iArray = {1,2,3,4};
		String[] sArray = {"Hello","My","Friends","Goodbye"};
		Double[] dArray = {1.0,2.0,3.0,4.0};
		Character[] cArray = {'K','i','t','t','y'};
		System.out.print("Integer Array:");
		printArray(iArray);
		System.out.print("String Array:");
		printArray(sArray);
		System.out.print("Double Array:");
		printArray(dArray);
		System.out.print("Char Array:");
		printArray(cArray);
	}

}
