package org.elsysbg.ip.socket_project;

import java.util.HashMap;
import java.util.Map;

public class Reference {
	
	private Map<String, String> userMeta = new HashMap<>();
	private Map<String, Runnable> funcMap = new HashMap<>();
	private Register studentRegister = new Register();
	
	public Reference() {
		funcMap.put("login", () -> login());
		funcMap.put("logout", () -> logout());
		funcMap.put("info", () -> info());
		funcMap.put("listavilable", () -> listavilable());
		funcMap.put("shutdown", () -> shutdown());
		funcMap.put("listabsent", () -> listabsent());
		
	}
	
	public void make_reference(Map<String, String> user) {
		this.userMeta = user;
		try {
			funcMap.get(userMeta.get("command")).run();
		} catch (Exception e) {
			System.out.println("Make sure that you have passed a valid argument.");
		}
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
	
	private void listabsent() {
		studentRegister.get_absent(userMeta.get("username"));
	}

}
