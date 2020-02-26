package com.cesi.flore;

import java.util.HashMap;

import com.cesi.flore.behavior.IRacePure;
import com.cesi.flore.type.Etat;

public class Ail extends Vegetal implements IRacePure{
	
	public Ail() {
		this.dessin[3] = "a";
		this.dessin[4] = "A";
	}

	@Override
	public String toString() {
		int index = this.etat.ordinal();
		return this.dessin[index];
	}

	@Override
	public void seReproduire(HashMap<String, Integer> panier) {
		panier.put("Ail", panier.get("Ail") + 3);
	}

	
}
