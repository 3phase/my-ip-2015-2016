package org.elsysbg.ip.socket_project;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Register {

	private static Map<String, Integer[]> loggedUsers = new HashMap<>();
	
	public Register() {
		// TODO Auto-generated constructor stub
	}
	
	public void request_login(String username) {
		if (loggedUsers.get(username) == null) {
			create_user(username);
		}
		if (loggedUsers.get(username)[1] != 1) {
			loggedUsers.get(username)[1] = 1;
			this.attends(username);
		}
		System.out.println("ok");
	}
	
	public void request_logout(String username) {
		if (check_if_logged(username) == 0) 
			return;
		try {
			loggedUsers.get(username)[1] = 0;
		} catch (Exception e) {
			System.out.println("No such username.");
		}
		System.out.println("ok");
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

	public Integer get_attendances(String username_checker, String username_checked) {
		if (check_if_logged(username_checker) == 0)
			return -1;
		try {
			Integer result = loggedUsers.get(username_checked)[0];
			return result;
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
	
	private Integer check_if_logged(String username) {
		if (loggedUsers.get(username)[1] == 0) {
			return 0;
		}
		return 1;
	}

	public void get_absent() {
		for (Entry<String, Integer[]> entry : loggedUsers.entrySet()) {
			String key = entry.getKey();
			Integer[] iterable = entry.getValue();
			if (iterable[1] == 0) {
				System.out.println("Absent: " + key);
			}
			
		}
		
	}
	
}
