package fr.diginamic.springbootdemo.service;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class BavardService {
	private String nom;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
public String parler() {
	return this.getClass().getSimpleName() + "|" + nom;
}

@PostConstruct
private void postConstruct() {
	System.out.println("pouet");
}
}


