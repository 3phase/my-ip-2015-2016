package org.elsysbg.ip.socket_project;

import java.util.HashMap;
import java.util.Map;

public class Register {

	private static Map<String, Integer[]> loggedUsers = new HashMap<>();
	
	public Register() {
		// TODO Auto-generated constructor stub
	}
	
	public void request_login(String username) {
		if (loggedUsers.get(username) == null) {
			create_user(username);
		}
		loggedUsers.get(username)[1] = 1;
		this.attends(username);
	}
	
	public void request_logout(String username) {
		if (check_if_logged(username) == 0) 
			return;
		try {
			loggedUsers.get(username)[1] = 0;
		} catch (Exception e) {
			System.out.println("No such username.");
		}
		
	}
	
	private void create_user(String username) {
		Integer[] userArray = new Integer[2];
		userArray[0] = 0; 	// login counter
		userArray[1] = 0;   // attendance bool
		try {
			loggedUsers.put(username, userArray);
		} catch (Exception e) {
			
		}
	}

	public int get_attendances(String username_checker, String username_checked) {
		if (check_if_logged(username_checker) == 0)
			return -1;
		try {
			return loggedUsers.get(username_checked)[0];
		} catch(Exception e) {
			System.out.println("Log with this username is unavilable");
			return -1;
		}
	}
	
	private void attends(String username) {
		try {
			++(loggedUsers.get(username)[0]);
		} catch (Exception e) {
			System.out.println("Log with this username is unavilable");
			return;
		}
	}
	
	private int check_if_logged(String username) {
		if (loggedUsers.get(username)[1] != 1) {
			System.out.println("You have to be logged in to view such information.");
			return 0;
		}
		return 1;
	}
	
}
