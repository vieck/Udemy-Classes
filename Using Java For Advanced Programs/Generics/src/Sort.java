import java.util.Arrays;


public class Sort {

	private static <E extends Comparable<E>> Object[] organize (E[] array) {
		
		for (int i = 0; i < array.length; i++){
			for (int j = i + 1; j < array.length; j++){
				if (array[i].compareTo(array[j]) > 0){
					E element = array[i];
					array[i] = array[j];
					array[j] = element;
				}
			}
		}
		return array;
	}
	
	public static void main(String[] args) {
		Integer[] intArray = {4,10,2,5,1,-6};
		String[] strArray = {"CAT","APPLE","DOG"};
		Character[] word = {'N','A','D','Y'};
		System.out.println(""+Arrays.toString(organize(intArray)));
		System.out.println(""+Arrays.toString(organize(strArray)));
		System.out.println(""+Arrays.toString(organize(word)));
	}

}
