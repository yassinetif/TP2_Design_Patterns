
import java.util.*;


public class SystemeFichier implements Iterable<Fichier> {
	
	private Fichier[] listFichiers;
	private int cpt;
	/**
	 * Constructeur de la classe Systeme Fichier.
	 * 
	 * @param tab tableau de fichier
	 */
	public SystemeFichier(){
		listFichiers=new Fichier[6];
		cpt=0;
	}
	

	@Override
	public Iterator<Fichier> iterator() {
		return new IterateurSystemeFichier(this);
	}
	
	private class IterateurSystemeFichier implements Iterator<Fichier>{
		
		private SystemeFichier sys;
		private int cursor;

		/**
		 * Constructeur de la classe IterateurSystemeFichier
		 * @param s
		 */
		public IterateurSystemeFichier(SystemeFichier s){
			sys=s;
			this.cursor=0;
		}
		
		/**
		 * methode qui renvoie true si y a un fichier dans la case suivant du system du fichier
		 */
		public boolean hasNext() {
            return this.cursor < SystemeFichier.this.cpt;
        }
		
		/**
		 * methode qui permet de renvoyer le fichier suivant dans le systeme de fichier
		 */
		public Fichier next() throws NoSuchElementException{
        	if(this.hasNext()){
        		int i=cursor;
        		cursor++;
        		return (sys.getSysteme())[i];
        	}
			throw new NoSuchElementException();
		}
		/**
		 * methode permettant de supprimer un fichier
		 */
		public void remove(){
			int i=cursor;
			while(i<sys.getNbFichier()){
				(sys.getSysteme())[i]=(sys.getSysteme())[i+1];
				i++;
			}
			(sys.getSysteme())[i]=null;
		}
	}
	
	/**
	 * methode permettant d'ajouter un fichier dans le tableau de fichier
	 * @param f le fichier
	 */
	public void addFichier(Fichier f){
		listFichiers[cpt]=f;
		cpt++;
	}

	/**
	 * methode permettant de renvoyer la liste des fichiers
	 * @return
	 */
	public Fichier[] getSysteme(){
		return listFichiers;
	}
	
	/**
	 * methode permettant de donner le nombre de fichiers qui existent dans le tableau
	 * @return cpt 
	 */
	public int getNbFichier(){
		return cpt;
	}

	/**
	 * methode permettant de renvoyer le fichier dont la position est dans le parametre
	 * @param a position du fichier
	 * @return fichier 
	 */
	public Fichier getFichierRang(int a){
		if(a>=0 && a<cpt){
			return listFichiers[a];
		}
		return null;
	}

	/**
	 * methode permettant d'afficher tous les fichiers qui existent dans le tableau
	 */
	public void afficher(){
		for(Fichier f : listFichiers){
			System.out.println(f);
		}
	}
	
}
