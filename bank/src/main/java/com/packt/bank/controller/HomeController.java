package com.packt.bank.controller;

import java.security.Principal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.packt.bank.model.Carta;
import com.packt.bank.model.Operazione;
import com.packt.bank.model.repository.CartaRepository;
import com.packt.bank.model.repository.OperazioneRepository;
import com.packt.bank.model.repository.UtenteRepository;



@Controller
@SessionAttributes ("username")
public class HomeController {
	
	@Autowired
	private UtenteRepository utenteRepository;
	
	@Autowired
	private CartaRepository cartaRepository;
	
	@Autowired
	private OperazioneRepository operazioneRepository;
	
	@RequestMapping("/")
	public String home() {
		return "redirect:/login";
	}


	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	
	@RequestMapping("/welcome")
	public String welcome(Principal principal, Model model) {
		model.addAttribute("utente", principal.getName());
		return "welcome";
	}
	
	
	@RequestMapping("/le-tue-carte")
	public String getCarte(@RequestParam("username") String username, Model model) {
		List<Carta> carte = cartaRepository.getCarte(username);
		model.addAttribute("carte", carte);
		model.addAttribute("username", username);
		return "leTueCarte";
	}
	@RequestMapping("/le-tue-operazioni")
	public String getOperazioni(@RequestParam("codice") int codice, Model model) {
		List<Operazione> operazioni = operazioneRepository.getOperazioni(codice);
		model.addAttribute("operazioni", operazioni);
		return "operazione";
	}
	
}
