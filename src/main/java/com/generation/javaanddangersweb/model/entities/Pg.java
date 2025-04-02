package com.generation.javaanddangersweb.model.entities;


import com.generation.javaanddangersweb.model.entities.enumpg.Alignment;
import com.generation.javaanddangersweb.model.entities.enumpg.PgClass;
import com.generation.javaanddangersweb.model.entities.enumpg.Race;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Entity
public class Pg extends BaseEntity
{
	private String nickname;
	@Enumerated(EnumType.STRING)
	private PgClass pgClass;
	@Enumerated(EnumType.STRING)
	private Race race;
	@Enumerated(EnumType.STRING)
	private Alignment alignment;
	private String avatarUrl;
	private LocalDate dob;

	@OneToMany(mappedBy = "pg",fetch = FetchType.EAGER)
	private List<Equipment> equipmentList;

	public Pg(){}

	public Pg(String nickname, PgClass pgClass, Race race, Alignment alignment, String avatarUrl, LocalDate dob)
	{
		this.nickname = nickname;
		this.pgClass = pgClass;
		this.race = race;
		this.alignment = alignment;
		this.avatarUrl = avatarUrl;
		this.dob = dob;
	}

	public Pg(Long id, String nickname, PgClass pgClass, Race race, Alignment alignment, String avatarUrl, LocalDate dob)
	{
		super(id);
		this.nickname = nickname;
		this.pgClass = pgClass;
		this.race = race;
		this.alignment = alignment;
		this.avatarUrl = avatarUrl;
		this.dob = dob;
	}

	public String getNickname()
	{
		return nickname;
	}

	public void setNickname(String nickname)
	{
		this.nickname = nickname;
	}

	public PgClass getPgClass()
	{
		return pgClass;
	}

	public void setPgClass(PgClass pgClass)
	{
		this.pgClass = pgClass;
	}

	public Race getRace()
	{
		return race;
	}

	public void setRace(Race race)
	{
		this.race = race;
	}

	public Alignment getAlignment()
	{
		return alignment;
	}

	public void setAlignment(Alignment alignment)
	{
		this.alignment = alignment;
	}

	public LocalDate getDob()
	{
		return dob;
	}

	public void setDob(LocalDate dob)
	{
		this.dob = dob;
	}

	public String getAvatarUrl()
	{
		return avatarUrl;
	}

	public void setAvatarUrl(String avatarUrl)
	{
		this.avatarUrl = avatarUrl;
	}

	public int getAge()
	{
		return Period.between(dob,LocalDate.now()).getYears();
	}


}
