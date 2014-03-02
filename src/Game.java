import java.awt.Dimension;
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
	int diceTemp;
	boolean endGame = false;
	boolean turnEnd = false;
	rollPanel rollPanel = new rollPanel();
	JDialog rollWindow = new JDialog();

	Game()
	{
		gameBoard = new Board();
		
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
				diceTemp = dice.roll();
				createRollPanel(playerArray[i]);
				while (turnEnd == false)
					try 
					{
						Thread.currentThread().sleep(1000);
					} 
					catch (InterruptedException e) 
					{
					}
				
				turn(playerArray[i], diceTemp);	            
            }
		}
	}
	
	public void turn(Player player, int diceTemp)
	{
		//If the player isn't in jail, he can roll the dice and move
        if(player.inJail == false)
        {
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
                move(player, dice.getSum(), gameBoard);
            }
            //He tries to roll doubles to get out of jail.
            else
            {
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
    
    public void createRollPanel(Player player)
    {
    	rollPanel.removeAll();
    	rollPanel.revalidate();
    	rollPanel.repaint();
		//initialize JFrame
		rollWindow.setTitle("Roll");
		rollWindow.setSize(new Dimension(150, 100));
		rollWindow.setResizable(false);
		rollWindow.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		rollWindow.setLocationRelativeTo(null);
		rollWindow.setVisible(true);  	
		rollWindow.setAlwaysOnTop(true);
		
		// Display player name.
		JLabel playerName = new JLabel("Player: " + player.name);
		
		// Display player money.
		JLabel playerMoney = new JLabel("Current Cash: $" + String.valueOf(player.getMoney()));
		
		// Display what the player rolled.
		JLabel diceDisplay = new JLabel("You rolled: " + String.valueOf(diceTemp));
		
		// Add roll button.
    	RollHandler rollAction = new RollHandler();
    	JButton rollButton = new JButton("End Turn");
    	rollButton.addActionListener(rollAction);
    	rollPanel.add(playerName);
    	rollPanel.add(playerMoney);
    	rollPanel.add(diceDisplay);
    	rollPanel.add(rollButton);
    	rollWindow.add(rollPanel);

		//int result = JOptionPane.showConfirmDialog(null, rollPanel, message, JOptionPane.PLAIN_MESSAGE);
   
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
