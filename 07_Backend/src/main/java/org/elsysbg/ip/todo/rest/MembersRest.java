package org.elsysbg.ip.todo.rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.shiro.authz.annotation.RequiresGuest;
import org.elsysbg.ip.todo.entities.Member;
import org.elsysbg.ip.todo.services.MemberService;
import org.elsysbg.ip.todo.services.TaskService;

@Path("/members")
public class MembersRest {
	private final MemberService membersService;
	private final TaskService taskService;
	
	@Inject
	public MembersRest(MemberService membersService, TaskService taskService) {
		this.membersService = membersService;
		this.taskService = taskService;
	}
	
	@POST
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@RequiresGuest
	public Member createMember(Member member) {
		return membersService.createMember(member);
	}
}
