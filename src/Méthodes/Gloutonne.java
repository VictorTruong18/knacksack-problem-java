package Méthodes;

import java.util.*;

import SacADos.Objet;
import SacADos.SacADos;

public class Gloutonne implements IMethode {
	
	public TreeMap<Float, Objet> getRapport(List<Objet> objets){
		TreeMap<Float, Objet> map = new TreeMap<>();
		for (Objet objet : objets) {
			Float rapport = objet.getValeur()/objet.getPoids();
			
			map.put(rapport,objet);
		}
		return map;	
	}
	

	public List<Objet> getRangement(TreeMap<Float,Objet>  map, float poidsmax){
		
		NavigableMap mapReverse = map.descendingMap();
		
		float poidsDuSac = 0;
        List<Objet> nouvelleListeObjets = new ArrayList<Objet>();
		
		Set set = mapReverse.entrySet(); 
        Iterator i = set.iterator(); 
        
       
  
        // Traverse map and print elements 
        while (i.hasNext()) { 
            Map.Entry me = (Map.Entry)i.next();
            
            if((poidsDuSac += this.getPoids((Objet) me.getValue())) <= poidsmax) {
            	
            	nouvelleListeObjets.add((Objet)me.getValue());
            }
            else {
            	poidsDuSac -= this.getPoids((Objet) me.getValue());
            	
            }
        }
		return nouvelleListeObjets;	
	}
	
	public float getPoids(Objet object) {
		return object.getPoids();
	}
	
	
	
	@Override
	public void resoudre(SacADos sac) {
		
		List<Objet> objets;
		objets = this.getRangement(this.getRapport(sac.getObjets()), sac.getPoidsMax());
		sac.getObjets().clear();
		sac.getObjets().addAll(objets);
		
	}
	
}
