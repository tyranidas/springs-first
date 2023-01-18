package fr.diginamic.springbootdemo.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.diginamic.springbootdemo.model.Species;
@Repository
public interface SpeciesRepository extends CrudRepository<Species, Integer> {
	Species findFirstByCommonName (String name);
	List<Species> findByLatinNameIgnoreCase (String name);
	
	@Query("from Species order by latinName")
	List<Species> findAllSpeciesOrderByLatinName();
	
	@Query("from Species where commonName = :name ")
	List<Species> findAllbyCommonName(@Param("name") String name);
}
