import javax.swing.*;

import java.awt.*;

public class pieceHolder extends JPanel
{
	/**
	 * Displays icons that represent player's pieces (hat, dog, etc);
	 */
	private static final long serialVersionUID = 1L;
	ImageIcon hatIcon = new ImageIcon(getClass().getResource("hat.png"));
	JLabel hatLabel = new JLabel(hatIcon);
	ImageIcon carIcon = new ImageIcon(getClass().getResource("car.png"));
	JLabel carLabel = new JLabel(carIcon);
	ImageIcon dogIcon = new ImageIcon(getClass().getResource("dog.png"));
	JLabel dogLabel = new JLabel(dogIcon);
	ImageIcon shipIcon = new ImageIcon(getClass().getResource("ship.png"));
	JLabel shipLabel = new JLabel(shipIcon);
	
	pieceHolder()
	{
		setBackground(Color.white);
		setPreferredSize(new Dimension(100,25));
		setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
		add(hatLabel);
		add(carLabel);
		add(dogLabel);
		add(shipLabel);
		hatLabel.setVisible(false);
		carLabel.setVisible(false);
		dogLabel.setVisible(false);
		shipLabel.setVisible(false);		
	}
	
	public void revealPiece(int i)
	{
		if (i == 1)
			hatLabel.setVisible(true);
		else if (i == 2)
			carLabel.setVisible(true);
		else if (i == 3)
			dogLabel.setVisible(true);
		else if (i == 4)
			shipLabel.setVisible(true);
		revalidate();
	}
	
	public void hidePiece(int i)
	{
		if (i == 1)
			hatLabel.setVisible(false);
		else if (i == 2)
			carLabel.setVisible(false);
		else if (i == 3)
			dogLabel.setVisible(false);
		else if (i == 4)
			shipLabel.setVisible(false);
		revalidate();
	}
}
