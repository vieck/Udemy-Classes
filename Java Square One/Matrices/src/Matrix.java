import java.util.InputMismatchException;
import java.util.Scanner;


public class Matrix {

	public String[][] fillMatrix(String[][] array2d){
		for (int m = 0; m < array2d.length; m++){
			for (int n = 0; n < array2d[m].length; n++){
				array2d[m][n] = "x";
			}
		}
		return array2d;
	}
	
	public void printMatrix(String[][] array2d){
		for (int i = 0; i < array2d.length; i++){
			for (int j = 0; j < array2d[i].length; j++){
				System.out.print(array2d[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		
		String[][] table;
		int row = 0;
		int column = 0;
		
		Scanner scan = new Scanner(System.in);
		try {
		System.out.println("Type the number of rows: ");
		row = scan.nextInt();
		System.out.println("Type the number of columns: ");
		column = scan.nextInt();
		} catch(InputMismatchException nfe){
			System.out.println("Invalid Number");
		}
		table = new String[row][column];
		Matrix matrix = new Matrix();
		table = matrix.fillMatrix(table);
		matrix.printMatrix(table);
	}

}
