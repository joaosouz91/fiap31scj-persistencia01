package br.com.fiap.persistencia01.JPA.entity;

import java.io.Serializable;

import javax.persistence.*;

import br.com.fiap.persistencia01.JPA.pk.CursoAlunoPK;

@Entity
@Table(name="cursoaluno")
public class CursoAluno implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private CursoAlunoPK cursoAlunoPK;
	
	@Column(name="nota", columnDefinition="decimal(12,2)")
	Double nota;

	public CursoAlunoPK getNotaPK() {
		return cursoAlunoPK;
	}
	
	public void setCursoAlunoPK(CursoAlunoPK cursoAlunoPK) {
		this.cursoAlunoPK = cursoAlunoPK;
	}

	public Double getNota() {
		return nota;
	}

	public void setNota(Double nota) {
		this.nota = nota;
	}
	

}
