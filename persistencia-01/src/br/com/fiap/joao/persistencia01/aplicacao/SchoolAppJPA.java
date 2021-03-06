package br.com.fiap.joao.persistencia01.aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.persistencia01.JPA.entity.Aluno;
import br.com.fiap.persistencia01.JPA.entity.Curso;
import br.com.fiap.persistencia01.JPA.entity.CursoAluno;
import br.com.fiap.persistencia01.JPA.helper.AlunoHelper;
import br.com.fiap.persistencia01.JPA.helper.CursoHelper;
import br.com.fiap.persistencia01.JPA.helper.NotaHelper;
import br.com.fiap.persistencia01.JPA.pk.CursoAlunoPK;

public class SchoolAppJPA {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaDBESCOLA");
		EntityManager em = emf.createEntityManager();
		AlunoHelper alunoHelper = new AlunoHelper(em);
		CursoHelper cursoHelper = new CursoHelper(em);
		NotaHelper notaHelper = new NotaHelper(em);
		
		try {
			
			//Definindo o Aluno
			Aluno aluno = new Aluno();
			aluno.setNome("Muricy Ramalho");
			
			alunoHelper.save(aluno);
			
			//Definindo o Curso do Aluno
			Curso curso = new Curso();
			curso.setNomeCurso("Curso Teste");
			curso.setCargaHoraria("10h");
			
			cursoHelper.save(curso);
			
			//Definindo NotaPK
			CursoAlunoPK cursoAlunoPK = new CursoAlunoPK();
			cursoAlunoPK.setAluno(aluno);
			cursoAlunoPK.setCurso(curso);
			
			//Definindo a nota do aluno
			CursoAluno cursoAluno = new CursoAluno();
			cursoAluno.setCursoAlunoPK(cursoAlunoPK);
			cursoAluno.setNota(10.0);
			
			notaHelper.save(cursoAluno);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
