package br.com.fiap.joao.persistencia01.dao;

import java.util.Set;

import br.com.fiap.joao.persistencia01.entity.Aluno;

public class AlunoDao extends Dao<Aluno>{

	@Override
	public void include(Aluno aluno) throws Exception {
		
		try {
			openConnection();
			String sql = "INSERT INTO ALUNO (ds_nome) VALUES (?)";
			stmt = cn.prepareStatement(sql);
			stmt.setString(1, aluno.getNome());
			stmt.executeUpdate();
			
		} catch (Exception e) {
			throw e;
		} finally {
			closeConnection();
		}
		
	}

	@Override
	public Aluno find(int id) throws Exception {

		return null;
	}

	@Override
	public Set<Aluno> list(int... param) throws Exception {

		return null;
	}

}
