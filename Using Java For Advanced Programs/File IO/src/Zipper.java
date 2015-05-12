import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;


public class Zipper {
	
	public String file = "";
	
	public Zipper(String file){
		this.file = file;
	}
	
	public void zip(){
		try {
			
			FileInputStream inputStream = new FileInputStream(file);
			ZipOutputStream zipStream = new ZipOutputStream(new FileOutputStream("newfile.zip"));
			ZipEntry entry = new ZipEntry(file);
			zipStream.putNextEntry(entry);
			int i = 0;
			while ((i =inputStream.read()) != -1){
				zipStream.write((byte) i);
				zipStream.flush();
			}
			inputStream.close();
			zipStream.closeEntry();
			zipStream.close();
			System.out.format("The file %s was zipped.\n",file);
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("IO Exception");
		}
	}
	
	public void unzip(){
		try {
			ZipInputStream zipStream = new ZipInputStream(new FileInputStream(file));
			ZipEntry entry = zipStream.getNextEntry();
			while (entry != null){
				file = entry.getName();
				File newFile = new File(file);
				FileOutputStream output = new FileOutputStream(newFile);
				int l;
				while ((l = zipStream.read()) > 0){
					output.write(l);
					output.flush();
				}
				output.close();
				entry = zipStream.getNextEntry();
			}
			zipStream.close();
			System.out.println(file + " unzipped.");
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e){
			System.out.println("IO Exception");
		}
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
