import java.util.Scanner;


public class Main {	
	public static void main(String args[]) {
		Game game = new Game(); 
		Player player = new Player();
		int order = 1; // variable store Players' order (1 : Player1, 2 : Player2)
		char stone = player.Get_stone(); // store Player's stone
		Scanner keyboard = new Scanner(System.in);
		char x, y; // variables store location (x, y)(A<=x<=S and A<=y<=S) where player want to put stone 
		int count; // variable store number of connected stones
		boolean yesno = true; 
		
		System.out.println("========================================================"); // Game Rules
		System.out.println("                 Welcome to Omok Game                ");
		System.out.println("========================================================");
		System.out.println("Player1 & Player2 have to Lay a stone to (x,y) on board ");
		System.out.println("                  A<=x<=S and A<=y<=S                   ");
		System.out.println("The player whose stones are connected 5 will be winner!!");
		System.out.println("                      Enjoy Game!!                      ");
		System.out.println("========================================================");
		
		game.Print_board(); // Print Board
		
		while(true) {
			do {
				System.out.println("Player"+order+"'s Turn > "); 
				x = keyboard.next().charAt(0); // input location x (A<=x<=S)
				y = keyboard.next().charAt(0); // input location y (A<=y<=S)
				yesno = game.Set_board(x, y,stone);	// if input is right, then yesno == true else yesno == false
			
			} while(!yesno); // iterate when yesno == false
			
			count = game.Check_vertical(); // store count number of stones connected vertically
			if(count == 5) { // if 5 stones are connected
				System.out.println("Player"+order+" Win!!"); // print Winner
				game.Print_board(); // print Board
				break; // Escape loop ====> Exit Program
			}
			
			count = game.Check_horizontal(); // store count number of stones connected horizontally 
			if(count == 5) { // if 5 stones are connected
				System.out.println("Player"+order+" Win!!"); // print Winner
				game.Print_board(); // print Board
				break; // Escape loop ===> Exit Program
			}
			
			count = game.Check_left_diagonal(); // store count number of stones connected left_diagonally
			if(count == 5) { // if 5 stones are connected
				System.out.println("Player"+order+" Win!!"); // print Winner
				game.Print_board(); // print Board
				break; // Escape loop ===> Exit Program
			}
		
			count = game.Check_right_diagonal(); // store count number of stones connected right_diagnonally
			if(count == 5) { // if 5 stones are connected
				System.out.println("Player"+order+" Win!!"); // print Winner
				game.Print_board(); // print Board
				break; // Escape loop ===> Exit Program
			}

			
			game.Print_board(); // Print Board
			
			order = player.Change_player(); // Change Player (Player1->Player2 or Player2->Player1)
			stone = player.Get_stone(); // Get Player's stone
		}
		keyboard.close();
	}
}
