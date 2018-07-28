package br.com.fiap.joao.persistencia01.JDBCTemplate.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import br.com.fiap.joao.persistencia01.JDBCTemplate.entity.Aluno;
import br.com.fiap.joao.persistencia01.JDBCTemplate.entity.Curso;
import br.com.fiap.joao.persistencia01.JDBCTemplate.entity.CursoAluno;
import br.com.fiap.joao.persistencia01.JDBCTemplate.mapper.CursoAlunoMapper;

public class CursoAlunoDao {

	private JdbcTemplate jdbcTemplate;
	
	//datasource
	public void setDataSource(DataSource datasource) {
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}
	
	//inserir uma nota
	public void inserirNota(CursoAluno cursoAluno) {
		try {
			String sql = " INSERT INTO CURSOALUNO "
					+ " (nota, curso, aluno) VALUES (?, ? , ?) ";
			jdbcTemplate.update(sql, cursoAluno.getNota(), cursoAluno.getIdCurso(), cursoAluno.getMatricula());
		} catch (Exception e) {
			throw e;
		}
	}
	
	//buscar uma nota
	public CursoAluno buscarNota(int matricula, int curso) {
		
		CursoAluno cursoAluno = null;
		try {
			String sql = "SELECT * FROM CURSOALUNO WHERE ID_MATRICULA = ? AND ID_CURSO = ?";
			cursoAluno = jdbcTemplate.queryForObject(sql, new Integer[] {matricula, curso}, new CursoAlunoMapper());
		} catch (Exception e) {
			throw e;
		}
		
		return cursoAluno;
	}
	
	//listar notas
	public List<CursoAluno> listarNotas() throws Exception {
		List<CursoAluno> listaNotas = new ArrayList<>();
		try {
			listaNotas = jdbcTemplate.query("SELECT * FROM NOTA", new CursoAlunoMapper());
		} catch (Exception e) {
			throw e;
		}
		return listaNotas;
	}
}
