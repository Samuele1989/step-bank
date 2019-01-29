package com.packt.bank.model.repository;

import com.packt.bank.model.Utente;

public interface RuoloRepository {

	void addRuolo(Utente utente);
	void addRuoloUserIfAdmin(Utente utente);
}
