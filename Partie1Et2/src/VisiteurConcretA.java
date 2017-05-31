/**
 * Ce visiteur affiche le contenu des fichiers qu'il parcours ou le nom des fichiers situés au premier niveau des dossiers  
 */
public class VisiteurConcretA implements Visiteur {

	public void visiteFichier(Fichier f) {
		
		System.out.println(f.getContenuFichier());
	}


	public void visiteDossier(Dossier d) {
		
		System.out.println("Dossier: " + d.getNom() + " :\n");
		
		for(Fichiers f : d){
			
			System.out.println("\t" + f.getNom());
		}
	}
}
