import java.util.*;

public class Singleton {
	private static StrategieTri bulle=new TriBulle();
	private static StrategieTri java=new TriJava();
	private static StrategieTri insertion=new TriInsertion();
	private static Singleton s;

	private Singleton(){
	}

	public static Singleton creerSingleton(){
		if(s==null){
			s=new Singleton();
		}
		return s;
	}
	public List<String> triBulle(List<String> lst){
		return bulle.trie(lst);
	}
	public List<String> triJava(List<String> lst){
		return java.trie(lst);
	}
	public List<String> triInsertion(List<String> lst){
		return insertion.trie(lst);
	}
}