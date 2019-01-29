package com.packt.bank.model.repository;

import org.springframework.dao.DataAccessException;

import com.packt.bank.model.Utente;

public interface UtenteRepository {

	Utente getUtenteByLogin(String username, String password) throws DataAccessException;
	void addUtente(Utente utente);
}



