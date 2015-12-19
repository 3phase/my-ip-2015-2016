package org.elsysbg.ip.socket_project;

import java.util.*;

public class Main {
	
	private static HashMap<String, int[]> loggedUsers = new HashMap<String, int[]>();

	public static void main(String[] args) {
		String s;		
		String second_param = null;
		System.out.println("Въведете команда: ");
		Scanner in = new Scanner(System.in);
		while (!"shutdown".equals(second_param)) {
			String[] ct = in.nextLine().split(":");
			second_param = ct[1];
			switch (second_param) {
				case "login":
					if (!checkIfLogged(ct[0])) {
						System.out.println("You are going to be logged in a few minutes");
						requestLogin(ct[0]);
					}
					break;
				case "logout":
					if (checkIfLogged(ct[0])) {
						requestLogout(ct[0]);
					} else {
						System.out.println("You have to be logged in first");
					}
					break;
				case "info":
					if (ct[2] == null) {
						System.out.println("Third parameter should be passed");
					} else {
						if (!checkIfLogged(ct[0]) || !checkIfLogged(ct[2])) {
							System.out.println("Users have to be logged in first");
						} else {
							int[] usrInfo = loggedUsers.get(ct[2]);
							System.out.println("Count of logins of user " + ct[2] + ": " + usrInfo[1]);
						}
					}
					break;
				case "listavilable":
					for (String key : loggedUsers.keySet()) {
						int[] usrInfo = loggedUsers.get(key);
						System.out.println("Count of logins of user " + key + ": " + usrInfo[1]);
					}
					break;
				case "shutdown":
					System.out.println("ok");
					//	break;
					break;
				default:
					System.out.println("error:unknown command");
					break;
			}
		}
	}

	private static void requestLogout(String string) {
		int[] userArray = loggedUsers.get(string);
		userArray[0] = 0;
		System.out.println("ok");
	}

	private static void requestLogin(String string) {
		int[] userArray = loggedUsers.get(string);
		userArray[0] = 1;
		userArray[1] += 1;
		System.out.println("ok");
	}

	private static boolean checkIfLogged(String string) {
		if (loggedUsers.get(string) != null) {
			int[] userArray = loggedUsers.get(string);
			if (userArray[0] == 1) {
				return true;
			}
		} else {
			createLoginRecord(string);
		}
		return false;
	}

	private static void createLoginRecord(String string) {
		int[] userArray = new int[2];
		userArray[0] = 0; 	// login bool false/true
		userArray[1] = 0;   // login counter		
		if (loggedUsers.put(string, userArray) == null) {
			
		}
	}
	
		
}