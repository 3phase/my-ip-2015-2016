package org.elsysbg.ip.todo.services;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.persistence.EntityManager;

import org.elsysbg.ip.todo.entities.Member;

@Singleton
public class AuthenticationService {

	private final MemberService memberService;
	
	@Inject
	public AuthenticationService(MemberService memberService) {
		this.memberService = memberService;
	}

	public Member getCurrentlyLoggedUser() {
		final List<Member> members = memberService.getMembers();
		return members.iterator().next();
	}
	
}
