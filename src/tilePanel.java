import javax.swing.*;
import javax.swing.text.*;

import java.awt.*;

public class tilePanel extends JPanel
{
	private JTextArea nameText;
	private JTextArea priceText;
	pieceHolder playerPieces = new pieceHolder();
	houseHolder playerHouses = new houseHolder();
	
	tilePanel()
	{
		playerPieces = new pieceHolder();
	}
	
	tilePanel(int price, String name, Color tileColor)
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
		add(new Bar(tileColor));
		add(namePane);
		add(playerPieces);
		add(playerHouses);
		add(pricePane);
	}
}
