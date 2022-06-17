package fr.mj.metier;

import java.util.Objects;
import java.util.regex.Pattern;

public class Calculatrice {
	
	private Operande chiffre1 = new Operande("0");
	private Operande chiffre2 = new Operande("");
	private String operateur;
	

	
	public Calculatrice() {
		operateur = "";
		
	}



	public void touche(String touche) {
		switch(touche) {
		case "." -> ajouterPoint();
		case "=" -> calculer(touche);
		default -> {
			if(Pattern.matches("[0-9]",touche)) ajouterChiffre(touche);
			if("+-*/^".contains(touche)) ajouterOperateur(touche);
		}
		}
	}







	private void ajouterOperateur(String touche) {
		if(!chiffre2.isEmpty())
			calculer(touche);
		operateur = touche;
		
	}



	private void ajouterChiffre(String touche) {
		if(operateur.isEmpty())
			chiffre1.ajouterChiffre(touche);
		else
			chiffre2.ajouterChiffre(touche);
	}


	private void calculer(String touche) {
		
		if(!chiffre2.isEmpty())
			switch(operateur) {
			case "+" -> chiffre1.add(chiffre2);
			case "/" -> chiffre1.divise(chiffre2);
			case "-" -> chiffre1.soustraction(chiffre2);
			case "*" -> chiffre1.mutiplier(chiffre2);
			case "^" -> chiffre1.puissance(chiffre2);
			}

		
		chiffre2.initialize();
		operateur = "";
	}



	private void ajouterPoint() {
		if(operateur.isEmpty())
			chiffre1.ajouterPoint();
		else
			chiffre2.ajouterPoint();
	}



	@Override
	public String toString() {
		return chiffre1 + operateur + chiffre2 ;
	}



	
}
