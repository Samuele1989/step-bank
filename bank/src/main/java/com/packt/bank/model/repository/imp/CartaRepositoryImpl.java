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
import com.packt.bank.model.Carta;
import com.packt.bank.model.repository.CartaRepository;

@Repository
public class CartaRepositoryImpl implements CartaRepository {

	
	@Autowired
	NamedParameterJdbcTemplate jdbctemplate;
	
	
	@Override
	public List<Carta> getCarte(String username) {
		String sql = "SELECT * FROM CARTA_DI_CREDITO WHERE USERNAME_UTENTE = :username";
		Map<String, Object> params = new HashMap<>();
		params.put("username", username);
		return jdbctemplate.query(sql, params, new CartaMapper());
	}
	
	private static final class CartaMapper implements RowMapper<Carta>{

		@Override
		public Carta mapRow(ResultSet rs, int rowNum) throws SQLException {
			Carta carta = new Carta();
			carta.setIdCarta(rs.getInt("ID_CARTA_DI_CREDITO"));
			carta.setIban(rs.getString("IBAN"));
			carta.setUsername(rs.getString("USERNAME_UTENTE"));
			return carta;
		}	
	}
}
