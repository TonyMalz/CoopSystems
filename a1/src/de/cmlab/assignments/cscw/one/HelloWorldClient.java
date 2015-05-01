package de.cmlab.assignments.cscw.one;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class HelloWorldClient {
	public static void main(String[] args) {
		try (Socket server = new Socket(InetAddress.getLocalHost(),
				HelloWorldServer.PORT)) {
			for (int i = 0; i < 10; i++) {
				server.getOutputStream().write("Hello Server!\n".getBytes());
				Thread.sleep(1000);
			}
			server.getOutputStream().write("EXIT\n".getBytes());
		} catch (IOException | InterruptedException e) {
			System.err.println(e.getMessage());
		}
	}
}
