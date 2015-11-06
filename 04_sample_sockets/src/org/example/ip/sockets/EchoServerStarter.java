package org.example.ip.sockets;

import java.io.IOException;

public class EchoServerStarter {

	private static final int SERVER_PORT = 51691;

	public static void main(String[] args) throws IOException {
		final EchoServer server = new EchoServer(SERVER_PORT);
		server.startServer();
	}

}
