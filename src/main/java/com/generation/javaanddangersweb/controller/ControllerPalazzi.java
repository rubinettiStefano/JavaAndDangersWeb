package com.generation.javaanddangersweb.controller;

import com.generation.javaanddangersweb.model.dao.AppartamentoDao;
import com.generation.javaanddangersweb.model.dao.PalazzoDao;
import com.generation.javaanddangersweb.model.entities.Appartamento;
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
	@Autowired
	AppartamentoDao aDao;

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

	@GetMapping("/palazzoDetail")
	public String mostraSingolo(Model m,@RequestParam Long id)
	{
		m.addAttribute("palazzo",dao.findById(id).orElse(null));
		return "palazzoPagina";
	}

	@PostMapping("/creaAppartamento")
	public String creaAppartamento
	(
			@RequestParam String targhetta,
			@RequestParam Long idPalazzo
	)
	{

		//legge dal db il padre grazie al suo id
		Palazzo p = dao.findById(idPalazzo).orElse(null);

		//crea il figlio con i campi riempiti
		Appartamento a= new Appartamento();
		a.setTarghetta(targhetta);
		//collega il figlio al padre
		a.setPalazzo(p);

		//lo salva nel db
		aDao.save(a);

		//Qui chiamo il metodo mappato a palazzoDetail passandogli anche come parametro l'id
		return "redirect:/palazzoDetail?id="+idPalazzo;

	}

	//URI -> /formPalazzi e VERBO GET
	@GetMapping("/formPalazzi")
	public String mostraPaginaAggiunta()
	{
		return "aggiuntaPalazzo";
	}


}
