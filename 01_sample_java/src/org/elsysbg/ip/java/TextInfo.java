package org.elsysbg.ip.java;

import java.io.PrintStream;
import java.util.Scanner;

public class TextInfo {

	public static void main(String[] args) {
		System.out.println("Enter your name, please: ");
		final Scanner in = new Scanner(System.in);
		final String name = in.next();
		System.out.printf("Hello, %s.", name);
		// Immer schliesen der Output aus !
		in.close();
		// F4 - checks the hierarchy of the class
		PrintStream a = System.out;
	}
	
	
}
