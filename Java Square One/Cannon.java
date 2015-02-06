import java.util.Random;
import java.util.Scanner;


public class Cannon {

	//String soldierName;
	public String soldier;
	
	public Cannon(String soldier) {
		this.soldier = soldier;
		System.out.println("Soldier "+soldier);
	}

	private void fire(){
		String fire = "fire!";
		System.out.println(fire);
	}
	
	private String reload(){
		String reloadOutput = "reloading...";
		return reloadOutput;
	}
	
	private String misfire(){
		return "misfire!";
	}
	
	/*
	 * Modifiers
	 * 1.) Public: accessible in other Java classes and everywhere
	 * 2.) Protected: accessible only in current class and sub-classes
	 * 3.) No Modifier: having access only in the current class with special permissions
	 * 4.) Private: having access only in the current class
	 * 
	 * Return
	 * (Can be any single type)
	 * 1.) Void: Nothing is returned
	 * 
	 * Parameters
	 * (Can be any single type)
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Random objRandom = new Random();
		int randomNumber = objRandom.nextInt(5);
		String soldier = scan.nextLine();
		Cannon objCannon = new Cannon(soldier);
		System.out.println(objCannon.reload());
		System.out.println(objCannon.reload());
		System.out.println(objCannon.reload());
		
		/*
		 * If-Else Syntax
		 * If (boolean is true) {
		 *   //Code is executed
		 * } else {
		 *   //Code is executed if the boolean is false
		 * }
		 */
		if (randomNumber <= 2){
			objCannon.fire();
		} else {
			System.out.println(objCannon.misfire());
		}		
	}

}
