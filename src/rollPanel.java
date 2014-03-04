import javax.swing.*;

import java.awt.*;

public class rollPanel extends tilePanel
{
	String name;
	int money;
	
	public rollPanel()
	{
		// tilePanel settings
		setLayout(new GridLayout(0,1));
		setBorder(BorderFactory.createLineBorder(Color.black, 1));
	}
	
	public void setName(String inName)
	{
		name = inName;
	}
	
	public void setMoney(int inMoney)
	{
		money = inMoney;
	}
}
