package org.elsysbg.ip.socket_project;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Parse {

	private String parsedString = "";
	private Map<String, Runnable> funcMap = new HashMap<>();
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String st = in.nextLine();
		Parse p = new Parse(st);
		p.parse();
		in.close();
	}
	
	public Parse(String s) {
		this.parsedString = s;
	}
	
	public String parse() {
		funcMap.put("login", () -> login());
		funcMap.put("logout", () -> logout());
		funcMap.put("info", () -> info());
		funcMap.put("listavilable", () -> listavilable());
		funcMap.put("shutdown", () -> shutdown());
		try {
			
		} catch (Exception e) {
			System.out.println("Exception " + e + " caught.");
		}
		return parsedString;
	}

	private void shutdown() {
		// TODO Auto-generated method stub
	}


	private void listavilable() {
		// TODO Auto-generated method stub
	}


	private void info() {
		// TODO Auto-generated method stub
	}


	private void logout() {
		// TODO Auto-generated method stub
	}


	private void login() {
		
	}
	
}