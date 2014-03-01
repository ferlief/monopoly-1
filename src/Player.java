/****************************************************
 * Team: Prestige Worldwide                         *
 * Professor: Lonnie Bowe                           *
 * Date: 21 February 2014                           *
 * Description: Class for players for Monopoly. Has *
 *   attributes and function that will be           *
 *   necessary for the game.                        *
 *                                                  *
 ****************************************************/
import java.util.Scanner;

public class Player 
{
    public int ID;
    public String name;
    public int location;
    public int money;
    public boolean inJail;
    public int jailRollCounter;
    public int doublesInARow;
    
    Player(int inID)
    {
    	ID = inID;
    	name = "Test " + ID;
        money = 1500;
        location = 0;
        inJail = false;
        jailRollCounter = 0;
        doublesInARow = 0;
        //System.out.println("Type in the piece you want to be (Car, Battleship, Dog, Shoe, etc...");
        //Scanner in = new Scanner(System.in);
        //name = in.next();
       // System.out.println(name);    
    }
    
  /*  public void setName(String inName)
    {
        name = inName;
    }*/
    
    
    public int getLocation()
    {
    	return location;
    }
    
    public void setLocation(int inLocation)
    {
    	location = inLocation;
    }
    
    public int getID()
    {
    	return ID;
    }
}
