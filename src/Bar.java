import javax.swing.*;

import java.awt.*;


public class Bar extends JPanel
{
	private Color barColor;
	
	public void paint(Graphics g)
	{
		super.paintComponent(g);
		setBorder(BorderFactory.createLineBorder(Color.black, 1));
		g.drawRect(0, 0, 100, 20);
		g.setColor(barColor);
		g.fillRect(0,0,100,20);
	}
	
	Bar(Color color)
	{
		barColor = color;
	}
}
