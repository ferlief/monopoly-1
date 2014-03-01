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
                    //If the player isn't in jail, he can roll the dice and move
                    if(player1.inJail == false)
                    {
                        dice.Roll();
                        //If they rolled 3 doubles in a row, they go to jail
                        if (player1.doublesInARow == 3)
                        {
                            player1.location = 10;
                            player1.inJail = true;
                            player1.doublesInARow = 0;
                        }
                        else
                        {
                            if (dice.CheckIfEqual() == true)
                            {
                                player1.doublesInARow = player1.doublesInARow + 1;
                            }
                            move(player1, dice.getSum(), gameBoard);
                        }
                    }
                    //If he's in jail, he rolls three times until he gets a double
                    else
                    {
                        //If he's already tried three times, he pays and rolls like normal
                        if (player1.jailRollCounter == 3)
                        {
                            player1.money = player1.money - 50;
                            player1.inJail = false;
                            dice.Roll();
                            move(player1, dice.getSum(), gameBoard);
                        }
                        //He tries to roll doubles to get out of jail.
                        else
                        {
                            dice.Roll();
                            player1.jailRollCounter = player1.jailRollCounter + 1;
                            //If a double is rolled, he is out of jail and moves the amount of spaces
                            if (dice.CheckIfEqual() == true)
                            {
                                player1.inJail = false;
                                move(player1, dice.getSum(), gameBoard);
                            }
                            //If a double isn't rolled, nothing happens
                        }
                        
                    }
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
        int oldLoc;
        oldLoc = location;
    	location = (location + inSpaces) % 39;
    	player.setLocation(location);
        gameBoard.tileArray[location].basic.playerPieces.revealPiece(player.getID());
        
        //Pass Go, get $200
        if ((oldLoc > 25) && (location < 20))
        {
            player.money = player.money + 200;
            //Need to make it display that the player got money for passing go.
        }
        
        //Go to jail
        if (location == 30)
        {
            location = 10;
            player.inJail = true;
        }
    }
}
