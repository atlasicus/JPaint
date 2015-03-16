import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.event.MouseInputAdapter;


public class Input implements MouseListener, MouseMotionListener
{	
	float x = 0, y = 0;
	private boolean isMouseButton1Pressed = false, isMouseButton2Pressed = false, isMouseButton3Pressed = false;
	
	public boolean isMouse1Pressed()
	{
		return isMouseButton1Pressed;
	}
	
	public boolean isMouse2Pressed()
	{
		return isMouseButton2Pressed;
	}
	
	public boolean isMouse3Pressed()
	{
		return isMouseButton3Pressed;
	}
	
	public float getMouseX()
	{
		return this.x;
	}
	
	public float getMouseY()
	{
		return this.y;
	}
	
	@Override
	public void mouseClicked(MouseEvent e)
	{

	}

	@Override
	public void mouseEntered(MouseEvent e) 
	{
	
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) 
	{
		System.out.println("Mouse " + e.toString() + " clicked");
		if (e.getButton() == MouseEvent.BUTTON1)
		{
			isMouseButton1Pressed = true;
			x = e.getX();
			y = e.getY();
			//System.out.println("Mouse Button 1 pressed");
		}
		
		if(e.getButton() == MouseEvent.BUTTON2)
		{
			isMouseButton2Pressed = true;
		}
		if (e.getButton() == MouseEvent.BUTTON3)
		{
			isMouseButton3Pressed = true;
		}
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		if(e.getButton() == MouseEvent.BUTTON1)
		{
			isMouseButton1Pressed = false;
		}
		if(e.getButton() == MouseEvent.BUTTON2)
		{
			isMouseButton2Pressed = false;
		}
		if(e.getButton() == MouseEvent.BUTTON3)
		{
			isMouseButton3Pressed = false;
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) 
	{
		//System.out.println("Mouse dragged");
		x = e.getX();
		y = e.getY();
	}

	@Override
	public void mouseMoved(MouseEvent e) 
	{
		
	}

}