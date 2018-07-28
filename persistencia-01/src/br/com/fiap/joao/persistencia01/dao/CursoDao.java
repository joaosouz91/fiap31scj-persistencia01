package br.com.fiap.joao.persistencia01.dao;

import java.util.Set;

import br.com.fiap.joao.persistencia01.entity.Curso;

public class CursoDao extends Dao<Curso>{

	@Override
	public void include(Curso curso) throws Exception {
		
		try {
			openConnection();
			String sql = "INSERT INTO CURSO (ds_curso, ds_carga_horaria) VALUES (?,?)";
			stmt = cn.prepareStatement(sql);
			stmt.setString(1, curso.getNomeCurso());
			stmt.setString(2, curso.getCargaHoraria());
			stmt.executeUpdate();
			
		} catch(Exception e) {
			throw e;
		} finally {
			closeConnection();
		}
		
	}

	@Override
	public Curso find(int id) throws Exception {

		return null;
	}

	@Override
	public Set<Curso> list(int... param) throws Exception {

		return null;
	}

}
