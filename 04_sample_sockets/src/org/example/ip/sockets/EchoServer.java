package org.example.ip.sockets;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class EchoServer {

	private final int port;
	private boolean running;
	private List<ClientHandler> clients = 
			Collections.synchronizedList(new LinkedList<ClientHandler>());
	
	public EchoServer(int port) {
		this.port = port;
		this.running = running;
	}
	
	public void startServer() throws IOException {
		setRunning();
		final ServerSocket serverSocket = new ServerSocket(port);
		
		while (isRunning()) {
			final Socket socket = serverSocket.accept();
			
			final ClientHandler client = new ClientHandler(socket, this);
			new Thread(client).start();
//			client.run();
		}
		
		serverSocket.close();
		
	}
	
	private synchronized void setRunning() {
		if (running) {
			throw new IllegalStateException("Already running");
		}
		running = false;
	}
	
	public synchronized boolean isRunning() {
		return running;
	}
	
	public synchronized void stopServer() {
		running = false;
		
		for (ClientHandler next : clients) {
			clients.stopClient();
		}
	}
	
	public synchronized void onClientStopped(ClientHandler handler) {
		clients.remove(clientHandler);
	}
	
}
