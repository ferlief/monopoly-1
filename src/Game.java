import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.*;


public class Game 
{
	final int PLAYER_COUNT = 4;
	
	Player playerArray[] = new Player[PLAYER_COUNT];
	Board gameBoard;
	String message1 = "";
	String message2 = "";
	Dice dice = new Dice();
	int spacesToMove;
	int diceTemp;
	boolean endGame = false;
	boolean turnEnd = false;
	rollPanel rollPanel = new rollPanel();
	JDialog rollWindow = new JDialog();
	
	// Start a new game with PLAYER_COUNT players.
	Game()
	{
		gameBoard = new Board();
		
		for (int i = 0; i < PLAYER_COUNT; i++)
		{
			playerArray[i] = new Player(i+1);	
		}
	}
	
	// Process turns for 4 players and end game when necessary.
	public void run() throws IOException
	{
		gameBoard.getTileArray()[0].getTilePanel().getPlayerPieces().revealPiece(1);
		gameBoard.getTileArray()[0].getTilePanel().getPlayerPieces().revealPiece(2);
		gameBoard.getTileArray()[0].getTilePanel().getPlayerPieces().revealPiece(3);
		gameBoard.getTileArray()[0].getTilePanel().getPlayerPieces().revealPiece(4);
    	
		while (endGame == false)
		{
			for (int i = 0; i < 4; i++)
			{
				turnEnd = false;
						
				// Roll dice; process turn information; 
				// move player; pause until 'end turn' button is pressed.
				diceTemp = dice.roll();
				turn(playerArray[i]);
				move(playerArray[i]);
				createRollPanel(playerArray[i]);
				while (turnEnd == false)
				{
					try 	{Thread.currentThread();
					Thread.sleep(1000);} 
					catch 	(InterruptedException e){}
				}
            }
		}
	}
	
	// Processes special conditions that may occur during a player's turn:
	// Player in jail and rolling triple-doubles.
	public void turn(Player player)
	{
		// If the player isn't in jail, he can roll the dice and move
        if(player.inJail == false)
        {
            //If they rolled 3 doubles in a row, they go to jail
            if (player.doublesInARow == 3)
            {
                player.location = 10;
                player.inJail = true;
                player.doublesInARow = 0;
                diceTemp = 0;
            }
            else
            {
                if (dice.CheckIfEqual() == true)
                {
                    player.doublesInARow = player.doublesInARow + 1;
                }
                
            }
        }
        // If he's in jail, he rolls three times until he gets a double
        else
        {
            // If he's already tried three times, he pays and rolls like normal
            if (player.jailRollCounter == 3)
            {
            	if (player.money >= 50)
            	{
            		player.money = player.money - 50;
            		player.inJail = false;
            		player.jailRollCounter = 0;
            		message1 = "You pay $50 and are";
            		message2 = "released from Jail";
            	}
            	else
            	{
            		message1 = "You don't have enough";
            		message2 = "money to get out of jail";
            		diceTemp = 0;
            	}	
            	
            }
            // He tries to roll doubles to get out of jail.
            else
            {
                player.jailRollCounter = player.jailRollCounter + 1;
                
                //If a double is rolled, he is out of jail and moves the amount of spaces
                if (dice.CheckIfEqual() == true)
                {
                	player.inJail = false;
                	message1 = "You are released from Jail!";
                }
                // If a double isn't rolled, nothing happens
                else
                {
                	message1 = "You remain in jail.";
                	diceTemp = 0;	
                }
            }
        }
	}
	
	// Handles player movement; updates Player object location;
	// Updates board to reflect player's new position;
	// Takes appropriate action when a player lands on specials spaces
	// such as income tax or go to jail.
    public void move(Player player)  
    {
    	// Hide old Piece
    	int location = player.getLocation();
    	gameBoard.getTileArray()[location].getTilePanel().getPlayerPieces().hidePiece(player.getID());
    	
    	// Get new location
        int oldLoc = location;
    	location = (location + diceTemp) % 39;
    	
    	// Catch special cases
	    	// Pass Go, get $200
	        if ((oldLoc > 25) && (location < 20))
	        {
	        	message1 = "You sucessfully passed Go!";
	        	message2 = "You have collected $200";
	            player.money = player.money + 200;
	        }
	        // Go to jail
	        else if (location == 30)
	        {
	        	message1 = "Go DIRECTLY to Jail";
	        	message2 = "Do not pass Go! Do not collect $200.";
	            location = 10;
	            player.inJail = true;
	        }
	        // Income taxes
	        else if(location == 4)
	        {
	        	int percentage = player.getMoney() / 10;
	        	if(percentage <= 200)
	        	{
	        		player.deductMoney(percentage);
	        		message1 = "You pay 10% ($" + percentage + ")";
	        		message2 = "of your money in income taxes";
	        	}
	        	else
	        	{
	        		player.deductMoney(200);
	        		message1 = "You pay $200 in Income Taxes.";
	        	}
	        }
	        // Luxury Tax
	        else if(location == 38)
	        {
	        	player.deductMoney(75);
	        	message1 = "You have paid $75 in Luxury Taxes.";
	        }
	        // Else for Properties
	        else
	        {
	        	// Insert standard price display things etc for properties.
	        }
	        
	    // Place icons in new locations.    
	    player.setLocation(location);
	    gameBoard.getTileArray()[location].getTilePanel().getPlayerPieces().revealPiece(player.getID());
    }
    
    public void createRollPanel(Player player)
    {
    	// Remove old data.
    	rollPanel.removeAll();
    	rollPanel.revalidate();
    	rollPanel.repaint();
    	
		//initialize JFrame
		rollWindow.setTitle("Roll");
		rollWindow.setSize(new Dimension(220, 200));
		rollWindow.setResizable(false);
		rollWindow.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		rollWindow.setLocationRelativeTo(null);
		rollWindow.setVisible(true);  	
		rollWindow.setAlwaysOnTop(true);
		
		// Display any messages.
		JLabel messageLabel1 = new JLabel(message1);
			messageLabel1.setHorizontalAlignment(JLabel.CENTER);
		JLabel messageLabel2 = new JLabel(message2);
			messageLabel2.setHorizontalAlignment(JLabel.CENTER);
		
		// Display player name.
		JLabel playerName = new JLabel("Player: " + player.name);
			playerName.setHorizontalAlignment(JLabel.CENTER);
		
		// Display player money.
		JLabel playerMoney = new JLabel("Current Cash: $" + String.valueOf(player.getMoney()));
			playerMoney.setHorizontalAlignment(JLabel.CENTER);
		
		// Display what the player rolled.
		JLabel diceDisplay = new JLabel("You rolled: " + String.valueOf(diceTemp));
			diceDisplay.setHorizontalAlignment(JLabel.CENTER);
		
		// Add roll button.
    	RollHandler rollAction = new RollHandler();
    	JButton rollButton = new JButton("End Turn");
    	rollButton.addActionListener(rollAction);
    	if (message1 != "")
    		rollPanel.add(messageLabel1);
    	if (message2 != "")
    		rollPanel.add(messageLabel2);
    	
    	rollPanel.add(playerName);
    	rollPanel.add(playerMoney);
    	rollPanel.add(diceDisplay);
    	rollPanel.add(rollButton);
    	rollWindow.add(rollPanel);
    	message1 = "";
    	message2 = "";
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
