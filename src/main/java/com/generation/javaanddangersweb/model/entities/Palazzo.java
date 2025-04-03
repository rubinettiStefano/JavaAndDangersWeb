package com.generation.javaanddangersweb.model.entities;

import jakarta.persistence.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Palazzo extends BaseEntity
{

	private String indirizzo;
	private int numeroPiani;
	private LocalDate dataCostruzione;
	@Enumerated(EnumType.STRING)
	private TipoTetto tetto;
	private String imgUrl;

	@OneToMany(mappedBy = "palazzo",fetch = FetchType.EAGER)
	private List<Appartamento> appartamenti;

	public String getIndirizzo()
	{
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo)
	{
		this.indirizzo = indirizzo;
	}

	public int getNumeroPiani()
	{
		return numeroPiani;
	}

	public void setNumeroPiani(int numeroPiani)
	{
		this.numeroPiani = numeroPiani;
	}

	public LocalDate getDataCostruzione()
	{
		return dataCostruzione;
	}

	public void setDataCostruzione(LocalDate dataCostruzione)
	{
		this.dataCostruzione = dataCostruzione;
	}

	public TipoTetto getTetto()
	{
		return tetto;
	}

	public void setTetto(TipoTetto tetto)
	{
		this.tetto = tetto;
	}

	public String getImgUrl()
	{
		return imgUrl;
	}

	public void setImgUrl(String imgUrl)
	{
		this.imgUrl = imgUrl;
	}

	public List<Appartamento> getAppartamenti()
	{
		return appartamenti;
	}

	public void setAppartamenti(List<Appartamento> appartamenti)
	{
		this.appartamenti = appartamenti;
	}
}
