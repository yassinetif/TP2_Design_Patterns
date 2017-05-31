import java.util.Arrays;
import java.util.List;
import java.util.Date;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Iterator;

/**
 * la classe Dossier contient des fichiers stockés dans une liste chainée
 * @author Yassine M'CHAAR
 *
 */
public class Dossier implements Fichiers {
	private String nom;
	private List<Fichiers> lstFichiers;
	private int taille;
	private Date dateCreation;
	
	/**
	 * Constructeur de la classe Dossier
	 * @param nd le nom du dossier
	 */
	public Dossier(String nd){
		nom=nd;
		taille=0;
		dateCreation=new Date();
		lstFichiers=new LinkedList<Fichiers>();
	}
	
	/**
	 * Constructeur de la classe Dossier
	 * @param nd le nom du dossier
	 * @param lstFich le tableau de fichiers
	 */
	public Dossier(String nd, Fichiers[] lstFich){
		this(nd);
		lstFichiers.addAll(Arrays.asList(lstFich));
		taille=getTaille();
	}
	
	/**
	 * Constructeur de la classe Dossier
	 * @param nd nom du dossier
	 * @param f le Fichiers
	 */
	public Dossier(String nd, Fichiers f){
		this(nd);
		lstFichiers.add(f);
		taille=getTaille();
	}
	/**
	 * methode permettant d'ajouter un ensemble de fichier au dossier
	 * @param f un ou plusieurs fichiers
	 */
	public void add(Fichiers ... f){
		
		lstFichiers.addAll(Arrays.asList(f));
		taille = getTaille();
	}
	
	/**
	 * methode permettant de renvoyer la taille du dossier
	 * @return La taille du dossier
	 */
	public int getTaille() {
			
			int taille = 0;
			
			for(Fichiers f : lstFichiers){
				
				taille += f.getTaille();
			}
			
			return taille;
	}
	
	/**
	 * @return La date de création du dossier
	 */
	public Date getDate(){
		
		return dateCreation;
	}
	/**
	 * @return Le nom du dossier
	 */
	@Override
	public String getNom() {
		
		return nom;
	}
	
	/**
	 * @return Un itérateur sur tous les fichiers contenus par le dossier et ses sous-dossiers
	 */
	public Iterator<Fichiers> iterator(){
		
		return new IterateurDossier();
	}
	
	private class IterateurDossier implements Iterator<Fichiers>{
			
			private Stack<Iterator<Fichiers>> pileIt; // pile Iterateur
			private Iterator<Fichiers> it; 
			
			public IterateurDossier(){
				
				it = lstFichiers.iterator();
				pileIt = new Stack<Iterator<Fichiers>>();
			}
			
			public boolean hasNext(){
				
				//On supprime les itérateurs qui n'ont plus rien à fournir
				while(!pileIt.empty() && !pileIt.peek().hasNext()){
				
					pileIt.pop();
				}
				
				//On retourne vrai s'il reste un itérateur valide dans la pile
				if(!pileIt.empty()){
					
					return true;
				}
				else{
					
					return (it.hasNext());
				}
			}
				
			public Fichiers next(){
				
				//On retourne un fichier si un itérateur le permet, sinon null
				if(!pileIt.empty()){
					
					return (pileIt.peek().next());
				}
				//Si on retourne dans le dossier actuel, on retourne le fichier suivant et on empile son itérateur
				else{
					
					Fichiers tmp = it.next();
					pileIt.push(tmp.iterator());
					return (tmp);
				}
			}
				
			public void remove(){}
	}
	
	/**
	 * methode d'affiche du dossier
	 */
	public String toString(){
		
		return (nom + ", Taille: " + taille + " ," + " Date De Creation: " + dateCreation);
	}
	/**
	 * methode qui permet au dossier d'accepter un visiteur afin de lui laisser la responsabilité d'affichage et traitement de ses informations
	 * @param v  Le visiteur implémentant l'interface Visiteur
	 */
	public void accepte(Visiteur v){
		
		v.visiteDossier(this);
	}
	
}
