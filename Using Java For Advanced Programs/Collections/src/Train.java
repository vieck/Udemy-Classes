import java.util.Enumeration;
import java.util.Vector;


public class Train {

	private static void print(Enumeration train){
		while (train.hasMoreElements()){
			System.out.format("%s",train.nextElement());
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		Enumeration train;
		Vector trainCars = new Vector();
		trainCars.add("\t*\n  *  *\n []\n<|===|");
		for (int i = 0; i < 5; i++){
			trainCars.add("[----]");
		}
		trainCars.add("\n");
		for (int i = 0; i < 6; i++){
			trainCars.add(" o  o ");
		}
		train = trainCars.elements();
		print(train);
	}

}
