/****************************************************
 * Team: Prestige Worldwide                         *
 * Professor: Lonnie Bowe                           *
 * Date: 21 February 2014                           *
 * Description: Simple class that simulates the     *
 *   rolling of two dice simultaneously.            *
 *                                                  *
 ****************************************************/

import java.util.Random;

public class Dice 
{
    private static int die1;
    private static int die2;
    private static int sum;
    private final static Random rand1 = new Random();
    private final static Random rand2 = new Random();
    
    //Rolls the dice and returns the total
    public static void Roll()
    {
        die1 = rand1.nextInt(6) + 1;
        die2 = rand2.nextInt(6) + 1;
        sum = die1 + die2;
    }
    
    public static int getSum()
    {
        return sum;
    }
    
    //Returns true if the dice rolled are equal
    //Could be useful for implementing the "3 doubles go to jail" rule
    public static boolean CheckIfEqual()
    {
        if (die1 == die2)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}