package br.com.fiap.joao.persistencia01.JDBCTemplate.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import br.com.fiap.joao.persistencia01.JDBCTemplate.viewmodel.CursoAlunoViewModel;

public class CursoAlunoViewModelMapper implements RowMapper<CursoAlunoViewModel>{

	@Override
	public CursoAlunoViewModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		CursoAlunoViewModel cavm = new CursoAlunoViewModel();
		cavm.setDescricaoCurso(rs.getString("ds_curso"));
		cavm.setNomeAluno(rs.getString("ds_nome"));
		return cavm;
	}

}
