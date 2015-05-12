import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class PokerHand {

	//Number One
	private static String[] rank = {"Ace","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Jack","Queen","King"};
	private static String[] suit = {"Spades","Clubs","Hearts","Diamonds"};
	private static List<String> deck = new ArrayList<String>(); // Generated to "" from 0 to 52
	private static List<String> hand = new ArrayList<String>();
	
	//Number Three
	public static void createDeck(){
		for (String tempRank : rank){
			for (String tempSuit : suit){
				deck.add(tempRank + " of " + tempSuit);
			}
		}
	}
	
	//Number Four
	public static void randomizeDeck(){
		Collections.shuffle(deck);
	}
	
	//Number Five
	public static void generateHand(int size){
		while (hand.size() < size){
			double randomNumber = (Math.random() * 52);
			int cardLocation = (int)(randomNumber);
			if (validCard(cardLocation)){
				hand.add(deck.get(cardLocation));
			}
		}
	}
	
	//Number Six
	public static boolean validCard(int location){
		boolean output = true;
		for (String handCard : hand){
			output = (deck.get(location) == handCard) ? false : true;
		}
		return output;
	}
	
	//Number Seven
	public static void print(){
		System.out.println("Your hand is:\n" + hand);
	}
	
	
	public static void main(String[] args) {
		//Number Two
		int handSize = 0;
		System.out.println("What size do you want your hand to be?");
		while (true){
			try {
				Scanner scan = new Scanner(System.in);
				handSize = scan.nextInt();
				break;
			} catch (InputMismatchException nfe){
				System.out.println("Input was not a valid number");
			}
		}
		
		//Number Eight
		createDeck();
		randomizeDeck();
		generateHand(handSize);
		print();
	}

}
