package de.cmlab.assignments.cscw.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class HelloWorldServer {
	public static final int PORT = 5555;

	public static void main(String[] args) {
		System.out.println("Starting server at port " + PORT);
		BufferedReader socketReader = null;
		try (ServerSocket server = new ServerSocket(PORT)) {
			boolean exit = false;
			while (!exit) {
				Socket client = server.accept();
				System.out.println("Client connected from: "
						+ client.getRemoteSocketAddress());
				socketReader = new BufferedReader(new InputStreamReader(
						client.getInputStream()));
				String msg = null;
				while ((msg = socketReader.readLine()) != null) {
					if (msg.equals("EXIT")) {
						exit = true;
						break;
					}
					System.out.println(msg);
				}
			}
		} catch (IOException e) {
			System.err.println(e.getMessage());
		} finally {
			System.out.println("Shutting down...");
			if (socketReader != null) {
				try {
					socketReader.close();
				} catch (IOException e) {
					System.err.println(e.getMessage());
				}
			}
		}
		System.out.println("DONE");

	}
}
