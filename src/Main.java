import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		//Aufgabe 2.2
		Stack<Pair<String,Integer>> weDontNeedNoEducation = new Stack<Pair<String,Integer>>();
		weDontNeedNoEducation.add(new Pair<String,Integer>("Informatik",1));
		weDontNeedNoEducation.add(new Pair<String,Integer>("Deutsch",5));
		weDontNeedNoEducation.add(new Pair<String,Integer>("Englisch",5));
		weDontNeedNoEducation.add(new Pair<String,Integer>("Kunst",5));
		weDontNeedNoEducation.add(new Pair<String,Integer>("Mathe",5));
		weDontNeedNoEducation.add(new Pair<String,Integer>("Mathe",1));
		weDontNeedNoEducation.add(new Pair<String,Integer>("Mathe",2));
		weDontNeedNoEducation.add(new Pair<String,Integer>("Sport",6));
		weDontNeedNoEducation.add(new Pair<String,Integer>("Informatik",1));
		weDontNeedNoEducation.add(new Pair<String,Integer>("Informatik",3));
		weDontNeedNoEducation.add(new Pair<String,Integer>("Sport",5));
		Collections.sort(weDontNeedNoEducation);
		weDontNeedNoEducation.forEach(grade -> System.out.println(grade));

		//Aufgabe 2.3
		// HashSet<Pair<String,Integer>> hs1 = new HashSet<Pair<String,Integer>>(weDontNeedNoEducation);
		HashSet<Pair<String,Integer>> hashBrowns = new HashSet<Pair<String,Integer>>();
		
		//1
		for (Iterator<Pair<String,Integer>> iter = weDontNeedNoEducation.iterator(); iter.hasNext();){
			hashBrowns.add(iter.next());
		}
		//2
		for (Iterator<Pair<String,Integer>> iter = weDontNeedNoEducation.iterator(); iter.hasNext(); hashBrowns.add(iter.next()) );
		//3
		{
			Iterator<Pair<String,Integer>> iter = weDontNeedNoEducation.iterator();
			while(iter.hasNext()) hashBrowns.add(iter.next());
		}
		
	}
}