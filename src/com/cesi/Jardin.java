package com.cesi;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.cesi.flore.Ail;
import com.cesi.flore.Betterave;
import com.cesi.flore.Carotte;
import com.cesi.flore.Tomate;
import com.cesi.flore.Vegetal;
import com.cesi.flore.behavior.IOgm;
import com.cesi.flore.behavior.IRacePure;
import com.cesi.flore.type.Etat;

public class Jardin {

	private int longueur;
	private int largeur;
	private Emplacement[][] emplacement;
	private HashMap<String, Integer> panier;

	public Jardin() {
	}

	public Jardin(int longueur, int largeur) {
		this.longueur = longueur;
		this.largeur = largeur;
		this.emplacement = new Emplacement[longueur][largeur];
		this.panier = new HashMap<String, Integer>();
		this.initPanier();
	}
	
	private void initPanier() {
		this.panier.put("Ail", 2);
		this.panier.put("Tomate", 2);
		this.panier.put("Carotte", 2);
		this.panier.put("Betterave", 2);

	}

	public void init() {
		this.initEmplacement();
		this.showEmplacement();
		this.showPanier();
		this.runUserAction();
	};
	
	private void runUserAction() {
		int numberAction = 0; 
		while(numberAction != 4) {
			this.informationAction();
			numberAction = this.userAction();
			if(numberAction == 1) {
				this.sowSeeds();
			}else if(numberAction == 2) {
				this.collect();
			}else if(numberAction == 3) {
				this.nextSeason();
			}
			this.showEmplacement();
		}
	}

	private void initEmplacement() {
		for ( int i = 0 ; i <  this.longueur ; ++i){
			for ( int j=0 ; j < this.largeur ; ++j){
				this.emplacement[i][j] = new Emplacement();
		    }
		}
	}
	
	private void sowSeeds() {
		int counter = 1;
		for ( int i = 0 ; i <  this.longueur ; ++i){
			for ( int j=0 ; j < this.largeur ; ++j){
				System.out.print("Emplacement " + counter + " (Choix de la graine: 1-AIL 2-TOMATE 3-CAROTTE 4-BETTERAVE)");
				int numberAction = this.userAction();
				this.emplacement[i][j] = new Emplacement(this.defineVegetalClass(numberAction));
				counter++;
		    }
			System.out.println();
		}
	}
	
	private void collect() {
		for ( int i = 0 ; i <  this.longueur ; ++i){
			for ( int j=0 ; j < this.largeur ; ++j){
				if(this.emplacement[i][j].getVegetal() != null) {
					if(this.emplacement[i][j].getVegetal().getEtat().equals(Etat.FLEUR)) {
						if(this.emplacement[i][j].getVegetal() instanceof IRacePure){
							IRacePure v = (IRacePure) this.emplacement[i][j].getVegetal();
							v.seReproduire(this.panier);
							this.emplacement[i][j] = new Emplacement();
						}else if(this.emplacement[i][j].getVegetal() instanceof IOgm) {
							IOgm v = (IOgm) this.emplacement[i][j].getVegetal();
							Coordonnee coordonnee = v.seDupliquer(this.longueur, this.largeur );
							if(this.emplacement[coordonnee.getX()][coordonnee.getY()] == null) {
								this.emplacement[coordonnee.getX()][coordonnee.getY()] = new Emplacement(new Betterave());
							}
						}else {
							this.emplacement[i][j] = new Emplacement();
						}
					}
				}
		    }
		}
		this.showPanier();
	}
	
	private Vegetal defineVegetalClass(int index) {
		Vegetal vegetal = null;
		switch(index){
			case 1:
				vegetal = new Ail();
				break;
			case 2:
				vegetal = new Tomate();
				break;
			case 3:
				vegetal = new Carotte();
				break;
			case 4:	
				vegetal = new Betterave();
				break;
		}
		return vegetal;
	}
	
	private int userAction() {
		Scanner scanner = new Scanner(System.in);
		int index = scanner.nextInt();
		if( index > 0 && index < 5) {
			return index;
		}
		System.out.println("Veuillez Choisir un nombre entre 1 et 4");
		return this.userAction();
	}
	
	private void showEmplacement() {
		System.out.println("Le jardin:");
		for ( int i = 0 ; i <  this.longueur ; ++i){
			for ( int j=0 ; j < this.largeur ; ++j){
				System.out.print(this.emplacement[i][j].toString());
		    }
			System.out.println();
		}
	}
	
	private void showPanier() {
		for(Map.Entry<String, Integer> entry : this.panier.entrySet()) {
		    String key = entry.getKey();
		    Integer value = entry.getValue();
		    System.out.println(key + " : " + value +  " graine(s)");
		}
	}
	
	private void nextSeason() {
		for ( int i = 0 ; i <  this.longueur ; ++i){
			for ( int j=0 ; j < this.largeur ; ++j){
				if(this.emplacement[i][j].getVegetal() != null) {
					this.emplacement[i][j].getVegetal().grandir();
				}
		    }
		}
	}
	
	private void informationAction() {
		System.out.println( "1. Semer une graine ");
		System.out.println( "2. Récolter toutes les plantes qui sont matures ;");
		System.out.println( "3. Passer à la saison suivante (toutes les plantes grandissent) ;");
		System.out.println( "4. Quitter l’application. ");
	}

}
