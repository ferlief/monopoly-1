import java.io.IOException;


public class Game 
{
	Player player1;
	Player player2;
	Player player3;
	Player player4;
	Board gameBoard;
	Dice dice = new Dice();
	int spacesToMove;
	boolean endGame = false;

	Game()
	{
		gameBoard = new Board();
		player1 = new Player();
		player1.setID(1);
		//player2 = new Player();
		//player2.setID(2);
		//player3 = new Player();
		//player3.setID(3);
		//player4 = new Player();
		//player4.setID(4);
	}
	
	public void run() throws IOException
	{
		while (endGame == false)
		{
			move(player1, dice.Roll(), gameBoard);
			//move(player2);
			//move(player3);
			//move(player4);
		}
	}
	
	// hides piece from current location, moves, then displays piece in new position
    public void move(Player player, int inSpaces, Board gameBoard)  
    {
    	// Hide old Piece
    	int location = player.getLocation();
    	gameBoard.tileArray[location].basic.playerPieces.hidePiece(player.getID());
    	
    	// Get new location, set player value, show on board
    	location = (location + inSpaces) % 39;
    	player.setLocation(location);
        gameBoard.tileArray[location].basic.playerPieces.revealPiece(player.getID());
    }
}
