package fr.diginamic.springbootdemo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.diginamic.springbootdemo.model.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;



public class PersonRepositoryCustomlmpl implements PersonRepositoryCustom {
	
	
	@PersistenceContext
	private EntityManager em;
	
	 @Override
	 @Transactional
	    public int deletePersonsWithoutAnimal() {
	        Query sqlQuery =  em.createNativeQuery("DELETE FROM Person p WHERE NOT EXISTS (SELECT a FROM person_animals a WHERE person_id = p)");
	        return  sqlQuery.executeUpdate();
	    }
	
	/*@Override
	public  void effacerSiPasPet() {		
		em.createNativeQuery("delete p from person p left join person_animals pa on p.id = pa.person_id where pa.animals_id is null").executeUpdate();
				
	//	em.createQuery("DELETE FROM Person p WHERE NOT EXISTS (SELECT a FROM person_animals a WHERE person_id = p)").executeUpdate();
		
		
	}
*/
	
}
