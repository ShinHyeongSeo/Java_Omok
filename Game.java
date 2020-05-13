public class Game { // Game class
	private char[][] board; // Game Board
	private int x, y; // place where put stone
	private char stone; // Player's stone
	
	public Game() { // Constructor
		int i,j;
		board = new char[20][20]; // memory allocating
		
		for(i = 0; i < 19; i++) { 
			for(j = 0; j < 19; j++) {
				board[i][j] = '-'; // fill all board with '-'
			}
		}
	}
	
	public boolean Set_board(char x, char y, char stone) { // Put stone on the board
		this.x = x-65; // convert x to int value use ASCII CODE (A -> 0, B -> 1, .... R -> 17, S -> 18)
		this.y = y-65; // convert y to int value use ASCII CODE (A -> 0, B -> 1, .... R -> 17, S -> 18)
		this.stone = stone;

		if(x < 'A' || x > 'S' || y < 'A' || y > 'S') { // if input variable is out of range
			System.out.println("You Entered Incorrect Value!"); // print message
			return false;
		}
		else if(board[this.x][this.y] != '-') { // if stones are already in location(num_x,num_y)
			System.out.println("Stones are already in space!"); // print message
			return false;
		}
		
		else { // input variables are within range and stones are not in location(num_x,y)
			board[this.x][this.y] = stone; // Put a stone
			if(Check_3x3() >= 2) { // if place where put stone is break the 3x3 rule
				System.out.println("3x3 is Prohibitied!!"); // print message
				board[this.x][this.y] = '-'; // delete stone
				return false;
			}
			return true; // if place where put stone is follow the 3x3 rule
		}
	}
	
	public int Check_3x3() { // Check 3x3 rule
		int count1,count2 = 0;
		
		count1 = Check_vertical();
		if(count1 == 3) { // 3stones are connected vertically
			count2++;
		}
		count1 = Check_horizontal();
		if(count1 == 3) { // 3stones are connected horizontally
			count2++;
		}
		count1 = Check_left_diagonal();
		if(count1 == 3) { // 3stones are connected left diagonally
			count2++;
		}
		count1 = Check_right_diagonal();
		if(count1 == 3) { // 3stones are connected right diagonally
			count2++;
		}
		
		return count2;	
	}
	
	public int Check_vertical() { // Check vertically connected stones
		int step_x; // variable stores num_x
		int count = 1; // variable stores number of connected stones
		
		step_x = x+1; // store num_x+1 (it means go down to check number of connected stones)
		while(0 <= step_x && step_x <= 18 && board[step_x][y] == stone) { // if location is within range and stones are connected
			step_x++; // Go Down
			count++; //  Increase count
		}
		
		step_x = x-1; // store num_x-1 (it means go up to check number of connected stones
		while(0 <= step_x && step_x <= 18 && board[step_x][y] == stone) { // if location is within range and stones are connected
			step_x--; // Go Up
			count++; //  Increase count
		}
		return count; // Return number of connected stones vertically

	}
	
	public int Check_horizontal() { // Check horizontally connected stones
		int step_y; // variable stores num_y
		int count = 1; // variable stores number of connected stones
		
		step_y = y+1; // store num_y+1 (it means go right to check number of connected stones)
		while(0 <= step_y && step_y <= 18 && board[x][step_y] == stone) { // if location is within range and stones are connected
			step_y++; // Go Right
			count++; //  Increase count
		}
		
		step_y = y-1; // store num_y-1 (it means go left to check number of connected stones)
		while(0 <= step_y && step_y <= 18 && board[x][step_y] == stone) { // if location is within range and stones are connected
			step_y--; // Go Left
			count++; //  Increase count
		}
		return count; // Return number of connected stones horizontally
	}
	
	public int Check_left_diagonal() { // Check left_diagonally connected stones
		int step_x; // variable stores num_x
		int step_y; // variable stores num_y number of connected stones
		int count = 1; // variable stores
		
		step_x = x-1; // store num_x-1 (it means go Up to check number of connected stones)
		step_y = y-1; // store num_y-1 (it means g Left to check number of connected stones)
		while(0 <= step_x && step_x <= 18 && 0 <= step_y && step_y <= 18 && board[step_x][step_y] == stone) { // if location is within range and stones are connected
			step_x--; // Go Up
			step_y--; // Go Left
			count++; //  Increase count
		}
		
		step_x = x+1;// store num_x-1 (it means go Down to check number of connected stones)
		step_y = y+1;// store num_y-1 (it means g Right to check number of connected stones)
		while(0 <= step_x && step_x <= 18 && 0 <= step_y && step_y <= 18 && board[step_x][step_y] == stone) { // if location is within range and stones are connected
			step_x++; // Go Down
			step_y++; // Go Right
			count++; // Increase count
		}
		return count; // Return number of connected stones
	}
	
	public int Check_right_diagonal() { // Check right diagonally connected stones
		int step_x; // variable stores num_x
		int step_y; // variable stores num_y
		int count = 1; // variable stores number of connected stones
		
		step_x = x-1; // store num_x-1 (it means Go Up to check number of connected stones)
		step_y = y+1; // store num_y+1 (it means Go Right to check number of connected stones)
		while(0 <= step_x && step_x <= 18 && 0 <= step_y && step_y <= 18 && board[step_x][step_y] == stone) { // if location is within range and stones are connected
			step_x--; // Go Up
			step_y++; // Go Right
			count++; // Increase count
		}
		
		step_x = x+1; // store num_x+1 (it means Go Down to check number of connected stones)
		step_y = y-1; // store num_y-1 (it means Go Left to check number of connected stones)
		while(0 <= step_x && step_x <= 18 && 0 <= step_y && step_y <= 18 && board[step_x][step_y] == stone) { // if location is within range and stones are connected
			step_x++; // Go Down
			step_y--; // Go Left
			count++; // Increase count
		}
		return count; // Return number of connected stones
	}
	
	public void Print_board() { // Print board
		int i, j; // variables for loops
		char alphabet = 'A'; // variable to indicate Location of Rows and Columns
		System.out.println("  A B C D E F G H I J K L M N O P Q R S"); // Print Columns Location
		for(i = 0; i < 19; i++) {
			System.out.print(alphabet+" "); // Print Rows Location
			for(j = 0; j < 19; j++) { // Print Board
				System.out.print(board[i][j]+" "); 
			}
			System.out.println("");
			alphabet++; // store next Row Location( if) A -> B , B -> C, G -> H )
		}
	}
}
