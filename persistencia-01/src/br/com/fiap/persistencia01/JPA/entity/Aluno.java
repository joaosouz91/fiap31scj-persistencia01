package br.com.fiap.persistencia01.JPA.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "aluno")
public class Aluno implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@Column(name = "id_matricula")
	private int matricula;
	
	@Column(name = "ds_nome")
	private String nome;

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
