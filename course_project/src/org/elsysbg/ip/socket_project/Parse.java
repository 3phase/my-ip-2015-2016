package org.elsysbg.ip.socket_project;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Parse {

	private String stringToParse;
	private Map<String, String> userMeta = new HashMap<>();
	private Map<String, Runnable> funcMap = new HashMap<>();
	private Register studentRegister = new Register();
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String st = in.nextLine();
		Parse p = new Parse();
		p.parse(st);
		in.close();
	}
	
	public Parse() {
		funcMap.put("login", () -> login());
		funcMap.put("logout", () -> logout());
		funcMap.put("info", () -> info());
		funcMap.put("listavilable", () -> listavilable());
		funcMap.put("shutdown", () -> shutdown());
	}
	
	public Map<String, String> parse(String s) {
		this.stringToParse = s;
		this.split();
		try {
			funcMap.get(userMeta.get("command")).run();
		} catch (Exception e) {
			System.out.println("Make sure that you have passed a valid argument.");
		}
		return userMeta;
	}
	
	private void split() {
		String[] parts = stringToParse.split(":"); 
		userMeta.put("username", parts[0]);
		userMeta.put("command", parts[1]);
		if (parts.length > 2 && parts[2] != null)
			userMeta.put("checked_username", parts[2]);
	}

	private void shutdown() {
		// TODO Auto-generated method stub
	}


	private void listavilable() {
		// TODO Auto-generated method stub
	}


	private void info() {
		System.out.println(studentRegister.get_attendances(userMeta.get("username"), 
				userMeta.get("checked_username")));
	}


	private void logout() {
		studentRegister.request_logout(userMeta.get("username"));
	}


	private void login() {
		studentRegister.request_login(userMeta.get("username"));
	}
	
}