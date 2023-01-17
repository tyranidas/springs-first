package fr.diginamic.springbootdemo;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import fr.diginamic.springbootdemo.model.Animal;
import fr.diginamic.springbootdemo.model.Person;
import fr.diginamic.springbootdemo.model.Species;
import fr.diginamic.springbootdemo.repository.AnimalRepository;
import fr.diginamic.springbootdemo.repository.PersonRepository;
import fr.diginamic.springbootdemo.repository.SpeciesRepository;


@SpringBootApplication
@RestController
@Component
public class SpringBootDemoApplication implements CommandLineRunner  {
	
	@Autowired
	PersonRepository personRepository;
	
	@Autowired
	AnimalRepository animalRepository;
	
	@Autowired
	SpeciesRepository speciesRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemoApplication.class, args);
	}





@Override
public void run(String... args) throws Exception {
	
	List<String> colorList = new ArrayList<>();
	colorList.add("Noir");
	colorList.add("Blanc");
		
	Species s = this.speciesRepository.findById(1).get();
	Animal a = new Animal();
	a.setSpecies(s);
	a.setColor("bleu");
	a.setName("Bouboul");
	a.setSex("F");

	Person p = new Person();
	p.setAge(28);
	p.setFirstname("Bob");
	p.setLastname("Morane");
	System.out.println("requete espèce");
	System.out.println(this.speciesRepository.findFirstByCommonName("Chat"));
	System.out.println(this.speciesRepository.findByLatinNameIgnoreCase("Oryctolagus Cuniculus"));
	
	System.out.println("requete personne");
	System.out.println(this.personRepository.findByLastnameOrFirstname("Lamarque", null));
	System.out.println(this.personRepository.findByAgeGreaterThan(25));
	
	System.out.println("requete animal");
	System.out.println(this.animalRepository.findAllBySpecies(s));
	System.out.println(this.animalRepository.findAllByColorIn(colorList));
	
	System.out.println("via Query");
	System.out.println(this.speciesRepository.findAllSpecies());
	System.out.println(this.speciesRepository.findAllbyCommonName("Lapin"));
	
	System.out.println();
	System.out.println(this.personRepository.findByAge(25, 50));
	System.err.println(this.personRepository.findByCommunName("Chat"));
	
	System.out.println();
	System.out.println(this.animalRepository.countBySex("M"));
	System.out.println(this.animalRepository.countByCommunName("Chat"));
	System.out.println(this.animalRepository.countByCommunName("Loup"));
}

}