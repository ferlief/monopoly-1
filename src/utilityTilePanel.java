import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import java.awt.*;

public class utilityTilePanel extends tilePanel
{
	ImageIcon utilityIcon;
	
	utilityTilePanel(int price, String name, Color tileColor)
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
		
		// Select proper picture.
		if (name.contains("Railroad") || name.contains("Short"))
			utilityIcon = new ImageIcon(getClass().getResource("railroad.png"));
		else if (name.contains("Water"))
			utilityIcon = new ImageIcon(getClass().getResource("electric.png"));
		else if (name.contains("Electric"))
			utilityIcon = new ImageIcon(getClass().getResource("water.png"));
		JPanel utilityPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
				((FlowLayout)utilityPanel.getLayout()).setVgap(0);
				((FlowLayout)utilityPanel.getLayout()).setHgap(0);
		JLabel utilityLabel = new JLabel(utilityIcon);
			utilityPanel.add(utilityLabel);
		
		// Displays property price.
		String priceText = "PRICE: $" + String.valueOf(price);
		JTextPane pricePane = new JTextPane();
			pricePane.setPreferredSize(new Dimension(100,15));
			pricePane.setMargin(new Insets(0,0,0,0));
			pricePane.setText(priceText);
			pricePane.setFont(new Font("Verdana", Font.BOLD, 12));
			pricePane.setEditable(false);
		// Centering code
		doc = pricePane.getStyledDocument();
		centerText = new SimpleAttributeSet();
		StyleConstants.setAlignment(centerText, StyleConstants.ALIGN_CENTER);
		doc.setParagraphAttributes(0, doc.getLength(), centerText, false);

		// Add pieces to main panel.
		add(namePane);
		add(utilityPanel);
		add(playerPieces);
		add(pricePane);
	}
}
