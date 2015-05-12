import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class FileReverser {

	private void readFile() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader("book.txt"));
		PrintWriter writer = new PrintWriter(new FileOutputStream("reader_output.txt"));
		try {
			String readFromFile = "";
			String writeToFile = "";
			
			while ((readFromFile = reader.readLine()) != null) {
				writeToFile = reverseWord(readFromFile);
				writer.write(writeToFile);
				writer.write("\n");
			}
		} finally {
			reader.close();
			writer.close();
		}
	}
	
	private String reverseWord(String fileLine){
		int len = fileLine.length();
		String reversed = "";
			for (int i = 0; i < len/2; i++) {
				char element = fileLine.charAt(len - i - 1);
				reversed += element;
			}
		return reversed;
	}
	
	public static void main(String[] args) throws IOException{
		FileReverser reverser = new FileReverser();
		reverser.readFile();
		System.out.println("Thank you for using my file reverser!");
	}
}
