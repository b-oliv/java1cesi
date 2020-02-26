package com.cesi.flore;

import java.util.HashMap;

import com.cesi.flore.behavior.IRacePure;

public class Carotte extends Vegetal implements IRacePure{
	
	public Carotte() {
		this.dessin[3] = "c";
		this.dessin[4] = "C";
	}

	@Override
	public String toString() {
		int index = this.etat.ordinal();
		return this.dessin[index];
	}
	
	@Override
	public void seReproduire(HashMap<String, Integer> panier) {
		panier.put("Carotte", panier.get("Carotte") + 3);
	}

	
}
