package pack1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JLabel;

public class Draw extends JLabel //Klasse fürs Zeichnen von Strings, Bildern etc
{
	private static final long serialVersionUID = 1L;

	final float version = 0.5f;
	
		protected void paintComponent(Graphics g)
		{
			
			super.paintComponent(g);
			Graphics2D g2d = (Graphics2D) g;
			
			g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			
			g.setColor(Color.RED);
			g.setFont(new Font("Arial", Font.BOLD, 20));
			if(Var.ingame == true) //hier wird das Hauptspiel gezeichnet
			{
				g.setFont(Img.Pew);
				g.drawString("Hier ist später mal ein Spiel :D", 100, 100);
			}
			else //hier wird alles gezeichnet was außerhalb des Hauptspiels wichtig ist
			{
				g.setFont(new Font("Arial", Font.BOLD, 20));
				g.drawString("V: " + version, 935, 565);
			}
			repaint();
		}
}
