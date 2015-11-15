package org.elsysbg.ip.socket_project;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {	 
	
	public static void main(String[] args) {
		Map<String, String> userMeta = new HashMap<>();
		Parse parser = new Parse();
		Scanner in = new Scanner(System.in);
		while (in.hasNextLine()) {
			userMeta = parser.parse(in.nextLine());
			if ("shutdown" == userMeta.get("command"))
				break;
		}
		
		in.close();
	}
	
}