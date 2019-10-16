package cranelevel6;

public class Chess {

	public void setup(){
		//Opening screen?
		//create and place squares
		//create and place pieces
		//start game
		Board board = new Board();
		System.out.println(board.getTiles()[0][0].getxCord());
	}
	
	public static void main(String[] args) {
		Chess chess = new Chess();
		chess.setup();
		
	}
}
