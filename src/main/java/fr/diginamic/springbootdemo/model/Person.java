package fr.diginamic.springbootdemo.model;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="person")
@Component
public class Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(columnDefinition = "Integer(11)")
	private Integer age;
	
	@Column(columnDefinition = "varchar(50)")
	private String firstname;
	
	@Column(columnDefinition = "varchar(50)")
	private String lastname;
	
	@ManyToMany
	@JoinTable( name = "person_animals",
    joinColumns = @JoinColumn( name = "person_id", referencedColumnName = "id" ),
    inverseJoinColumns = @JoinColumn( name = "animals_id", referencedColumnName = "id" ) )
	private List<Animal> pet = new ArrayList<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public List<Animal> getPet() {
		return pet;
	}

	public void setPet(List<Animal> pet) {
		this.pet = pet;
	}

	@Override
	public String toString() {
		return "Person [age=" + age + ", firstname=" + firstname + ", lastname=" + lastname + "]";
	}
	
	
}
