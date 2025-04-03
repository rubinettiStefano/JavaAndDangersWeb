package com.generation.javaanddangersweb.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Appartamento extends BaseEntity
{
	private String targhetta;

	@ManyToOne
	@JoinColumn(name = "palazzo_id")
	private Palazzo palazzo;


	public Palazzo getPalazzo()
	{
		return palazzo;
	}

	public void setPalazzo(Palazzo palazzo)
	{
		this.palazzo = palazzo;
	}

	public String getTarghetta()
	{
		return targhetta;
	}

	public void setTarghetta(String targhetta)
	{
		this.targhetta = targhetta;
	}
}
