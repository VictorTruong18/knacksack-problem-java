package Arbre;

import java.awt.List;
import java.util.ArrayList;

import SacADos.*;

public class ABR {
	private ArrayList<Objet> valeur;
	private ABR filsgauche;
	private ABR filsdroit;
	
	public ABR() {
		valeur = new ArrayList<Objet>();
		this.filsgauche = null;
		this.filsdroit = null;
	}
	
	public ABR(ABR a) {
		
	}
	
	public ABR(ArrayList<Objet> objets) {
		
	}
	
}
