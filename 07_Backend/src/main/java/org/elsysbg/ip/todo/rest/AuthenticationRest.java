package org.elsysbg.ip.todo.rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.shiro.subject.Subject;
import org.elsysbg.ip.todo.entities.Member;
import org.elsysbg.ip.todo.services.AuthenticationService;
import org.secnod.shiro.jaxrs.Auth;

@Path("/authentication")
public class AuthenticationRest {

	private AuthenticationService authenticationService;
	
	@Inject
	public AuthenticationRest(AuthenticationService authService) {
		this.authenticationService = authService;
	}
	
	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Member login(@Auth Subject subject, Member member) {
		 authenticationService.login(subject, 
				 member.getUsername(), member.getPassword());
		 return authenticationService.getCurrentlyLoggedUser(subject);
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public Member getCurrentlyLoggedInMember(@Auth Subject subject) {
		return authenticationService.getCurrentlyLoggedUser(subject);
	}
	
	@DELETE
	public void logout(@Auth Subject subject) {
		authenticationService.logout(subject);
	}
	
}
