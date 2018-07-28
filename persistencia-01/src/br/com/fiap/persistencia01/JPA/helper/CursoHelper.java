package br.com.fiap.persistencia01.JPA.helper;

import javax.persistence.EntityManager;

import br.com.fiap.persistencia01.JPA.entity.Curso;

public class CursoHelper {
	
	private EntityManager em;

	public CursoHelper(EntityManager em) {
		this.em = em;
	}
	
	public void save(Curso curso) {
		
		try {
			em.getTransaction().begin();
			em.persist(curso);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw e;
		}
		
	}
	
}
