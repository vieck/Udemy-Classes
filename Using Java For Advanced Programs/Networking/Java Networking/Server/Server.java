import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Arrays;

public class Server implements Runnable {
	public final String[] commands = { ":GET_ADDRESS", ":GET_PORT", ":SPEAK",
			":QUIT", ":REVERSE" };
	protected ServerSocket serverSocket;
	protected Thread currentThread;
	protected boolean isRunning = true;
	protected final int TIMEOUT = 300000;
	protected int port;

	public Server(int port) throws IOException {
		this.port = port;
	}

	public void run() {
		synchronized (this) {
			this.currentThread = Thread.currentThread();
		}
		openServerSocket();
		while (isRunning) {
			Socket connection;
			try {
				connection = serverSocket.accept();
				
			} catch (IOException e) {
				if(!isRunning){
					System.out.println("Server halted.");
					return;
				}
				throw new RuntimeException("Connection failed.");
			}
			System.out.println("Client connected");
			processRequest(connection);
			
		}
		System.out.println("Server Ended");
	}

	public void processRequest(Socket connection) {
		try {
			DataInputStream reader = new DataInputStream(connection.getInputStream());
			DataOutputStream writer = new DataOutputStream(connection.getOutputStream());
			String input = reader.readUTF();
			if (input.equals(commands[0])) {
				writer.writeUTF("The server address is "
						+ connection.getInetAddress().getHostAddress());
				writer.flush();
			} else if (input.equals(commands[1])) {
				writer.writeUTF("The server port is " + connection.getPort());
				writer.flush();
			} else if (input.equals(commands[2])) {
				writer.writeUTF("Here's Johnny!!!");
				writer.flush();
			} else if (input.equals(commands[3])) {
				writer.writeUTF("Goodbye!");
				writer.flush();
				connection.close();
			} else if (input.equals(commands[4])) {
				String s = reader.readUTF();
				StringBuilder builder = new StringBuilder(s);
				builder.reverse();
				String output = builder.toString();
				writer.writeUTF(output);
				writer.flush();
			} else if (input.contains("-c")) {
				System.out.println("-c");
				String output = Arrays.toString(commands);
				writer.writeUTF(output);
				writer.flush();
			} else {
				writer.writeUTF("Invalid Command");
				writer.flush();
			}
			return;
		} catch (SocketTimeoutException e) {
			System.out.println("Client Timed Out");
		} catch (IOException e) {
			System.out.println("IO Exception with input.");
			return;
		}
	}

	@SuppressWarnings("unused")
	private synchronized boolean isRunning() {
		return this.isRunning;
	}

	public synchronized void stop() {
		this.isRunning = false;
		try {
			this.serverSocket.close();
		} catch (IOException e) {
			throw new RuntimeException("Error closing server", e);
		}
	}
	
	 private void openServerSocket() {
	        try {
	            this.serverSocket = new ServerSocket(this.port);
	        } catch (IOException e) {
	            throw new RuntimeException("Cannot open port: "+this.port, e);
	        }
	    }

	public static void main(String[] args) {
		try {
			Server server = new Server(Integer.parseInt(args[0]));
			new Thread(server).start();
			try {
				Thread.sleep(40000);
			} catch (InterruptedException e) {
				System.out.println("Thread Interrupted");
			}
			server.stop();
		} catch (IOException e) {
			System.out.println("Input problem");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out
					.println("The format of this program is java Server {port}");
		}
	}
}
