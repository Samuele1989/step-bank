package com.packt.bank.model.repository.imp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.packt.bank.model.Operazione;
import com.packt.bank.model.repository.OperazioneRepository;


@Repository
public class OperazioneRepositoryImpl implements OperazioneRepository{
	
	@Autowired
	NamedParameterJdbcTemplate jdbctemplate;

	@Override
	public List<Operazione> getOperazioni(int idCarta) {
		String sql="SELECT * FROM OPERAZIONE WHERE ID_CARTA= :idCarta";
		Map<String, Object> params = new HashMap<>();
		params.put("idCarta", idCarta);
		
		return jdbctemplate.query(sql, params, new OperazioneMapper());
		
	}


private static final class OperazioneMapper implements RowMapper<Operazione>{

	@Override
	public Operazione mapRow(ResultSet rs, int rowNum) throws SQLException {
		Operazione operazione = new Operazione();
		operazione.setIdOperazione(rs.getInt("ID_OPERAZIONE"));
		operazione.setLuogo(rs.getString("LUOGO"));
		operazione.setTipo(rs.getString("TIPO"));
		operazione.setImporto(rs.getDouble("IMPORTO"));
		operazione.setData(rs.getDate("DATA"));
		operazione.setOra(rs.getTime("ORA"));
		operazione.setIdCarta(rs.getInt("ID_CARTA"));
		
		return operazione;
	}
}
}