package br.com.fiap.joao.persistencia01.aplicacao;

import javax.swing.JOptionPane;

import br.com.fiap.joao.persistencia01.dao.AlunoDao;
import br.com.fiap.joao.persistencia01.dao.CursoDao;
import br.com.fiap.joao.persistencia01.dao.NotaDao;
import br.com.fiap.joao.persistencia01.entity.Aluno;
import br.com.fiap.joao.persistencia01.entity.Curso;
import br.com.fiap.joao.persistencia01.entity.Nota;

public class SchoolApplication {

	public static void main(String[] args) {

		int opt = 0;
		
		try {
			
			opt = Integer.parseInt(JOptionPane.showInputDialog("O que deseja fazer?\n"
					+ "[1] - Matricular Aluno\n"
					+ "[2] - Cadastrar Curso\n"
					+ "[3] - Registrar Nota Final"));
			
			if(opt < 1 || opt > 3) throw new NumberFormatException();

			while(opt != 0) {
				
				AlunoDao alunoDao = null;
				CursoDao cursoDao = null;
				NotaDao notaDao = null;
				
				Aluno aluno = null;
				Curso curso = null;
				Nota nota = null;
				
				switch (opt) {
				case 1:
					//Matricula aluno
					
					String nome = "";
					nome = JOptionPane.showInputDialog("Digite o nome do aluno");
					
					aluno = new Aluno();
					aluno.setNome(nome);
					
					alunoDao = new AlunoDao();
					alunoDao.openConnection();
					alunoDao.include(aluno);
					
					break;
				
				case 2: 
					//Cadastra curso
					
					String nomeCurso = "";
					String cargaHoraria = "";
					
					nomeCurso = JOptionPane.showInputDialog("Digite o nome do curso.");
					cargaHoraria = JOptionPane.showInputDialog("Digite a carga horária do curso.");
					
					curso = new Curso();
					curso.setNomeCurso(nomeCurso);					
					curso.setCargaHoraria(cargaHoraria);
					
					cursoDao = new CursoDao();
					cursoDao.openConnection();
					cursoDao.include(curso);
					
					break;
					
				case 3:
					//Lista Alunos
					
					alunoDao = new AlunoDao();
					
					JOptionPane.showMessageDialog(null, alunoDao.list());
					
					
					
					break;

				default:
					break;
				}
				
			}
			

		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Digite um número válido.");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}

	}

}
