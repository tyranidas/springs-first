package fr.diginamic.springbootdemo.repository;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.diginamic.springbootdemo.model.Species;
@Repository
public interface SpeciesRepository extends CrudRepository<Species, Integer> {
	List<Species> findFirstByCommonName (String name);
	List<Species> findByLatinNameIgnoreCase (String name);
	
}
