package com.generation.javaanddangersweb.model.entities;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type",discriminatorType = DiscriminatorType.STRING)
public abstract class Equipment extends BaseEntity
{
	//TODO 0 - Far partire la query che vi do io (query.txt in cartella principale)
	//TODO 1 - Creare classi Weapon ed Armor che estendono questa, ricordarsi il discriminator value
	//TODO 2 - Mettere qui almeno 3 proprietà in comune tra armi e armature (es peso)
	//TODO 3 - Ricordatevi poi di aggiungere getter/setter e costruttori ovunque
	//TODO 4 - Aggiungere almeno 2 proprietà dentro Weapon e 2 dentro Armor
	//TODO 5 - Runnare programma per far aggiornare la tabella
	//TODO 6 - Aggiungere a mano qualche arma e qualche armatura nella tabella equipment del db


	@ManyToOne
	@JoinColumn(name = "pg_id")
	Pg pg;
}
