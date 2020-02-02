package Appli;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import Méthodes.*;

import Méthodes.IMethode;
import SacADos.SacADos;

public class main {

	public static void main(String[] args) {
		String chemin = "/Users/victortruong/Documents/Cours - Paris Descartes/S3/AAV/PROJET AAV/PROJET AAV/PROJET AVV/src/Docs/Data2.txt";
		
		IMethode Gloutonne = new Gloutonne();
		
		
		SacADos sac = new SacADos(chemin,20,Gloutonne);
		sac.resoudre();
		
		
		IMethode Dynamique = new Dynamique();
		
		
		SacADos sac2 = new SacADos(chemin,50,Dynamique);
		
		sac2.resoudre();
		System.out.println(sac2.toString());
		System.out.println(sac2.getValeurTotal());
		
		
		sac.resoudre();
		System.out.println(sac.toString());
		System.out.println(sac.getValeurTotal());
		
	



		
	}

}
