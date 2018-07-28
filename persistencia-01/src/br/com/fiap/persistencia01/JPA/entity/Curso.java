package br.com.fiap.persistencia01.JPA.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="curso")
public class Curso implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@Column(name="id_curso")
	private int idCurso;

	@Column(name="ds_curso")
	private String nomeCurso;
	
	@Column(name="ds_carga_horaria")
	private String cargaHoraria;

	public int getIdCurso() {
		return idCurso;
	}
	
	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}
	
	public String getNomeCurso() {
		return nomeCurso;
	}
	
	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}
	
	public String getCargaHoraria() {
		return cargaHoraria;
	}
	
	public void setCargaHoraria(String cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}
	

}
