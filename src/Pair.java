import java.util.Objects;

public class Pair<F extends Comparable<F>, S extends Comparable<S>> implements Comparable<Pair<F, S>> {
	/*
	zu Aufgabe 1.1:
	alle Objektvariablen müssen final sein.
	
	Aufgabe 1.2:
	Es ist sinnvoll, immutables zu verwenden, da man sich damit Null-Checks bzw. validierung der Variablen spart.
	
	Aufgabe 1.3:
	Es ist schwer zu garantieren, dass generische Klassen komplett immutable sind, da man sie mit Objekten "füttern" kann, die nicht immutable sind.
	Damit ist nur die Objektreferenz unverändert.
	*/
	private final F first;
	private final S second;
	

	public Pair(F first, S second) {
		this.first = first;
		this.second = second;
	}


	@Override
	public int hashCode() {
		return Objects.hash(first, second);
	}


	@Override
	public int compareTo(Pair<F,S> otherPair) {
		int compareFirst = first.compareTo(otherPair.first);
		if (0 != compareFirst){
			return compareFirst;
		} else {
			return second.compareTo(otherPair.second);
		}
	}


	@Override
	public boolean equals(Object otherObject) {
		if (otherObject == this) return true;
		if (!(otherObject instanceof Pair)) return false;
		
		Pair<?,?> otherPair = (Pair<?,?>) otherObject;
		return
			Objects.equals(first, otherPair.first)
			&& Objects.equals(second, otherPair.second);
	}


	@Override
	public String toString() {
		return "Pair("+ first +","+ second +")";
	}


	public F getFirst() {
		return this.first;
	}


	public S getSecond() {
		return this.second;
	}
}