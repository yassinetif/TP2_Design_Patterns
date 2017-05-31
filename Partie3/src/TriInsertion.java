import java.util.*;

public class TriInsertion implements StrategieTri{
	public <T extends Comparable<T>> List<T> trie(List<T> donnees){

                int taille=donnees.size();
                int i, j;
                T el ;
            for (i = 1; i < taille; ++i) {
                el = donnees.get(i);
                for (j = i; j > 0 && (donnees.get(j-1)).compareTo(el)> 0; j--){
                        Collections.swap(donnees,j,j-1);
                }donnees.remove(j);
                donnees.add(j, el);

            }
                return donnees;
        }
}