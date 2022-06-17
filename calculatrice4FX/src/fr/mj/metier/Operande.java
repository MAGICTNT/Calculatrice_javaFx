package fr.mj.metier;

import java.math.BigDecimal;

public class Operande {

	private String string = "";

	private BigDecimal bigDecimal = new BigDecimal(0);

	private String initialString;
	private int precision = 15;

	public Operande(String initialString) {
		super();
		this.initialString = initialString;
		initialize();
	}

	void initialize() {
		try {
			this.string = initialString;
			stringToBigDecimal();

		} catch (Exception e) {
			this.bigDecimal = new BigDecimal(0);
			this.string = "";
		}
	}

	void stringToBigDecimal() {
		this.bigDecimal = new BigDecimal(string);
	}

	void bigDecimalToString() {
		this.string = this.bigDecimal.toString();
	}

	public void ajouterChiffre(String touche) {
		if(string.equals("0"))
			string = "";
		string += touche;
		stringToBigDecimal();
	}

	public boolean isEmpty() {
		return string.isEmpty();
	}

	@Override
	public String toString() {
		return string ;
	}

	public void ajouterPoint() {
		if(!string.contains("."))
			string += ".";
	}

	public void add(Operande other) {
		
		bigDecimal = bigDecimal.add(other.bigDecimal);
		bigDecimalToString();
		
	}

	public void divise(Operande other) {
		bigDecimal = bigDecimal.divide(other.bigDecimal);
		bigDecimalToString();
	}

	public void mutiplier(Operande other) {
		bigDecimal = bigDecimal.multiply(other.bigDecimal);
		bigDecimalToString();
	}

	public void soustraction(Operande other) {
		bigDecimal = bigDecimal.subtract(other.bigDecimal);
		bigDecimalToString();
	}

	public Object puissance(Operande other) {
		bigDecimal = bigDecimal.pow(other.bigDecimal);
		bigDecimalToString();
	}

}
