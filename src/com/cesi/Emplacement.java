package com.cesi;

import com.cesi.flore.Vegetal;

public class Emplacement {
	
	private Vegetal vegetal;

	public Emplacement() {}
	
	public Emplacement(Vegetal vegetal) {
		this.vegetal = vegetal;
	}
	
	public Vegetal getVegetal() {
		return vegetal;
	}
	
	public String toString() {
		if(this.vegetal == null) {
			return "0";
		}
		return this.vegetal.toString();
	}

}
