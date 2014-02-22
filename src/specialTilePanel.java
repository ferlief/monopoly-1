import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import java.awt.*;

public class specialTilePanel extends tilePanel
{
	ImageIcon specialIcon;
	String description = "";
	pieceHolder playerPieces = new pieceHolder();
	
	specialTilePanel(int price, String name, Color tileColor)
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
		if (name.contains("Chance"))
		{
			specialIcon = new ImageIcon(getClass().getResource("chance_blue.png"));
			description = "";
		}
		else if (name.contains("Chest"))
		{
			specialIcon = new ImageIcon(getClass().getResource("chest.png"));
			//description = "FOLLOW\nINSTRUCTIONS\nON TOP CARD";
		}
		else if (name.contains("Luxury"))
		{	
			specialIcon = new ImageIcon(getClass().getResource("luxury.png"));
			description = "PAY $75.00";
		}
		else if (name.contains("Income"))
		{
			specialIcon = new ImageIcon(getClass().getResource("income.png"));
			//description = "PAY 10%\nOR\nPAY $200";
		}
		JPanel specialPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
				((FlowLayout)specialPanel.getLayout()).setVgap(0);
				((FlowLayout)specialPanel.getLayout()).setHgap(0);
		JLabel specialLabel = new JLabel(specialIcon);
			specialPanel.add(specialLabel);
		
		// Displays Description
		JTextPane descriptionPane = new JTextPane();
			descriptionPane.setPreferredSize(new Dimension(100,15));
			descriptionPane.setMargin(new Insets(0,0,0,0));
			descriptionPane.setText(description);
			descriptionPane.setFont(new Font("Verdana", Font.BOLD, 12));
			descriptionPane.setEditable(false);
		// Centering code
		doc = descriptionPane.getStyledDocument();
		centerText = new SimpleAttributeSet();
		StyleConstants.setAlignment(centerText, StyleConstants.ALIGN_CENTER);
		doc.setParagraphAttributes(0, doc.getLength(), centerText, false);
			
		// Add pieces to main panel.
		add(namePane);
		add(specialPanel);
		add(playerPieces);
		add(descriptionPane);
	}
}
