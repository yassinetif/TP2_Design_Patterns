
import java.util.*;
public class Fichier implements Fichiers{
	
	private String nomFichier;
	private int taille;
	private String contenu;
	private Date date;
	
	/**
	 * Constructeur de la class Fichier
	 * @param nomF nom du fichier
	 * @param c contenu du fichier
	 */
	public Fichier(String nomF, String c){
		nomFichier=nomF;
		contenu=c;
		taille=contenu.length();
		date= new Date();
	}
	/**
	 * methode qui permet de donner le nom du fichier
	 * 
	 * @return nomFichier nom du fichier
	 */
	public String getNom(){
		return nomFichier;
	}
	
	/**
	 * methode permettant de donner la taille du fichier
	 * 
	 * @return taille  la taille du fichier
	 */
	public int getTaille(){
		return taille;
	}
	
	/**
	 * methode permettant de renvoyer le contenu du fichier
	 * 
	 * @return contenu contenu du fichier
	 */
	public String getContenuFichier(){
		return contenu;
	}
	
	/**
	 * methode qui permet de renvoyer la date du fichier
	 */
	public Date getDate(){
		return date;
	}
	
	/**
	 * methode qui permet de verifier si les deux fichier sont egaux
	 * @return true si ils sont egaux false sinon
	 */
	public boolean equals(Object o){
		if(o instanceof Fichier){
			Fichier f=(Fichier)o;
			return (nomFichier.equals(f.nomFichier) && taille==f.taille && contenu.equals(f.contenu) && date.equals(f.date) && this.compareTo(f)==0 );
		}
		return false;
	}

	/**
	 * methode qui permet de comparer la taille des deux fichier
	 */
	public int compareTo(Object o){
		return this.compareTo((Fichier)o);
	}
	public int compareTo(Fichier f){
		return(taille - f.getTaille());
	}

	/**
	 * methode d'affichage
	 */
	public String toString(){
		return " Nom : " +nomFichier + ", Taille : " + taille + ", Contenu : " + contenu + ", Date : " + date.toString();
	}
	@Override
	public Iterator<Fichiers> iterator() {
		return new IterateurNull();
	}
	
	private class IterateurNull implements Iterator<Fichiers>{
		
		public boolean hasNext(){
			
			return false;
		}
			
		public Fichiers next(){
				
			return null;
		}
			
		public void remove(){}
	}
	@Override
	/**
	 * Permet au fichier d'accepter un visiteur afin de lui laisser la responsabilité d'affichage et traitement de ses informations
	 * @param v le visiteur implémentant l'interface Visiteur
	 */
	public void accepte(Visiteur v) {
		v.visiteFichier(this);
		
	}
	
}
