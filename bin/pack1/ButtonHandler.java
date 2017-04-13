package pack1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JOptionPane;

public class ButtonHandler implements ActionListener 
{
	 static File localFile1 = null;
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{	
		if(e.getSource() == Gui.btnQuit)
		{
			System.out.println(savestateManager.gespeichert);
			if(savestateManager.gespeichert)
			{
				System.exit(0);
			}
			else
			{
				askSaving();
			}
		}
		
		if(e.getSource() == Gui.btnStart)
		{
			Var.ingame = true;
			Gui.btnOpt.setVisible(false);
			Gui.btnQuit.setVisible(false);
			Gui.btnStart.setVisible(false);
			Gui.btnShop.setVisible(false);
		}
	}

	public static void askSaving()
	{
		Object[] options = {"Ja", "Nein, Danke", "Abbrechen"};
		int reply = JOptionPane.showOptionDialog(null, "Alle nicht gespeicherten Spielstände gehen verloren!",
											"Achtung! Du hast nicht gespeichert!",
											JOptionPane.YES_NO_CANCEL_OPTION,
											JOptionPane.QUESTION_MESSAGE, null, options, options[2]);
		if (reply == JOptionPane.YES_OPTION)
	    {
	    	localFile1 = new File("Save.txt");
	    	savestateManager.save(localFile1);
	    	System.exit(0);
	    }
	    else if(reply == JOptionPane.NO_OPTION)
	    {
	    	System.exit(0);
	    }
	    else
	    {
	    	//Spieler hat auf Abbrechen gedrückt
	    }
	}
	
}
