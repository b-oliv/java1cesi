package com.cesi;

public class Coordonnee {
	
	private int x;
	private int y;
	private int longueurMax;
	private int largeurMax;
	
	public Coordonnee(int longueurMax, int largeurMax) {
		this.longueurMax = longueurMax;
		this.largeurMax = largeurMax;
	}
	
	private void generateNewEmplacement() {
		this.x = (int)(Math.random() * this.largeurMax) ; 
		this.y = (int)(Math.random() * this.longueurMax) ; 
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

}
