import javax.swing.*;
import javax.swing.text.*;

import java.awt.*;

public class boardPanel extends JPanel
{
	// Creates a panel which holds all the tilePanels.
	boardPanel(Tile[] tileArray)
	{
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT,0,0));
			topPanel.setPreferredSize(new Dimension(0,130));
			topPanel.add(tileArray[20].getTilePanel());
			topPanel.add(tileArray[21].getTilePanel());
			topPanel.add(tileArray[22].getTilePanel());
			topPanel.add(tileArray[23].getTilePanel());
			topPanel.add(tileArray[24].getTilePanel());
			topPanel.add(tileArray[25].getTilePanel());
			topPanel.add(tileArray[26].getTilePanel());
			topPanel.add(tileArray[27].getTilePanel());
			topPanel.add(tileArray[28].getTilePanel());
			topPanel.add(tileArray[29].getTilePanel());
			topPanel.add(tileArray[30].getTilePanel());
			
		JPanel center = new JPanel(new FlowLayout(FlowLayout.LEFT,0,0));
			JPanel leftPanel = new JPanel(new GridLayout(0,1));
				leftPanel.add(tileArray[19].getTilePanel());
				leftPanel.add(tileArray[18].getTilePanel());
				leftPanel.add(tileArray[17].getTilePanel());
				leftPanel.add(tileArray[16].getTilePanel());
				leftPanel.add(tileArray[15].getTilePanel());
				leftPanel.add(tileArray[14].getTilePanel());
				leftPanel.add(tileArray[13].getTilePanel());
				leftPanel.add(tileArray[12].getTilePanel());
				leftPanel.add(tileArray[11].getTilePanel());
			JPanel middlePanel = new JPanel();
				middlePanel.setLayout(new BoxLayout(middlePanel, BoxLayout.Y_AXIS));
				middlePanel.setBorder(BorderFactory.createLineBorder(Color.black, 1));
			// Temporary stuff to have centered monopoly text
			// this will change later to add in stuff like an icon for
			// community chest/chance cards
			JTextPane logo = new JTextPane();
			logo.setEditable(false);
			JLabel logoText = new JLabel("Monopoly");
			logoText.setFont(new Font("Verdana", Font.BOLD, 72));
				logo.setPreferredSize(new Dimension(898, 1168));
				logo.insertComponent(logoText);
				StyledDocument doc = logo.getStyledDocument();
				SimpleAttributeSet centerText = new SimpleAttributeSet();
				StyleConstants.setAlignment(centerText, StyleConstants.ALIGN_CENTER);
				try {
					doc.insertString(0, "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n" +
										"\n\n\n\n\n", centerText);
				} catch (BadLocationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				doc.setParagraphAttributes(0, doc.getLength(), centerText, false);	
							
				middlePanel.add(logo);
			JPanel rightPanel = new JPanel(new GridLayout(0,1));
				rightPanel.add(tileArray[31].getTilePanel());
				rightPanel.add(tileArray[32].getTilePanel());
				rightPanel.add(tileArray[33].getTilePanel());
				rightPanel.add(tileArray[34].getTilePanel());
				rightPanel.add(tileArray[35].getTilePanel());
				rightPanel.add(tileArray[36].getTilePanel());
				rightPanel.add(tileArray[37].getTilePanel());
				rightPanel.add(tileArray[38].getTilePanel());
				rightPanel.add(tileArray[39].getTilePanel());
			center.add(leftPanel);
			center.add(middlePanel);
			center.add(rightPanel);
		
		JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.LEFT,0,0));
			bottomPanel.add(tileArray[10].getTilePanel());
			bottomPanel.add(tileArray[9].getTilePanel());
			bottomPanel.add(tileArray[8].getTilePanel());
			bottomPanel.add(tileArray[7].getTilePanel());
			bottomPanel.add(tileArray[6].getTilePanel());
			bottomPanel.add(tileArray[5].getTilePanel());
			bottomPanel.add(tileArray[4].getTilePanel());
			bottomPanel.add(tileArray[3].getTilePanel());
			bottomPanel.add(tileArray[2].getTilePanel());
			bottomPanel.add(tileArray[1].getTilePanel());
			bottomPanel.add(tileArray[0].getTilePanel());
			
		add(topPanel);
		add(center);
		add(bottomPanel);
	}
}
