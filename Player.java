public class Player { // Player Class
	private char stone;
	private int order;
	
	public Player() { // Constructor
		stone = '●'; // Player1's stone
		order = 1; // Now Player1 is playing the game
	}
	
	public int Change_player() {
		if(order == 2) { // Player2 is now playing the game
			order = 1; // Player2 -> Player1
		}
		else { // Player1 is now playing the game
			order = 2; // Player1 -> Player2
		}
		
		return order;
		
	}
	
	public char Get_stone() {
		if(order == 2) {
			stone = '○';
		}
		else {
			stone = '●';
		}
		
		return stone;
	}
	
}

