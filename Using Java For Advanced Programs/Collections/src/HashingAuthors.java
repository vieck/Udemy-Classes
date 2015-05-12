import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;


public class HashingAuthors {

	private <E> void printMap(Set<E> entrySet){
		Iterator<E> iterator = entrySet.iterator();
		while(iterator.hasNext()){
			E entry = iterator.next();
			System.out.println(entry);
		}
	}
	
	public static void main(String[] args) {
		Map<String, List<String>> hashmap = new HashMap<String, List<String>>();
		System.out.println("Enter in the author's last name and book seperated by a space. Type -q to end input.");
		Scanner scan = new Scanner(System.in);
		while(scan.hasNextLine()){
			String input = scan.nextLine();
			if (input.contains("-q")){
				break;
			}
			String[] entry = new String[2];
			entry[0] = input.substring(0,input.indexOf(' '));
			entry[1] = input.substring(input.indexOf(' ') + 1);
			List<String> entryList = new ArrayList<String>();
			if (hashmap.containsKey(entry[0])){
				entryList = hashmap.get(entry[0]);
				entryList.add(entry[1]);
				hashmap.put(entry[0], entryList);
			} else {
				entryList.add(entry[1]);
				hashmap.put(entry[0], entryList);
			}
		}
		
		HashingAuthors authors = new HashingAuthors();
		Set entrySet = hashmap.entrySet();
		authors.printMap(entrySet);
		
	}

}
