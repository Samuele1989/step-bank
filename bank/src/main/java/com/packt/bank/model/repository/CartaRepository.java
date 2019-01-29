package com.packt.bank.model.repository;

import java.util.List;

import com.packt.bank.model.Carta;

public interface CartaRepository {
	
	List<Carta> getCarte(String username);

}
