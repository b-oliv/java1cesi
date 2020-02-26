package com.cesi.flore;

import com.cesi.flore.type.Etat;

public class Tomate extends Vegetal{
	
	public Tomate() {
		this.dessin[3] = "t";
		this.dessin[4] = "T";
	}

	@Override
	public String toString() {
		int index = this.etat.ordinal();
		return this.dessin[index];
	}

	
}
