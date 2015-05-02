import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;


public class ByteStream{

	public void byteReader() throws FileNotFoundException, IOException {
		BufferedReader reader = new BufferedReader(new FileReader("book.txt"));
		FileOutputStream output1 = new FileOutputStream("Output_One.txt");
		FileOutputStream output2 = new FileOutputStream("Output_Two.txt");
		ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
		String fileLine = "";
		while ((fileLine = reader.readLine()) != null){
			byteStream.writeTo(output1);
			byteStream.writeTo(output2);
			byteStream.flush();
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
