package com.generation.javaanddangersweb.controller;

import com.generation.javaanddangersweb.model.dao.PgDao;
import com.generation.javaanddangersweb.model.entities.Pg;
import com.generation.javaanddangersweb.model.entities.enumpg.PgClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MainController
{
	@Autowired
	private PgDao pgDao;

	@GetMapping("/pglist")
	public String pgList(Model m)
	{
		//che avrò una variabile chiamata pgs contenente una Lista di Pg da usare nella view
		m.addAttribute("pgs",pgDao.findAll());

		return "pgList";
	}

	@GetMapping("/pgDetail")
	//@RequestParam e un parametro con lo stesso nome del parametro dell'url, lui andrà automaticamente a riempirlo
	//       /pgDetail?id=3       lui imposterà il valore di Long id a 3
	public String pgDetail(@RequestParam Long id, Model m)
	{
		m.addAttribute("pg",pgDao.findById(id).orElse(null));
		return "pgDetail";
	}
}
