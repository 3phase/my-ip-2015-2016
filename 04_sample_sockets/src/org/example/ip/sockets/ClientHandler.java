package org.example.ip.sockets;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientHandler implements Runnable {

	private final Socket socket;
	private static final String SERVER_STOP_COMMAND = "stopServer";
	private final EchoServer echoServer;
	
	public ClientHandler(Socket socket, EchoServer echoServer) {
		this.socket = socket;
		this.echoServer = echoServer;
	}
	
	@Override
	public void run() {
		try {
			final PrintStream out = new PrintStream(socket.getOutputStream()); 
			final Scanner scanner = new Scanner(socket.getInputStream());
			
			while (scanner.hasNextLine()) {
				final String line = scanner.nextLine();
				if (SERVER_STOP_COMMAND.equals(line)) {
					echoServer.stopServer();
					break;
				}
				out.println(line);
			}
			
			scanner.close();
			out.close();
		} catch (Exception e) {
			//	TODO check if cloesd before printing error
			e.printStackTrace();
		}
		finally {		// Immer angeruft
			echoServer.onClientStopped(this);
		}
	}
	
	public synchronized void stopClient() throws IOException {
		socket.close();
		//	TODO add variable closed
	}
	
}
