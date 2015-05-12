import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.util.UUID;


public class Serialize {

	public static void shipObject(BankAccount account) throws IOException{
		account.creatAccount();
		String fileExtension = "/" + account.name+".ser";
		FileOutputStream output = new FileOutputStream(fileExtension);
		ObjectOutputStream objOutput = new ObjectOutputStream(output);
		objOutput.writeObject(account);
		objOutput.flush();
		objOutput.close();
		System.out.println("The object is in: " + account.name + ".ser");
	}
	
	public static void main(String[] args) {
		BankAccount bank = new BankAccount();
		Scanner scan = new Scanner(System.in);
		System.out.println("Type in your name.");
		bank.name = scan.nextLine();
		System.out.println("Type in your email address.");
		bank.email = scan.nextLine();
		System.out.println("Type in a pin number.");
		bank.pin = scan.nextInt();
		UUID id = UUID.randomUUID();
		bank.account = id.toString();
		try {
			shipObject(bank);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
