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
    private int ID;
    private String name = "Test " + ID;
    private int location;
    
    Player()
    {
        location = 0;
        //System.out.println("Type in the piece you want to be (Car, Battleship, Dog, Shoe, etc...");
        Scanner in = new Scanner(System.in);
        //name = in.next();
        System.out.println(name);
    }
    
  /*  public void setName(String inName)
    {
        name = inName;
    }*/
    
    public void setID(int inID)
    {
        ID = inID;
    }
    
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
