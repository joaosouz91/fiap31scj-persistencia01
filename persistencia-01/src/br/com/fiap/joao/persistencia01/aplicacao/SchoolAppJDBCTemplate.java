package br.com.fiap.joao.persistencia01.aplicacao;

import javax.swing.JOptionPane;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DuplicateKeyException;

import br.com.fiap.joao.persistencia01.JDBCTemplate.dao.AlunoDao;
import br.com.fiap.joao.persistencia01.JDBCTemplate.dao.CursoDao;
import br.com.fiap.joao.persistencia01.JDBCTemplate.dao.CursoAlunoDao;
import br.com.fiap.joao.persistencia01.JDBCTemplate.entity.Aluno;
import br.com.fiap.joao.persistencia01.JDBCTemplate.entity.Curso;
import br.com.fiap.joao.persistencia01.JDBCTemplate.entity.CursoAluno;

public class SchoolAppJDBCTemplate {

	public static void main(String[] args) throws Exception {
		
		String input;
		String[] options = {"1 - Incluir Curso", "2 - Buscar Curso", "3 - Incluir Aluno", "4 - Buscar Aluno", "5 - Incluir Nota"};
		do {
			input = (String)JOptionPane.showInputDialog(null, "O que deseja fazer?", null, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
			if (input == null){
				JOptionPane.showMessageDialog(null, "Usu�rio cancelou a opera��o");
				break;
			}
			switch (Integer.parseInt(input.substring(0, 1))) {
			case 1:
				incluirCurso();
				break;
			case 2:
				buscarCurso();
				break;
			case 3:
				incluirAluno();
				break;
			case 4: 
				buscarAluno();
				break;
			case 5:
				incluirNota();
			} 
		} while (Integer.parseInt(input.substring(0, 1)) > 0);
	}
	
	public static void incluirCurso() {
		try {

			String nomeCurso = JOptionPane.showInputDialog("Insira o nome do curso.");
			String cargaHoraria = JOptionPane.showInputDialog("Insira a carga hor�ra do curso (n�mero inteiro)");
			if (nomeCurso == null || cargaHoraria == null){
				return;
			}
			
			ApplicationContext context = new ClassPathXmlApplicationContext("beanJdbc.xml");
			CursoDao cursoDao = (CursoDao) context.getBean("CursoDao");
			Curso curso = new Curso();
			curso.setNomeCurso(nomeCurso);
			curso.setCargaHoraria(cargaHoraria+"h");
			
			cursoDao.incluirCurso(curso);
			
			JOptionPane.showMessageDialog(null, "curso inclu�do com sucesso");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void buscarCurso() {
		
		int idCurso = Integer.parseInt(JOptionPane.showInputDialog("Insira o id do curso"));
		if(idCurso == 0) throw new NumberFormatException();
		
		ApplicationContext context = new ClassPathXmlApplicationContext("beanJdbc.xml");
		CursoDao cursoDao = (CursoDao) context.getBean("CursoDao");
		Curso curso = null;
		
		try {
			curso = cursoDao.buscarCurso(idCurso);
		} catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "N�mero inv�lido");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		if(curso!=null) {
			JOptionPane.showMessageDialog(null, "Nome Curso: " + curso.getNomeCurso()
					+ "\nCarga Hor�ria: " + curso.getCargaHoraria());
		} else {
			JOptionPane.showMessageDialog(null, "Nenhum aluno encontrado para este n�mero de matr�cula.");
		}
	}
	
	public static void incluirAluno() {
		
		String nomeAluno = JOptionPane.showInputDialog("Insira o nome do aluno.");
		if (nomeAluno == null){
			return;
		}
		
		ApplicationContext context = new ClassPathXmlApplicationContext("beanJdbc.xml");
		AlunoDao alunoDao = null;
		Aluno aluno = null;
		try {
			aluno = new Aluno();
			aluno.setNome(nomeAluno);
			alunoDao = (AlunoDao) context.getBean("AlunoDao");
			alunoDao.incluirAluno(aluno);
			
			JOptionPane.showMessageDialog(null, "Aluno inclu�do com sucesso");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void buscarAluno() {
		
		int matricula = Integer.parseInt(JOptionPane.showInputDialog("Insira o n�mero da matr�cula do aluno."));
		if(matricula == 0) throw new NumberFormatException();
		
		ApplicationContext context = new ClassPathXmlApplicationContext("beanJdbc.xml");
		AlunoDao alunoDao = (AlunoDao) context.getBean("AlunoDao");
		Aluno aluno = null;
		
		try {
			aluno = alunoDao.buscarAluno(matricula);
		} catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "N�mero inv�lido");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		if(aluno!=null) {
			JOptionPane.showMessageDialog(null, "Matr�cula: " + aluno.getMatricula()
					+ "\nNome: " + aluno.getNome());
		} else {
			JOptionPane.showMessageDialog(null, "Nenhum aluno encontrado para este n�mero de matr�cula.");
		}
	}
	
	public static void incluirNota() {
		
		//in�cio teste
		Aluno aluno = new Aluno();
		aluno.setMatricula(1);
		Curso curso = new Curso();
		curso.setIdCurso(1);
		//fim teste
		
		String input = null;
		Double nota = null;
		
		while (nota == null) {
			try {
				input = JOptionPane.showInputDialog("Digite a nota do aluno.");
				if (input == null){
					JOptionPane.showMessageDialog(null, "Usu�rio cancelou a opera��o.");
					break;
				}
				nota = Double.parseDouble(input);
			}catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Digite um valor num�rico.");
			}
		}
		
		ApplicationContext context = new ClassPathXmlApplicationContext("beanJdbc.xml");
		CursoAluno cursoAluno = null;
		CursoAlunoDao cursoAlunoDao = null;
		try {
			cursoAlunoDao = (CursoAlunoDao)context.getBean("CursoAlunoDao");
			cursoAluno = new CursoAluno();
			cursoAluno.setIdCurso(curso.getIdCurso());
			cursoAluno.setMatricula(aluno.getMatricula());
			cursoAluno.setNota(nota);
			cursoAlunoDao.inserirNota(cursoAluno);
			JOptionPane.showMessageDialog(null, "Nota inclu�da com sucesso");
		} catch (DuplicateKeyException e) {
			JOptionPane.showMessageDialog(null, "Este aluno j� possui uma nota cadastrada para este curso.");
			return;
		} catch (Exception e) {
			throw e;
		}
		
	}
	
	public static void buscarNota() {
		
	}
	

}
