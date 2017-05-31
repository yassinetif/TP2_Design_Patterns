import java.util.*;

public class Test {

		

		public static void main(String[] args){
			
			
			Fichier f1= new Fichier("Fichier 1","aaaaa");
			Fichier f2= new Fichier("Fichier 2", "bbbbbbb");
			Fichier f3= new Fichier("Fichier 3", "ccccccc");
			Fichier f4= new Fichier("Fichier 4", "ddddddd");
			Fichier f5= new Fichier("Fichier 5", "eeeeeeee");
			Fichier f6= new Fichier("Fichier 6", "ffffff");
			
			SystemeFichier sysF= new SystemeFichier();
			sysF.addFichier(f1);
			sysF.addFichier(f2);
			sysF.addFichier(f3);
			sysF.addFichier(f4);
			sysF.addFichier(f5);
			sysF.addFichier(f6);
			//Test système de fichiers
			System.out.println("\n===== Test du système de fichiers =====\n");
			sysF.afficher();
			Iterator<Fichier> it=sysF.iterator();
			
			System.out.println("Plus gros fichier");
			Fichier tmp=new Fichier("fichier test", "");
			Fichier tmp2;
			while(it.hasNext()){
				tmp2=it.next();
				if(tmp.compareTo(tmp2) < 0){
					tmp=tmp2;
				}
			}
			System.out.println(tmp);
			VisiteurConcretA vA = new VisiteurConcretA();
			VisiteurConcretB vB = new VisiteurConcretB();
			
			//Constitution de la hierarchie des dossiers de tests
			Dossier d1 = new Dossier("Dossier 1");
			Dossier d2 = new Dossier("Dossier 2");
			Dossier d3 = new Dossier("Dossier 3");
			Dossier d4 = new Dossier("Dossier 4");
			
			d4.add(f2, f5, f4); // ajout des fichiers f2, f5, f4 dans le dossier d4
			d2.add(f1, (Fichiers)d3, f3); // ajout des  f1, d3, f3 dans le dossier d2
			d1.add((Fichiers)d2, f4, (Fichiers)d4); // ajout des d2, f4, d4 dans le dossier d1
			
			//Test du parcours d'un dossier avec itérateur + composite
			System.out.println("\n===== Test du parcours d'un dossier =====\n");
			
			for(Fichiers f : d1){
				if(f.getClass().getSimpleName()== "Dossier")
					System.out.println(" Dossier : " + f);
				else 
					System.out.println(" fichier : " + f);
			}
			
			System.out.println("\n===== Test du visiteur A =====\n");
			
			for(Fichiers f : d1){
				
				f.accepte(vA);
	
			}
			
			System.out.println("\n===== Test du visiteur B =====\n");
			
			for(Fichiers f : d1){
				
				f.accepte(vB);
			}
			
			System.out.println("Le fichier le plus ancien est : " + vB.getPlusAncien());
		}


		
}
