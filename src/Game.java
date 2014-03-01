import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.*;


public class Game 
{
	Player playerArray[] = new Player[4];
	Board gameBoard;
	String message;
	Dice dice = new Dice();
	int spacesToMove;
	boolean endGame = false;
	boolean turnEnd = false;
	rollPanel rollPanel = new rollPanel();

	Game()
	{
		gameBoard = new Board();
		createRollPanel();
		
		for (int i = 0; i < 4; i++)
		{
			playerArray[i] = new Player(i+1);	
		}
	}
	
	public void run() throws IOException
	{
		gameBoard.tileArray[0].getTilePanel().playerPieces.revealPiece(1);
		gameBoard.tileArray[0].getTilePanel().playerPieces.revealPiece(2);
		gameBoard.tileArray[0].getTilePanel().playerPieces.revealPiece(3);
		gameBoard.tileArray[0].getTilePanel().playerPieces.revealPiece(4);
		while (endGame == false)
		{
			for (int i = 0; i < 4; i++)
			{
				turnEnd = false;
						
				// Update info/roll panel with player info; pause until roll button is pressed.
				updateRollPanel(playerArray[i]);
				while (turnEnd == false)
					try {
						Thread.currentThread().sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
				turn(playerArray[i]);	            
            }
		}
	}
	
	public void turn(Player player)
	{
		//If the player isn't in jail, he can roll the dice and move
        if(player.inJail == false)
        {
            dice.Roll();
            //If they rolled 3 doubles in a row, they go to jail
            if (player.doublesInARow == 3)
            {
                player.location = 10;
                player.inJail = true;
                player.doublesInARow = 0;
            }
            else
            {
                if (dice.CheckIfEqual() == true)
                {
                    player.doublesInARow = player.doublesInARow + 1;
                }
                move(player, dice.getSum(), gameBoard);
            }
        }
        //If he's in jail, he rolls three times until he gets a double
        else
        {
            //If he's already tried three times, he pays and rolls like normal
            if (player.jailRollCounter == 3)
            {
            	player.money = player.money - 50;
            	player.inJail = false;
                dice.Roll();
                move(player, dice.getSum(), gameBoard);
            }
            //He tries to roll doubles to get out of jail.
            else
            {
                dice.Roll();
                player.jailRollCounter = player.jailRollCounter + 1;
                //If a double is rolled, he is out of jail and moves the amount of spaces
                if (dice.CheckIfEqual() == true)
                {
                	player.inJail = false;
                    move(player, dice.getSum(), gameBoard);
                }
                //If a double isn't rolled, nothing happens
            }
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
    
    public void updateRollPanel(Player player)
    {
    	rollPanel.setMoney(player.money);
    	rollPanel.setName(player.name);
    	rollPanel.revalidate();
    }
    
    public void createRollPanel()
    {
    	RollHandler rollAction = new RollHandler();
    	
    	JButton rollButton = new JButton("Roll the Dice.");
    	rollButton.addActionListener(rollAction);
    	
    	// Add roll button.
    	rollPanel.add(rollButton);
		message = "You rolled " + message;
		//JOptionPane.showMessageDialog(gameBoard.getBoardPanel(), message, "Roll", JOptionPane.PLAIN_MESSAGE);
		int result = JOptionPane.showConfirmDialog(null, rollPanel, "Test,", JOptionPane.PLAIN_MESSAGE);
   
    }
    
    public class RollHandler implements ActionListener
    {
    	
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			turnEnd = true;
		}
    	
    }
}
