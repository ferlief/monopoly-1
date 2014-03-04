import java.awt.*;

public class Tile 
{
	int price;
	String name;
	Color tileColor;
	private tilePanel basic;
	
	Tile(int priceIn, String nameIn, Color colorIn, int type)
	{
		price = priceIn;
		name = nameIn;
		tileColor = colorIn;
		// Add a specific tilePanel based on the Tile's type.
		// 0 = normal
		// 1 = big tile
		// 2 = utility tile
		// 3 = special tile
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
}
