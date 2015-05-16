import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	static String host;
	static String command;
	static String reply;
	static int port;

	public static void main(String[] args) {
		try {
			host = args[0];
			port = Integer.parseInt(args[1]);
			Socket client = new Socket(host, port);
			System.out
					.println("Enter in your command. Type -c for a list of commands and -q to quit.");
			Scanner scan = new Scanner(System.in);
			DataInputStream reader = new DataInputStream(
					client.getInputStream());
			DataOutputStream writer = new DataOutputStream(
					client.getOutputStream());
			while (client.isConnected()) {
				if (scan.hasNextLine()) {
					command = scan.nextLine();
					if (command.contains("-q")) {
						writer.writeUTF("-q");
						client.close();
						break;
					} else {
						writer.writeUTF(command);
						writer.flush();
						System.out.println("success");
						reply = reader.readUTF();
						System.out.format("Your command was %s with response: %s\n",
										command, reply.toString());
					}
				}
			}
		} catch (IOException e) {
			System.out.println("Client couldn't connect to the server.");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("The correct format is java Client {host} {port}");
		}

	}
}
