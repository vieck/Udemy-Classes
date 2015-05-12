import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


public class Client{
	static String host;
	static String command;
	static String reply;
	static int port;
	public static void main(String[] args) throws IOException{
		host = args[0];
		port = Integer.parseInt(args[1]);
		Socket client = new Socket(host, port);
		System.out.println("Enter in your command. Type -c for a list of commands and -q to quit.");
		Scanner scan = new Scanner(System.in);
		while (scan.hasNextLine()) {
			command = scan.nextLine();
			if(command.contains("-q")){
				client.close();
				break;
			} else {
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					client.getInputStream()));
			PrintWriter writer = new PrintWriter(new OutputStreamWriter(
					client.getOutputStream()), true);
			writer.write(command);
			reply = reader.readLine();
			System.out.printf(
					"Your command was %s and the server sent back %s\n",
					command, reply);
			}
		}
	}

}
