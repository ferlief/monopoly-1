import javax.swing.*;
import javax.swing.text.*;

import java.awt.*;

public class bigTilePanel extends tilePanel
{
	ImageIcon bigIcon;
	String description = "";
	
	pieceHolder playerPieces = new pieceHolder();
	bigTilePanel(int price, String name, Color tileColor)
	{
		// tilePanel settings
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(BorderFactory.createLineBorder(Color.black, 1));
		setPreferredSize(new Dimension(100,130));
		
		// Displays property name.
		JTextPane namePane = new JTextPane();
			namePane.setPreferredSize(new Dimension(100,40));
			namePane.setMargin(new Insets(0,0,0,0));
			namePane.setEditable(false);
			namePane.setFont(new Font("Verdana", Font.BOLD, 12));
			namePane.setText(name);
		// Centering code
		StyledDocument doc = namePane.getStyledDocument();
		SimpleAttributeSet centerText = new SimpleAttributeSet();
		StyleConstants.setAlignment(centerText, StyleConstants.ALIGN_CENTER);
		doc.setParagraphAttributes(0, doc.getLength(), centerText, false);
		
		// Select proper picture and description.
		if (name.contains("GO"))
		{
			bigIcon = new ImageIcon(getClass().getResource("go.png"));
			description = "Collect\n$300 Salary\nas you Pass";
		}
		else if (name.contains("In Jail"))
		{
			bigIcon = new ImageIcon(getClass().getResource("inJail.png"));
			//description = "";
		}
		else if (name.contains("Go To Jail"))
		{	
			bigIcon = new ImageIcon(getClass().getResource("goJail.png"));
			//description = "";
		}
		else if (name.contains("Parking"))
		{
			bigIcon = new ImageIcon(getClass().getResource("parking.png"));
			//description = "";
		}
		JPanel bigPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
				((FlowLayout)bigPanel.getLayout()).setVgap(0);
				((FlowLayout)bigPanel.getLayout()).setHgap(0);
		JLabel bigLabel = new JLabel(bigIcon);
			bigPanel.add(bigLabel);

		// Add pieces to main panel.
		add(namePane);
		add(bigPanel);
		add(playerPieces);
		//add description
	}
}
