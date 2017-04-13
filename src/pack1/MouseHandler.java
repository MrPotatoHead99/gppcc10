package pack1;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class MouseHandler  implements MouseListener, MouseMotionListener, MouseWheelListener  //verarbeitung von Maus
{

	@Override
	public void mouseWheelMoved(MouseWheelEvent arg0) 
	{	
	}

	@Override
	public void mouseDragged(MouseEvent arg0) 
	{
	}

	@Override
	public void mouseMoved(MouseEvent arg0) 
	{
	}

	@Override
	public void mouseClicked(MouseEvent arg0)
	{
		System.out.println("Hi, ich lebe");
	}

	@Override
	public void mouseEntered(MouseEvent arg0) 
	{
	}

	@Override
	public void mouseExited(MouseEvent arg0) 
	{
	}

	@Override
	public void mousePressed(MouseEvent arg0) 
	{
		System.out.println("Maus wurde gedrückt");
	}

	@Override
	public void mouseReleased(MouseEvent arg0) 
	{
		System.out.println("Maus wurde los gelassen");
	}

}
