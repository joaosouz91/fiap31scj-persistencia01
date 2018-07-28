package br.com.fiap.persistencia01.JPA.helper;

import javax.persistence.EntityManager;

import br.com.fiap.persistencia01.JPA.entity.Aluno;

public class AlunoHelper {

	
	private EntityManager em;

	public AlunoHelper(EntityManager em) {
		this.em = em;
	}
	
	public void save(Aluno aluno) {
		
		try {
			em.getTransaction().begin();
			em.persist(aluno);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw e;
		}
		
	}
}
