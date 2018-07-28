package br.com.fiap.persistencia01.JPA.helper;

import javax.persistence.EntityManager;

import br.com.fiap.persistencia01.JPA.entity.CursoAluno;

public class NotaHelper {
	
	private EntityManager em;

	public NotaHelper(EntityManager em) {
		this.em = em;
	}
	
	public void save(CursoAluno nota) {
		try {
			em.getTransaction().begin();
			em.persist(nota);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw e;
		}
	}

}
