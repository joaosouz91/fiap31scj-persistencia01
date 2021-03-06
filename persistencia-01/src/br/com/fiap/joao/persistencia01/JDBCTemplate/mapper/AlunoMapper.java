package br.com.fiap.joao.persistencia01.JDBCTemplate.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import br.com.fiap.joao.persistencia01.JDBCTemplate.entity.Aluno;

public class AlunoMapper implements RowMapper<Aluno> {

	@Override
	public Aluno mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Aluno aluno = new Aluno();
		aluno.setMatricula(rs.getInt("id_matricula"));
		aluno.setNome(rs.getString("ds_nome"));
		
		return aluno;
	}

}
