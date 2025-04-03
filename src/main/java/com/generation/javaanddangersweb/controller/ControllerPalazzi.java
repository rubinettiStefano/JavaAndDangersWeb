package com.generation.javaanddangersweb.controller;

import com.generation.javaanddangersweb.model.dao.PalazzoDao;
import com.generation.javaanddangersweb.model.entities.Palazzo;
import com.generation.javaanddangersweb.model.entities.TipoTetto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
public class ControllerPalazzi
{
	//PER VEDERLO SCRIVETE VOI NEL BROWSER localhost:8080/palazzi

	@Autowired
	PalazzoDao dao;

	//URI -> /formPalazzi e VERBO POST
	@PostMapping("/formPalazzi")
	public String aggiungiPalazzo
	(
			@RequestParam String indirizzo,
			@RequestParam int numeroPiani,
			@RequestParam LocalDate dataCostruzione,
			@RequestParam TipoTetto tetto,
			@RequestParam String imgUrl,
			@RequestParam String comando
	)
	{

		Palazzo p = new Palazzo();
		p.setIndirizzo(indirizzo);
		p.setDataCostruzione(dataCostruzione);
		p.setImgUrl(imgUrl);
		p.setTetto(tetto);
		p.setNumeroPiani(numeroPiani);
		dao.save(p);

		//request verso noi stessi
		if(comando.equals("CREA E TORNA PAGINA PALAZZI"))
			return "redirect:/palazzi";//fai una request get a /palazzi, sostanzialmente richiama il metodo mappato li
		else
			return "aggiuntaPalazzo";//ricarica pagina
	}

	@GetMapping("/palazzi")
	public String mostraLista(Model m)
	{
		m.addAttribute("palazzi",dao.findAll());
		return "listaPalazzi";
	}

	//URI -> /formPalazzi e VERBO GET
	@GetMapping("/formPalazzi")
	public String mostraPaginaAggiunta()
	{
		return "aggiuntaPalazzo";
	}


}
