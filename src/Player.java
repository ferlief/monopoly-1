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
    private String name;
    private int ID;
    private int location;
    
    Player()
    {
        location = 0;
        System.out.println("Type in the piece you want to be (Car, Battleship, Dog, Shoe, etc...");
        Scanner in = new Scanner(System.in);
        name = in.next();
        System.out.println(name);
    }
    
    public void move(int inSpaces, Board gameBoard)  //hides piece from current location, moves, then displays piece in new postion
    {
        gameBoard.tileArray[location].basic.playerPieces.hidePiece(ID);
        location = (location + inSpaces)%40;
        gameBoard.tileArray[location].basic.playerPieces.revealPiece(ID);
    }
    
  /*  public void setName(String inName)
    {
        name = inName;
    }*/
    
    public void setID(int inID)
    {
        ID = inID;
    }
}
