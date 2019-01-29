package com.packt.bank.model.repository.imp;

	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.util.HashMap;
	import java.util.Map;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.dao.DataAccessException;
	import org.springframework.jdbc.core.RowMapper;
	import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
	import org.springframework.stereotype.Repository;
	import com.packt.bank.model.Utente;
	import com.packt.bank.model.repository.UtenteRepository;

	@Repository
	public class UtenteRepositoryImp implements UtenteRepository {
		
		@Autowired
		NamedParameterJdbcTemplate jdbctemplate;

		@Override
		public Utente getUtenteByLogin(String username, String password) throws DataAccessException {
			
			String sql = "SELECT * FROM UTENTE WHERE USERNAME = :username AND PASSWORD = :password";
			Map<String, Object> params = new HashMap<>();
			params.put("username", username);
			params.put("password", password);
			return jdbctemplate.queryForObject(sql, params, new UtenteMapper());
		}
		
		
		private static final class UtenteMapper implements RowMapper<Utente>{

			@Override
			public Utente mapRow(ResultSet rs, int rowNum) throws SQLException {
				Utente utente = new Utente ();
				utente.setUsername(rs.getString("USERNAME"));
				utente.setPassword(rs.getString("PASSWORD"));
				utente.setNome(rs.getString("NOME"));
				utente.setCognome(rs.getString("COGNOME"));
				return utente;
			}
			
		}


		@Override
		public void addUtente(Utente utente) {
			String sql = "INSERT INTO UTENTE (USERNAME,"
					+ "PASSWORD,"
					+ "ENABLED,"
					+ "NOME,"
					+ "COGNOME)"
					+ "VALUES(:username, :password, :enabled, :nome, :cognome)";
			
			Map<String, Object> params = new HashMap<>();
			params.put("username", utente.getUsername());
			params.put("password", utente.getPassword());
			params.put("enabled", true);
			params.put("nome", utente.getNome());
			params.put("cognome", utente.getCognome());
			
			jdbctemplate.update(sql, params);			
		}
}
