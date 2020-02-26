package com.cesi.flore;

import com.cesi.Coordonnee;
import com.cesi.flore.behavior.IOgm;

public class Betterave extends Vegetal implements IOgm{
	
	public Betterave() {
		this.dessin[3] = "b";
		this.dessin[4] = "B";
	}

	@Override
	public String toString() {
		int index = this.etat.ordinal();
		return this.dessin[index];
	}

	@Override
	public Coordonnee seDupliquer(int longJardin, int largeJardin) {
		return new Coordonnee(longJardin, largeJardin);
	}

	
}
