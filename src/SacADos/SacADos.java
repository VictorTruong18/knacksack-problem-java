package SacADos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Méthodes.IMethode;

public class SacADos {
	private List<Objet> objets;
	private float poidsmaximal;
	private IMethode methode;
	
	public SacADos(String chemin, float poidsmaximal, IMethode methode) {
		objets = new ArrayList<Objet>();
		String fileName = chemin;
		File file = new File(fileName);
			try {
			Scanner inputStream = new Scanner(file);
				while(inputStream.hasNext()) {
					String data = inputStream.nextLine();
					String[] values = data.split(";");
					
					float poids = Float.parseFloat(values[1]);
					float valeur = Float.parseFloat(values[2]);
					Objet objet = new Objet(values[0], poids ,valeur);
					objets.add(objet);
				}
			inputStream.close();
			} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		this.poidsmaximal = poidsmaximal;
		this.methode = methode;
	}
	
	
	public List<Objet> getObjets(){
		return this.objets;
	}
	
	public float getPoidsMax() {
		return this.poidsmaximal;
	}
	
	public String toString() {
		String s="";
		for(Objet objet : objets) {
			s += objet.getNom() + "  " + objet.getPoids() + "  " + objet.getValeur() + System.lineSeparator();
		}
		return s;
	}
	
	public void resoudre() {
		methode.resoudre(this);
	}
	
	public float getValeurTotal() {
		float valeurTotal = 0;
		for(Objet objet : objets) {
			valeurTotal += objet.getValeur();
		}
		return valeurTotal;
	}
	
	
}
