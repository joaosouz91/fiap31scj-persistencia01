package br.com.fiap.persistencia01.JPA.pk;

import java.io.Serializable;

import javax.persistence.*;

import br.com.fiap.persistencia01.JPA.entity.Aluno;
import br.com.fiap.persistencia01.JPA.entity.Curso;

@Embeddable
public class CursoAlunoPK implements Serializable {

	public CursoAlunoPK() {}
	
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name="aluno", referencedColumnName="id_matricula", nullable=false)
	private Aluno aluno;
	
	@ManyToOne
	@JoinColumn(name="curso", referencedColumnName="id_curso", nullable=false)
	private Curso curso;	
	
	public Aluno getAluno() {
		return aluno;
	}
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
	@Override
	public boolean equals(Object arg0) {
		// TODO Auto-generated method stub
		return super.equals(arg0);
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

}