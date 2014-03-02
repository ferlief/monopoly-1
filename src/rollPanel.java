import javax.swing.*;
import javax.swing.text.*;

import java.awt.*;

public class rollPanel extends tilePanel
{
	String name;
	int money;
	
	public rollPanel()
	{
		// tilePanel settings
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(BorderFactory.createLineBorder(Color.black, 1));
		setPreferredSize(new Dimension(100,130));
//		
//		// Displays Info
//		JTextPane namePane = new JTextPane();
//			namePane.setPreferredSize(new Dimension(100,40));
//			namePane.setMargin(new Insets(0,0,0,0));
//			namePane.setEditable(false);
//			namePane.setFont(new Font("Verdana", Font.BOLD, 12));
//			namePane.setText(name);
//		// Centering code
//		StyledDocument doc = namePane.getStyledDocument();
//		SimpleAttributeSet centerText = new SimpleAttributeSet();
//		StyleConstants.setAlignment(centerText, StyleConstants.ALIGN_CENTER);
//		doc.setParagraphAttributes(0, doc.getLength(), centerText, false);
//		
//		// Displays money.
//		JTextPane moneyPane = new JTextPane();
//			moneyPane.setPreferredSize(new Dimension(100,40));
//			moneyPane.setMargin(new Insets(0,0,0,0));
//			moneyPane.setEditable(false);
//			moneyPane.setFont(new Font("Verdana", Font.BOLD, 12));
//			moneyPane.setText(String.valueOf(money));
//		// Centering code
//		doc = moneyPane.getStyledDocument();
//		StyleConstants.setAlignment(centerText, StyleConstants.ALIGN_CENTER);
//		doc.setParagraphAttributes(0, doc.getLength(), centerText, false);
//
//		// Add pieces to main panel.
//		add(namePane);
//		add(moneyPane);
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
