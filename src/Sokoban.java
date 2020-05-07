public class Sokoban {
	private static Pair<Integer, Integer> NORTH = new Pair<Integer, Integer>(0,1);
	private static Pair<Integer, Integer> SOUTH = new Pair<Integer, Integer>(0,-1);
	private static Pair<Integer, Integer> WEST = new Pair<Integer, Integer>(-1,0);
	private static Pair<Integer, Integer> EAST = new Pair<Integer, Integer>(1,0);

	private char[/*y*/][/*x*/] board;


	public static void main(String[] args) {
		char[][] sokoban = getDefaultField();
		System.out.println(sokobanToString(sokoban ));
		moveNorth(sokoban );
		System.out.println(sokobanToString(sokoban ));
		moveEast(sokoban );
		System.out.println(sokobanToString(sokoban ));
		moveSouth(sokoban );
		System.out.println(sokobanToString(sokoban ));
		moveSouth(sokoban );
		System.out.println(sokobanToString(sokoban ));
		moveSouth(sokoban );
		System.out.println(sokobanToString(sokoban ));
		moveSouth(sokoban );
		System.out.println(sokobanToString(sokoban ));
		moveSouth(sokoban );
		System.out.println(sokobanToString(sokoban ));
		moveEast(sokoban );
		System.out.println(sokobanToString(sokoban ));
		moveSouth(sokoban);
		System.out.println(sokobanToString(sokoban ));
		moveEast(sokoban);
		System.out.println(sokobanToString(sokoban ));
		moveWest(sokoban);
		System.out.println(sokobanToString(sokoban ));
	}

	public Sokoban() {
		board = getDefaultField();
	}


	public static Pair<Integer,Integer> findPlayer(char[][] board){
		for(int y = 0; y < board.length; y++){
			for(int x = 0; x < board[y].length; x++){
				if ('@'==board[y][x]){
					return new Pair<Integer,Integer>(x,y);
				}
			}
		}
		return null;
	}

	private static void setField(char[][] board,Pair<Integer,Integer> pos, char newChar){
		board[pos.getSecond()][pos.getFirst()] = newChar;
	}

	private static char getField(char[][] board, Pair<Integer, Integer> pos){
		return board[pos.getSecond()][pos.getFirst()];
	}

	private static boolean move(char[][] board, Pair<Integer,Integer> direction){
		final Pair<Integer,Integer> oldPos = findPlayer(board);
		final Pair<Integer,Integer> newPos = new Pair<Integer,Integer>(
			oldPos.getFirst() + direction.getFirst(), 
			oldPos.getSecond() + direction.getSecond());
		final Pair<Integer,Integer> twoAheadPos = new Pair<Integer,Integer>(
			newPos.getFirst() + direction.getFirst(), 
			newPos.getSecond() + direction.getSecond());
		final char charAtNewPos;
		try {
			charAtNewPos = getField(board,newPos);
		} catch (IndexOutOfBoundsException e) {
			return false;
		}
		
		
		switch (charAtNewPos) {
			case '$':
				try {
					final char charTwoAhead = getField(board,twoAheadPos);
					if ('.'==charTwoAhead){
						setField(board, twoAheadPos, '$');
					} else {
						return false;
					}
				} catch (IndexOutOfBoundsException e) {
					/* man kann Kisten auch aus dem Spielfeld rausschieben.
					Habe dies aus der "Grafik" entnommen, sonst wären da keine Wände am Rand. */
				}
			case '.':
				setField(board, newPos, '@');
				setField(board, oldPos, '.');
				return true;
			default:
				return false;
		}
	}

	public static boolean moveNorth(char[][] board){
		return move(board, NORTH);
	}

	public static boolean moveSouth(char[][] board){
		return move(board, SOUTH);
	}

	public static boolean moveWest(char[][] board){
		return move(board, WEST);
	}

	public static boolean moveEast(char[][] board){
		return move(board, EAST);
	}


	public static String sokobanToString(char[][] board){
		String out = "";
		for (int i = board.length-1 ; 0 <= i; i--) {
			out += new String(board[i]);
			out += '\n';
		}
		return out;
	}


	public static char[][] getDefaultField(){
		return new char[][]{
			{'#','#','#','#','#','#','#'},
			{'#','.','.','.','.','.','#'},
			{'#','.','.','.','.','.','#'},
			{'#','.','.','.','.','.','#'},
			{'#','.','.','$','.','.','#'},
			{'#','.','$','@','$','.','#'},
			{'#','.','.','$','.','.','#'},
			{'#','.','.','.','.','.','#'},
			{'#','.','.','.','.','.','#'},
			{'#','.','.','.','.','.','#'},
			{'#','#','#','#','#','#','#'}
		};
	}

}