package com.vendingmachine.config;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketTimeoutException;

public class DockerIsSocketAlive {

	public static void main(String[] args) {
		 
		// Run Apache Tomcat server on Port 8080 in Eclipse to see success
		// result
		log(isSocketAliveUitlitybyCrunchify("localhost", 8080));
 
		// Now change port to 8081 and you should see failure
		log(isSocketAliveUitlitybyCrunchify("localhost", 8081));
 
		// Connect to docker on port 80
		log(isSocketAliveUitlitybyCrunchify("localhost", 80));
 
		// Connection to docker on port 5000
		log(isSocketAliveUitlitybyCrunchify("localhost", 5000));
		
		// Connect to docker on port 80
		log(isSocketAliveUitlitybyCrunchify("localhost", 9000));
	}
	
 
	/**
	 * Crunchify's isAlive Utility
	 * 
	 * @param hostName
	 * @param port
	 * @return boolean - true/false
	 */
	public static boolean isSocketAliveUitlitybyCrunchify(String hostName, int port) {
		boolean isAlive = false;
 
		// Creates a socket address from a hostname and a port number
		SocketAddress socketAddress = new InetSocketAddress(hostName, port);
		Socket socket = new Socket();
 
		// Timeout required - it's in milliseconds
		int timeout = 2000;
 
		log("hostName: " + hostName + ", port: " + port);
		try {
			socket.connect(socketAddress, timeout);
			socket.close();
			isAlive = true;
 
		} catch (SocketTimeoutException exception) {
			System.out.println("SocketTimeoutException " + hostName + ":" + port + ". " + exception.getMessage());
		} catch (IOException exception) {
			System.out.println(
					"IOException - Unable to connect to " + hostName + ":" + port + ". " + exception.getMessage());
		}
		return isAlive;
	}
 
	// Simple log utility
	private static void log(String string) {
		System.out.println(string);
	}
 
	// Simple log utility returns boolean result
	private static void log(boolean isAlive) {
		System.out.println("isAlive result: " + isAlive + "\n");
	}
}
