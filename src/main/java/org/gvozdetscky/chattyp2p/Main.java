package org.gvozdetscky.chattyp2p;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Name: ");
		String name = scanner.nextLine();

		System.out.print("Source port: ");
		int sourcePort = Integer.parseInt(scanner.nextLine());

		System.out.print("Destination IP: ");
		String destinationIP = scanner.nextLine();

		System.out.print("Destination port: ");
		int destinationPort = Integer.parseInt(scanner.nextLine());

		Channel channel = new Channel();
		channel.bind(sourcePort);
		channel.start();
		System.out.println("Started.");

		InetSocketAddress address = new InetSocketAddress(destinationIP, destinationPort);

		while (true) {
			String msg = scanner.nextLine();

			if (msg.isEmpty()) {
				break;
			}

			msg = name + " >> " + msg;

			channel.sendTo(address, msg);
			System.out.println(msg);
		}

		scanner.close();
		channel.stop();

		System.out.println("closed.");
	}
}
