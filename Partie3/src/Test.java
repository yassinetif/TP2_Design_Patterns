import java.util.*;

public class Test {
	public static void main(String[] args){
		List<String> list=new ArrayList<String>();
		list.add("e");
		list.add("f");
		list.add("d");
		list.add("b");
		list.add("c");
		list.add("a");

		System.out.println("liste à trier : ");
		System.out.println(list);
		
		Singleton sglt=Singleton.creerSingleton();
		
		System.out.println("Tri bulle : ");
		System.out.println(sglt.triBulle(list));
		System.out.println("Tri java : ");
		System.out.println(sglt.triJava(list));
		System.out.println("Tri insertion : ");
		System.out.println(sglt.triInsertion(list));
	}
}