package com.packt.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.packt.bank.model.Utente;
import com.packt.bank.model.repository.RuoloRepository;
import com.packt.bank.model.repository.UtenteRepository;

@Controller
public class AggiungiUtenteController {
	
	@Autowired
	UtenteRepository utenteRepository;
	
	@Autowired
	RuoloRepository ruoloRepository;
	
	@RequestMapping(value = "/aggiungi-utente", method = RequestMethod.GET)
	public String addUtenteForm(@ModelAttribute("nuovoUtente") Utente nuovoUtente) {
		return "aggiungiUtente";
	}
	
	@RequestMapping(value = "/aggiungi-utente", method = RequestMethod.POST)
	public String processaddUtenteForm(@ModelAttribute("nuovoUtente") Utente nuovoUtente) {
		utenteRepository.addUtente(nuovoUtente);
		ruoloRepository.addRuolo(nuovoUtente);
		if(nuovoUtente.getRuolo().equals("ROLE_ADMIN")) {
			ruoloRepository.addRuoloUserIfAdmin(nuovoUtente);
		}
		return "redirect:/login";
	}
}
