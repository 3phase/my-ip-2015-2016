package org.elsysbg.ip.socket_project;

public class User {
	
	private String username;
	private Integer count_of_entries = 0;
	private Integer currently_logged = 0;
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public void new_user(String user) {
		this.username = user;
	}
	
	public Integer returnEntriesCount() {
		return count_of_entries;
	}
	
	public Integer isLogged() {
		return currently_logged;
	}
	
	public void logout() {
		this.currently_logged = 0;
	}
	
	public void login() {
		this.currently_logged = 1;
		this.count_of_entries += 1;
	}
	
}
