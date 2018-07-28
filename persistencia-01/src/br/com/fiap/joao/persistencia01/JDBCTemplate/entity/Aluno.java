package br.com.fiap.joao.persistencia01.JDBCTemplate.entity;

import java.io.Serializable;

public class Aluno implements Serializable{
	
	private String nome;
	private int matricula;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getMatricula() {
		return matricula;
	}
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	
}
