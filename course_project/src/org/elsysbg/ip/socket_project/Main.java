package org.elsysbg.ip.socket_project;

import java.util.Scanner;

public class Main {	 
	
	public static void main(String[] args) {
		Parse parser = new Parse();
		Scanner in = new Scanner(System.in);
		parser.parse(in.nextLine());
		in.close();
	}
	
}