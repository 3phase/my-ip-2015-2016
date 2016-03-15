package org.elsysbg.ip.todo.services;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.elsysbg.ip.todo.entities.Member;
import org.elsysbg.ip.todo.entities.Member;
import org.elsysbg.ip.todo.entities.Member;

@Singleton
public class MemberService {
	private final EntityManagerService entityManagerService;
	
	@Inject
	public MemberService(EntityManagerService entityManagerService) {
		this.entityManagerService = entityManagerService;
	}
	
	public Member createMember(Member member) {
		final EntityManager em = entityManagerService.createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(member);
			em.getTransaction().commit();
			return member;
		} finally {
			if(em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			em.close();
		}
	}
	
	public List<Member> getMembers() {
		final EntityManager em = entityManagerService.createEntityManager();
		try {
			final TypedQuery<Member> query = em.createNamedQuery(Member.QUERY_ALL, Member.class);
			return query.getResultList();
		} finally {
			em.close();
		}
	}
	
	public Member getMember(long MemberId) {
		final EntityManager em = entityManagerService.createEntityManager();
		try {
			final Member result = em.find(Member.class, MemberId);
			if(result == null) {
				throw new IllegalArgumentException("no Member with id: " + MemberId);
			}
			return result;
		} finally {
			em.close();
		}
	}
}

