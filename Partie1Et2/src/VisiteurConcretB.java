/**
 * cette classe permet de retrouver le fichier le plus ancien qu'il rencontre lors du parcours d'une arborescence
 * @author Yassine M'CHAAR
 *
 */
public class VisiteurConcretB implements Visiteur{
	Fichiers plusAncien;
	
	public void visiteFichier(Fichier f) {
		
		if((plusAncien  == null) || (plusAncien.getDate().compareTo(f.getDate()) < 0)){
			
			plusAncien = f;
		}
	}

	@Override
	public void visiteDossier(Dossier d) {
		
		if((plusAncien  == null) || (plusAncien.getDate().compareTo(d.getDate()) < 0)){
			
			plusAncien = d;
		}
	}

	public Fichiers getPlusAncien(){
		
		return plusAncien;
	}

}
