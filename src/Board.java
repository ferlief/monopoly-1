import javax.swing.*;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

public class Board extends JDialog
{
	Color purple = new Color(133,6,191);
	Color lightBlue = new Color(91,152,255);
	Color navy  = new Color(39,6,184);
	public boardPanel basic;
	Tile[] tileArray = new Tile[40];
	
	Board()
	{
		initializeTiles();
		basic = new boardPanel(tileArray);
		JScrollPane scroll = new JScrollPane(basic);
		add(scroll);
		
		//initialize JFrame
		setTitle("Monopoly");
		setSize(new Dimension(1170, 700));
		setResizable(false);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public void initializeTiles()
	{
		tileArray[0] = new Tile(0, "GO!", Color.white, 1);
		tileArray[1] = new Tile(60, "Mediterranean\nAvenue", navy, 0);
		tileArray[2] = new Tile(0, "Community\nChest", Color.white, 3);
		tileArray[3] = new Tile(60, "Baltic\nAvenue", navy, 0);
		tileArray[4] = new Tile(0, "Income\nTax", Color.white, 3);
		tileArray[5] = new Tile(200, "Reading\nRailroad", Color.white, 2);
		tileArray[6] = new Tile(100, "Oriental\nAvenue", lightBlue, 0);
		tileArray[7] = new Tile(0, "Chance", Color.white, 3);
		tileArray[8] = new Tile(100, "Vermont\nAvenue", lightBlue, 0);
		tileArray[9] = new Tile(120, "Connecticut\nAvenue", lightBlue, 0);
		tileArray[10] = new Tile(0, "In Jail", Color.white, 1);
		tileArray[11] = new Tile(140, "St. Charles\nPlace", purple, 0);
		tileArray[12] = new Tile(150, "Electric\nCompany", Color.white, 2);
		tileArray[13] = new Tile(140, "States\nAvenue", purple, 0);
		tileArray[14] = new Tile(160, "Virginia\nAvenue", purple, 0);
		tileArray[15] = new Tile(200, "Pennsylvania\nRailroad", Color.white, 2);
		tileArray[16] = new Tile(180, "St. James\nPlace", Color.orange, 0);
		tileArray[17] = new Tile(0, "Community\nChest", Color.white, 3);
		tileArray[18] = new Tile(180, "Tennessee\nAvenue", Color.orange, 0);
		tileArray[19] = new Tile(200, "New York\nAvenue", Color.orange, 0);
		tileArray[20] = new Tile(0, "Free\nParking", Color.white, 1);
		tileArray[21] = new Tile(220, "Kentucky\nAvenue", Color.red, 0);
		tileArray[22] = new Tile(0, "Chance", Color.white, 3);
		tileArray[23] = new Tile(220, "Indiana\nAvenue", Color.red, 0);
		tileArray[24] = new Tile(240, "Illinois\nAvenue", Color.red, 0);
		tileArray[25] = new Tile(200, "B. & O.\nRailroad", Color.white, 2);
		tileArray[26] = new Tile(260, "Atlantic\nAvenue", Color.yellow, 0);
		tileArray[27] = new Tile(260, "Ventnor\nAvenue", Color.yellow, 0);
		tileArray[28] = new Tile(150, "Water\nWorks", Color.white, 2);
		tileArray[29] = new Tile(280, "Marvin\nGardens", Color.yellow, 0);
		tileArray[30] = new Tile(0, "Go To Jail", Color.white, 1);
		tileArray[31] = new Tile(300, "Pacific\nAvenue", Color.green, 0);
		tileArray[32] = new Tile(300, "North Carolina\nAvenue", Color.green, 0);
		tileArray[33] = new Tile(0, "Community\nChest", Color.white, 3);
		tileArray[34] = new Tile(320, "Pennsylvania\nAvenue", Color.green, 0);
		tileArray[35] = new Tile(200, "Short\nLine", Color.white, 2);
		tileArray[36] = new Tile(0, "Chance", Color.white, 3);
		tileArray[37] = new Tile(350, "Park\nPlace", Color.blue, 0);
		tileArray[38] = new Tile(0, "Luxury\nTax", Color.white, 3);
		tileArray[39] = new Tile(400, "Boardwalk", Color.blue, 0);		
	}
	
	public boardPanel getBoardPanel()
	{
		return basic;
	}
}
