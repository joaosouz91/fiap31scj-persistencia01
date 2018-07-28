package br.com.fiap.joao.persistencia01.dao;

import java.util.Set;

import br.com.fiap.joao.persistencia01.entity.Nota;

public class NotaDao extends Dao<Nota> {

	@Override
	public void include(Nota nota) throws Exception {
		
		try {
			openConnection();
			String sql = "INSERT INTO NOTA (id_matricula, id_curso, nota) VALUES (?, ?, ?)";
			stmt = cn.prepareStatement(sql);
			stmt.executeUpdate();
			
		} catch (Exception e) {
			throw e;
		}finally {
			closeConnection();
		}
		
	}

	@Override
	public Nota find(int id) throws Exception {

		return null;
	}

	@Override
	public Set<Nota> list(int... param) throws Exception {

		return null;
	}
	
}
