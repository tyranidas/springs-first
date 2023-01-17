package fr.diginamic.springbootdemo;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.diginamic.springbootdemo.model.Animal;
import fr.diginamic.springbootdemo.model.Person;
import fr.diginamic.springbootdemo.model.Species;
import fr.diginamic.springbootdemo.repository.AnimalRepository;
import fr.diginamic.springbootdemo.repository.PersonRepository;
import fr.diginamic.springbootdemo.repository.SpeciesRepository;
import fr.diginamic.springbootdemo.service.BavardService;


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
	this.animalRepository.save(a);
	System.out.println(a.getSpecies().getCommun_name());
	Person p = new Person();
	p.setAge(28);
	p.setFirstname("Bob");
	p.setLastname("Morane");
	System.out.println("requete espèce");
	System.out.println(this.speciesRepository.findFirstByCommonName("Chat"));
	System.out.println(this.speciesRepository.findByLatinNameIgnoreCase("Oryctolagus Cuniculus"));
	System.out.println("requete personne");
	System.out.println(this.personRepository.findByLastnameOrFirstname("Lamarque", null));
	System.out.println(this.personRepository.findByAgeGREATER_THAN(25));
	System.out.println("requete animal");
	//System.out.println(this.animalRepository.findBySpeciesCommonName("Chat"));
}

}