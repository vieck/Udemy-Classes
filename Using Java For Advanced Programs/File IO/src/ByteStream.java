import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class ByteStream{

	public void byteReader() throws FileNotFoundException, IOException {
		FileInputStream input = new FileInputStream("book.txt");
		FileOutputStream output = new FileOutputStream("byte_output.txt");
		
		int n = 0;
		while ((n = input.read()) != -1){
			output.write(n);
			output.flush();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			ByteStream byteStream = new ByteStream();
			byteStream.byteReader();
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found");
		} catch (IOException e) {
			System.out.println("IOException");
		}
	}

}
