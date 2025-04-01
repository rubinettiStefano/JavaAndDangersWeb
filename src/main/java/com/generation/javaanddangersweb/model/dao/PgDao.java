package com.generation.javaanddangersweb.model.dao;

import com.generation.javaanddangersweb.model.entities.Pg;
import com.generation.javaanddangersweb.model.entities.enumpg.Alignment;
import com.generation.javaanddangersweb.model.entities.enumpg.PgClass;
import com.generation.javaanddangersweb.model.entities.enumpg.Race;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PgDao extends JpaRepository<Pg,Long>
{
	List<Pg> findAllByPgClass(PgClass c);
	List<Pg> findAllByAlignment(Alignment c);
	List<Pg> findAllByPgClassAndRace(PgClass c, Race r);

	@Query("SELECT p FROM Pg p WHERE p.pgClass=:c and p.race=:r and p.alignment=:a")
	List<Pg> findPerTutto(PgClass c, Race r,Alignment a);
}
