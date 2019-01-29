package com.packt.bank.model.repository.imp;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.packt.bank.model.Utente;
import com.packt.bank.model.repository.RuoloRepository;

@Repository
public class RuoloRepositoryImpl implements RuoloRepository {
	
	@Autowired
	NamedParameterJdbcTemplate jdbctemplate;

	@Override
	public void addRuolo(Utente utente) {
		String sql = "INSERT INTO RUOLI VALUES(:idRuolo, :username, :ruolo)";
		
		Map<String, Object> params = new HashMap<>();
		params.put("idRuolo", null);
		params.put("username", utente.getUsername());
		params.put("ruolo", utente.getRuolo());
		jdbctemplate.update(sql, params);		
	}

	@Override
	public void addRuoloUserIfAdmin(Utente utente) {
String sql = "INSERT INTO RUOLI VALUES(:idRuolo, :username, :ruolo)";
		
		Map<String, Object> params = new HashMap<>();
		params.put("idRuolo", null);
		params.put("username", utente.getUsername());
		params.put("ruolo", "ROLE_USER");
		jdbctemplate.update(sql, params);	
	}	
}
