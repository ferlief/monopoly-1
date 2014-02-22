import java.awt.*;
import javax.swing.*;

public class Tile 
{
	int price;
	String name;
	Color tileColor;
	public tilePanel basic;
	
	Tile(int priceIn, String nameIn, Color colorIn, int type)
	{
		price = priceIn;
		name = nameIn;
		tileColor = colorIn;
		if (type == 1)
			basic = new bigTilePanel(price, name, tileColor);
		else if (type == 2)
			basic = new utilityTilePanel(price, name, tileColor);
		else if(type == 3)
			basic = new specialTilePanel(price, name, tileColor);
		else
			basic = new tilePanel(price, name, tileColor); 
	}
	
	public tilePanel getTilePanel()
	{
		return basic;
	}
	
	public void refresh()
	{
		
	}
}
