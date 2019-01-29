package com.packt.bank.model.repository;

import java.util.List;

import com.packt.bank.model.Operazione;

public interface OperazioneRepository {
	
	List<Operazione> getOperazioni(int idCarta);

}
