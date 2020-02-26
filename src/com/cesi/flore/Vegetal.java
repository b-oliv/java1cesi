package com.cesi.flore;

import com.cesi.flore.type.Etat;

public abstract class Vegetal {
	
	Etat etat;
	String[] dessin;
	
	public Vegetal() {
		this.etat = Etat.GRAINE;
		this.dessin = new String[]{"_ ", ".", "i", "", "", "#"};
	}
	
	public void grandir() {
		if(this.etat.ordinal() < 5) {
			this.etat = Etat.values()[this.etat.ordinal() + 1];
		}
	}
	
	public Etat getEtat() {
		return etat;
	}

	public abstract  String toString();

}
