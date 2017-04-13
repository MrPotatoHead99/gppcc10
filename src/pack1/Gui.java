package pack1;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;


public class Gui //Erstellung von Buttons, dem JFrame, sonstige
{
	
	JFrame jf;
	Draw d;
	
	final BufferedImage icon = Img.load("src/resources/Icon.png");
	
	final int JFwidth = 1000, height = 600;
	
	static JButton btnStart, btnOpt, btnShop, btnQuit;
	
	public void createGui()
	{
		
		jf = new JFrame("Let it Snow!");
		jf.setSize(JFwidth, height);
		jf.setIconImage(icon);
		jf.setLocationRelativeTo(null);
		jf.setResizable(false);
		
		WindowAdapter exitListener = new WindowAdapter() //Was passiert wenn auf den schließen Button gedrückt wird
		{
		    @Override
		    public void windowClosing(WindowEvent e) 
		    {
		    	ButtonHandler.askSaving();
		    }
		};
		jf.addWindowListener(exitListener);
		
		SwingUtilities.invokeLater(new Runnable() //Laden des Icons trotz Runable Jar
		{
			@Override
			public void run() 
			{
				try //Versuche Icon zu laden und setzen
				{
					jf.setIconImage(ImageIO.read(new File("src/resources/Icon.png")));
				} catch (IOException e)
				{
					e.printStackTrace();
					System.out.println("Fehler beim erstellen des Fenster Icons");
					JOptionPane.showMessageDialog(null, "Fehler beim Laden des Fenster Icons (in Klasse Gui)"); //Meldung eventuell entfernen
				}
			}
			});

		Img.loadMaxFont();
		Img.loadusualFont();
		addButtons();
		
		d = new Draw();
		d.setSize(JFwidth, height);
		d.setVisible(true);
		d.requestFocus();
		d.addMouseListener(new MouseHandler());
		d.addMouseMotionListener(new MouseHandler());
		d.addMouseWheelListener(new MouseHandler());
		d.addKeyListener(new KeyboardHandler());
		jf.add(d);
		
		new savestateManager();
		
		jf.addKeyListener(new KeyboardHandler());
		jf.setVisible(true);
	}
	
	public void addButtons(){
		
		btnStart = new JButton("Start");
		btnStart.setBounds((JFwidth - 420)/2, 20, 420, 100);
		btnStart.setFont(Img.Max);
		btnStart.setForeground(new Color(43, 151, 140));
		btnStart.addActionListener(new ButtonHandler());
		btnStart.setFocusPainted(false);
		btnStart.setContentAreaFilled(false);
		// start.setToolTipText("hier könnte ein Tipp stehen"); kling ein wenig so wie: "hier könnte ihre Werbung stehen xD" - xD
		btnStart.setVisible(true);
		// btnStart.addMouseListener(new MouseAdapter()
		 // {	
			//	public void mouseEntered(MouseEvent evt)
			//	{
				//	btnStart.setForeground(new Color(59, 90, 155));
				//}
				//public void mouseExited(MouseEvent evt)
				//{
					//btnStart.setForeground(new Color(43,151,240));
				//}		
		//	});
		  jf.add(btnStart);
		  
		  
		  btnOpt = new JButton("Options");
		  btnOpt.setBounds((JFwidth - 420)/2, 140, 420, 100);
		  btnOpt.setFont(Img.Max);
		  //Var.JBNeu.setForeground(new Color(0, 230, 115));
		  btnOpt.setForeground(new Color(43, 151, 140));
		  btnOpt.addActionListener(new ButtonHandler());
		  btnOpt.setFocusPainted(false);
		  btnOpt.setContentAreaFilled(false);
		  // start.setToolTipText("hier könnte ein Tipp stehen"); kling ein wenig so wie: "hier könnte ihre Werbung stehen xD"
		  btnOpt.setVisible(true);
		  btnOpt.addMouseListener(new MouseAdapter()
			{	
			  public void mouseEntered(MouseEvent evt)
				{
				  btnOpt.setForeground(new Color(59, 90, 155));
				}
			  	public void mouseExited(MouseEvent evt)
			  		{
						btnOpt.setForeground(new Color(43,151,240));
					}		
				});
			  jf.add(btnOpt);
			  
			btnShop = new JButton("Shop");
			btnShop.setBounds((JFwidth - 420)/2, 260, 420, 100);
			btnShop.setFont(Img.Max);
			//Var.JBNeu.setForeground(new Color(0, 230, 115));
			btnShop.setForeground(new Color(43, 151, 140));
			btnShop.addActionListener(new ButtonHandler());
			btnShop.setFocusPainted(false);
			btnShop.setContentAreaFilled(false);
			// start.setToolTipText("hier könnte ein Tipp stehen"); kling ein wenig so wie: "hier könnte ihre Werbung stehen xD"
			btnShop.setVisible(true);
			btnShop.addMouseListener(new MouseAdapter()
				  {	
						public void mouseEntered(MouseEvent evt)
						{
							btnShop.setForeground(new Color(59, 90, 155));
						}
						public void mouseExited(MouseEvent evt)
						{
							btnShop.setForeground(new Color(43,151,240));
						}		
					});
				  jf.add(btnShop);
				  
			btnQuit = new JButton("Beenden");
			btnQuit.setBounds((JFwidth - 420)/2, 380, 420, 100);
			btnQuit.setFont(Img.Max);
			//Var.JBNeu.setForeground(new Color(0, 230, 115));
			btnQuit.setForeground(new Color(43, 151, 140));
			btnQuit.addActionListener(new ButtonHandler());
			btnQuit.setFocusPainted(false);
			btnQuit.setContentAreaFilled(false);
			// start.setToolTipText("hier könnte ein Tipp stehen"); kling ein wenig so wie: "hier könnte ihre Werbung stehen xD"
			btnQuit.setVisible(true);
			btnQuit.addMouseListener(new MouseAdapter()
					  {	
							public void mouseEntered(MouseEvent evt)
							{
								btnQuit.setForeground(new Color(59, 90, 155));
							}
							public void mouseExited(MouseEvent evt)
							{
								btnQuit.setForeground(new Color(43,151,240));
							}		
						});
			jf.add(btnQuit);
		
	}
}
