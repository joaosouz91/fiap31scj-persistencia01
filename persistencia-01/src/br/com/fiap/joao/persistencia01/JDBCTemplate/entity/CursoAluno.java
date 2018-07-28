package br.com.fiap.joao.persistencia01.JDBCTemplate.entity;

public class CursoAluno {
	
	private int matricula;
	private int idCurso;
	private Double nota;
	
	public CursoAluno() {}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int idMatricula) {
		this.matricula = idMatricula;
	}

	public int getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}

	public Double getNota() {
		return nota;
	}

	public void setNota(Double nota) {
		this.nota = nota;
	}

}
