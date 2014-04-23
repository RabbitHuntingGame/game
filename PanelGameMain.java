import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;



public class panel extends JPanel {
	
	public JPanel cards;
	public Image currentImage;
	public Image gunRR, gunRC, gunCC, gunLC, gunLL;
	public Image rabbit, rabbitHit;
	public JLabel label;
	public int x, y;
	public int clickedX, clickedY, plusY = 0;
	public int points = 0, level = 0, num = 0, count = 0;
	public int rabbitX = 1000, rabbitY = 0, INCREMENT = 1, plusINCREMENT = 1;
	public Timer timer, timer2, countTimer;
	public boolean bool = false;
	public Graphics g;
	
	
	panel(){					// this is the game screen
	
		setLayout(new BorderLayout());
		setBackground(Color.white);
		
		rabbit = ResourceLoader.getImage("rabbit.jpg");
		rabbitHit = ResourceLoader.getImage("rabbitHit.png");
		gunRR = ResourceLoader.getImage("gunRR.jpg");
		gunRC = ResourceLoader.getImage("gunRC.jpg");
		gunCC = ResourceLoader.getImage("gunCC.jpg");
		gunLC = ResourceLoader.getImage("gunLC.jpg");
		gunLL = ResourceLoader.getImage("gunLL.jpg");
		currentImage = gunCC;
		
		timer = new Timer(5, new MoveRabbit());
		timer2 = new Timer(5, new MovePlus());
		
		ImageIcon gunIcon = new ImageIcon(currentImage);
		ImageIcon rabbitIcon = new ImageIcon(rabbit);
			
		JLabel rabbitLabel = new JLabel(rabbitIcon);
		JLabel gunLabel = new JLabel(gunIcon);
		
		addMouseListener(new ClickTarget());
		addMouseMotionListener(new MouseMovement());
		
		timer.start();
		
	
	}
	
	public void Count(){						// ignore for now
		countTimer = new Timer(1000, new Action());
	}
	
	public void paintComponent(Graphics g){				// painting to panel
		super.paintComponent(g);
		
		
		g.drawString("TARGET HIT: " + points,  10, 660);
		g.drawString("LEVEL: " + level, 690, 660);
		g.drawString("TIMER " + count, 10, 680);
		g.drawImage(rabbit, rabbitX, rabbitY, null);
		
			if (x < 175){
				currentImage = gunRR;
				
			}
			if (x <350 && x >175){
				currentImage = gunLC;
			
			}
			if (x <525 && x >350){
				currentImage = gunCC;
				
			}
			if (x <700 && x >525){
				currentImage = gunRC;
				
			}
			if (x <875 && x >700){
				currentImage = gunLL;
				
			}
			g.drawImage(currentImage, 260, 490, null);
			
			if (clickedX < rabbitX + 130 && clickedX > rabbitX - 5)
				if (clickedY < rabbitY + 130 && clickedY > rabbitY - 5){
					
					timer2.start();
					g.drawImage(rabbitHit, clickedX, clickedY, null);
					
					
				}
			
			repaint();
			
			}
	
	private class Action implements ActionListener{
		
		public void actionPerformed(ActionEvent e){
			count++;
			
			
			
		}
	}
	
	private class MouseMovement implements MouseMotionListener{
		public void mouseMoved(MouseEvent e){
			x = e.getX();
			y = e.getY();
			
			
		}
		
		public void mouseDragged(MouseEvent e) {}
		
	}
	
	private class MoveRabbit implements ActionListener{		// restart the rabbits posiiton
		public void actionPerformed(ActionEvent e) {
			Random rand = new Random();
			
			rabbitX = rabbitX - INCREMENT;
			
			if (rabbitX < -600){
			int n = rand.nextInt(8)*50;
				rabbitX = 1000;
				rabbitY = n;
			}
			
			
			}
		}
	
	private class MovePlus implements ActionListener{			// move the plus sign up 
		public void actionPerformed(ActionEvent e){			// when the rabbit is hit
			
			clickedY = clickedY - plusINCREMENT;
			
		}
	}
		
	private class ClickTarget implements MouseListener{			// determine whether the rabbit
		public void mouseClicked(MouseEvent e){				// has been hit
			clickedX = e.getX();
			clickedY = e.getY();
			
			if (clickedX < rabbitX + 130 && clickedX > rabbitX - 5){
				if (clickedY < rabbitY + 130 && clickedY > rabbitY - 5){
					points++;
				
					if (points % 10 == 0){
						level++;
						INCREMENT++;
				
				}
			}
		}
			
				
				
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
}
		
			
		}
	

	
