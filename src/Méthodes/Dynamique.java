package Méthodes;

import java.util.ArrayList;
import java.util.List;

import SacADos.*;

public class Dynamique implements IMethode {
	private int NOMBRE_OBJETS;
	private float MAX_CONTENANCE;
	private float[][] m;
	private List<Objet> objets = new ArrayList<Objet>();
	
	
	
	
	public void initialisationMatrice(SacADos sac) {
		int i = sac.getObjets().size();
		float j = sac.getPoidsMax();
		this.MAX_CONTENANCE = j;
		this.NOMBRE_OBJETS = i;
	    this.m = new float[i][(int) j+1];
	    this.objets.addAll(sac.getObjets());
	   
	}
	
	public void premiereLigne() {
		float j = 0;
		while(j < MAX_CONTENANCE ) {
			if(this.objets.get(0).getPoids() > j) {
				this.m[0][(int) j] = 0;
			}
			else {
				this.m[0][(int) j] = objets.get(0).getValeur();
			}
		j++;
		}
	}
	
	public void remplirMatrice() {
		int i = 1;
		while(i < NOMBRE_OBJETS ) {
			float j = 0;
			while(j < MAX_CONTENANCE + 1 ) {
				
				
				if (this.objets.get(i).getPoids() > j) {
					this.m[i][(int) j] = this.m[(int) (i-1)][(int) j];
				}
				else {
					this.m[i][(int) j] = Math.max(this.m[i-1][(int) j], this.m[i-1][(int) (j-this.objets.get(i).getPoids())] +  this.objets.get(i).getValeur());
				}
			j++;
			}
		i++;
		}
	}
	
	
	public List<Objet> reccupererSousListe() {
		
		int i = NOMBRE_OBJETS - 1;
		int j = (int) MAX_CONTENANCE;
		List<Objet> nouvelleListe = new ArrayList<Objet>();
		while (this.m[i][(int) j] == this.m[i][(int) (j-1)]) {
			j--;	
		}
		while (j > 0) {
			while(i > 0 && this.m[i][(int) j] == this.m[i-1][(int) j]) {	
				i--;
			}
			j = (int) (j - this.objets.get(i).getPoids());
			if(j >= 0) {
				nouvelleListe.add(this.objets.get(i));
				i--;
			}
			
			
		}
		return nouvelleListe;	
	}
	
	
	
	
	
	@Override
	public String toString() {
		String s = "";
		for(int i = 0; i < NOMBRE_OBJETS; i++) {
			for(int j = 0; j < MAX_CONTENANCE + 1; j++) {
				if (j == MAX_CONTENANCE ) {
					s += m[i][j] + "\n";
				}
				else {
					s += m[i][j] + " ";
				}
			}
		}
		return s;
	}
	
	

	@Override
	public void resoudre(SacADos sac) {
		initialisationMatrice(sac); //initialise la taille de la matrice, et la liste d'objets
		this.premiereLigne();
		this.remplirMatrice();
		sac.getObjets().clear();
		sac.getObjets().addAll(this.reccupererSousListe());
		System.out.println(this.toString());
		
		
		
	}

}
