import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.AsynchronousByteChannel;
import java.nio.channels.Channel;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.Scanner;

import javax.imageio.ImageIO;

import com.sun.org.apache.xerces.internal.impl.io.MalformedByteSequenceException;


public class Downloader {

	URL link = null;
	
	public Downloader(URL link){
		this.link = link;
	}
	
	public void download() {
		try {
		Image image = ImageIO.read(link);
		Graphics g2D = image.getGraphics();
		Canvas canvas = new Canvas();
		canvas.print(g2D);
		g2D.dispose();
		} catch (IOException exp){
			System.out.println("IOEXCEPTION");
		}
	}
	
	public static void main(String[] args) {
		System.out.println("Enter your URL image link");
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		try {
		URL url = new URL(input);
		Downloader downloader = new Downloader(url);
		downloader.download();
		} catch (MalformedURLException exception){
			System.out.println("Malformed URL Exception");
		}
	}
}
