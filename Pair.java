public class Pair<F,S> {
	private F first;
	private S second;
	
	public Pair(F first, S second){
		this.first = first;
		this.second = second;
	}


	public F getFirst(){
		return first;
	}

	public S getSecond(){
		return second;
	}

	public boolean equals(Object other){
		if (!(other instanceof Pair)) return false;
		return
			F.equals(other.getFirst())
			&& S.equals(other.getSecond());
	}

	public String toString(){
		return first + ", " + second;
	}
}