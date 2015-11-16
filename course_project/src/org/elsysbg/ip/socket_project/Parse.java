package org.elsysbg.ip.socket_project;

import java.util.HashMap;
import java.util.Map;

public class Parse {

	private String stringToParse;
	private Map<String, String> userMeta = new HashMap<>();
	
	public Parse() {
		// TODO Auto-generated constructor stub
	}
	
	public Map<String, String> parse(String s) {
		this.stringToParse = s;
		this.split();
		return userMeta;
	}
	
	private void split() {
		String[] parts = stringToParse.split(":"); 
		userMeta.put("username", parts[0]);
		userMeta.put("command", parts[1]);
		if (parts.length > 2 && parts[2] != null)
			userMeta.put("checked_username", parts[2]);
	}
	
}