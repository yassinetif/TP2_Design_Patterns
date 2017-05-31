import java.util.*;

public class TriBulle implements StrategieTri{
	public <T extends Comparable<T>> List<T> trie(List<T> donnees){
                {
                    boolean tabEnOrdre = false;
                    int taille = donnees.size();
                    while(!tabEnOrdre)
                    {
                    	tabEnOrdre = true;
                        for(int i=0 ; i < taille-1 ; i++)
                        {
                            if((donnees.get(i)).compareTo(donnees.get(i+1))>0)
                            {
                                Collections.swap(donnees,i,i+1);
                                tabEnOrdre = false;
                            }
                        }
                        taille--;
                    }
                }
                return donnees;
        }
}