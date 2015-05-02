import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.zip.DeflaterOutputStream;


public class Zipper {
	
	public String file = "";
	
	public Zipper(String file){
		this.file = file;
	}
	
	public void zip(){
		try {
			FileInputStream inputStream = new FileInputStream("book.txt");
			DeflaterOutputStream deflaterStream = new DeflaterOutputStream(new FileOutputStream("File.zip"));
			int i = 0;
			while ((i =inputStream.read()) != -1){
				deflaterStream.write((byte) i);
				deflaterStream.flush();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO: handle exception
		}
	}
	
	public void unzip(){
		
	}
	
	public static void main(String[] args) {
		System.out.println("Type in the name of the file.");
		Scanner scan = new Scanner(System.in);
		Zipper gunzip = new Zipper(scan.nextLine());
		System.out.println("Enter -z to zip file or -u to unzip file");
		String command = scan.nextLine();
		if (command.contains("-z")){
			gunzip.zip();
		} else if (command.contains("-u")){
			gunzip.unzip();
		} else {
			System.out.println("Invalid Command");
		}
	}

}
