import java.awt.CardLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class CardLayout1 extends JFrame {				// add start panel and game
									// panel to CardLayout
	
	
	private JButton start;
	private JButton exit;
	private CardLayout cardLayout = new CardLayout();
	private JPanel card, buttonPanel;
	private TimeTest time;
	
	public CardLayout1 (){
		
		setTitle("Rabbit Game");
		setSize(800, 800);
		setLocationRelativeTo(null);
		
		Image title = ResourceLoader.getImage("title.png");
		ImageIcon icon = new ImageIcon(title);
		
		
		card = new JPanel();
		card.setLayout(cardLayout);
			
		panel gameCard = new panel();
		JPanel frontScreen = new panel();
		
		start = new JButton(icon);
		start.addActionListener(new ActionListener(){			// cause button to change card/panel
			
			public void  actionPerformed(ActionEvent e){
				cardLayout.show(card, "2");
			}
		});
		
		
		frontScreen.add(start);
		
		card.add(frontScreen, "1");
		
		card.add(gameCard, "2");
	
		
		add(card);
		
	}

	public static void main(String[] args) {  				// open and run file
		
		CardLayout1 frame = new CardLayout1();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	
	}


}
