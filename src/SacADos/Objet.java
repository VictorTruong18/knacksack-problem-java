package SacADos;

public class Objet implements Comparable<Objet> {
	private String nom;
	private float poids;
	private float valeur;
	
	public Objet(String nom, float poids, float valeur) {
		this.nom = nom;
		this.poids = poids;
		this.valeur = valeur;
	}
	
	public String getNom() {
		return nom;
	}
	
	public float getPoids() {
		return poids;
	}
	
	public float getValeur() {
		return valeur;
	}

	@Override
	public int compareTo(Objet o) {
		return this.nom.compareTo(o.getNom());
	}
}
