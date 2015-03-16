import java.nio.ByteBuffer;
import java.util.LinkedList;

import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;

public class Scene implements GLEventListener
{
	Input input;
	GLU glu;
	
	
	float x = 1f;
	float y = 1f;
	float offsetX = 0f;
	float offsetY = 0f;
	float scale = 1f;
	
	int color = 0;
	
	boolean eraser = false;
	boolean drawing = true;
	boolean selection = false;
	
	static LinkedList<Pixel> dotList = new LinkedList<Pixel>();
	LinkedList<Pixel> drawQueue = new LinkedList<Pixel>();
	
	private int counter = 0;
	private boolean frameReady = false;
	private boolean mouse1Clicked = false;
	private boolean lastMouse1Clicked = false;
	private boolean mouse3Clicked = false;
	private boolean lastMouse3Clicked = false;
	
	private float tempMouseX, tempMouseY;
	
	private ByteBuffer buffer = null;
	
	public Scene(Input input)
	{
		this.input = input;
		tempMouseX = 0.0f;
		tempMouseY = 0.0f;
	}
	
	@Override
	public void display(GLAutoDrawable drawable) 
	{
		render(drawable);
		update(drawable);
	}
	
	private void render(GLAutoDrawable drawable)
	{
		GL2 gl = drawable.getGL().getGL2();
		gl.glClearColor(1.0f, 1.0f, 1.0f, 0.0f);
		gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);
		
		for(Pixel pixel : dotList)
		{
			gl.glBegin(GL2.GL_POLYGON);
			pixel.draw(gl);
			gl.glEnd();
		}
		
//		gl.glReadPixels(10, 10, 1, 1, 
//				GL2.GL_DEPTH_COMPONENT, GL2.GL_BYTE,
//				buffer);
		
		drawable.swapBuffers();
	}

	@Override
	public void dispose(GLAutoDrawable drawable) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(GLAutoDrawable drawable) 
	{
		glu = new GLU();
		drawable.getGL().setSwapInterval(0);
	}

	@Override
	public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) 
	{
		GL2 gl = drawable.getGL().getGL2();
		final float ar = (float)width/(float)height;
		
		gl.glViewport(0, 0, width, height);
		gl.glMatrixMode(GL2.GL_PROJECTION);
		gl.glLoadIdentity();
		gl.glOrtho(0, width, 0, height, 0.0, 100.0);
		
		gl.glMatrixMode(GL2.GL_MODELVIEW);
		gl.glLoadIdentity();
	}
	
	public void update(GLAutoDrawable drawable)
	{
		GL2 gl = drawable.getGL().getGL2();
		
		eraser = Toolbar.eraserState;
		drawing = Toolbar.drawingState;
		selection = Toolbar.selectionState;
		
		lastMouse1Clicked = mouse1Clicked;
		lastMouse3Clicked = mouse3Clicked;
		mouse1Clicked = input.isMouse1Pressed();
		mouse3Clicked = input.isMouse3Pressed();
		frameReady = counter % 5 == 0;
		
		x = (input.getMouseX()) / scale;
		y = (drawable.getHeight() - input.getMouseY()) / scale;
		
		if (mouse1Clicked && frameReady && drawing)
		{
			//System.out.println("Mouse X: " + x + " Mouse Y: " + y);
			Pixel pixel = new Pixel(x, y, scale, color);
			
			if(x > 0 && y > 0)
			{
				dotList.add(pixel);
				if(lastMouse1Clicked)
					drawQueue.add(pixel);
			}
			
			if(x <= 0 || y <= 0)
			{
				drawQueue.clear();
				drawQueue.add(pixel);
			}
			
			if(drawQueue.size() > 1)
			{
				int index = drawQueue.size() - 1;
				float startX = drawQueue.get(index - 1).x;
				float endX = drawQueue.get(index).x;
				float startY = drawQueue.get(index - 1).y;
				float endY = drawQueue.get(index).y;
				
				for (float i = 0f; i < 1f; i += 0.01)
					dotList.add(index - 1, new Pixel(Interpolate.calcX(i, startX, endX), Interpolate.calcY(i, startY, endY), scale, color));
			}
		}
		else if(drawing == false && selection == false)
		{
			if(mouse1Clicked)
			{
				scale += 0.01f;
				offsetX = x;
				offsetY = y;
			}
			else if(mouse3Clicked)
			{
				scale -= 0.01f;
				offsetX = x;
				offsetY = y;
			}
		}
		else if(drawing == false && selection)
		{
			if(mouse1Clicked && lastMouse1Clicked)
			{
				offsetX += tempMouseX + x;
				offsetY += tempMouseY + y;
				
				tempMouseX = x;
				tempMouseY = y;
				
				//System.out.println("Scale: " + scale + " offsetX: " + offsetX + " offsetY: " + offsetY);
			}
		}
		
		if(eraser)
			color = 1;
		else
			color = 0;
		
		if(!lastMouse1Clicked)
			drawQueue.clear();	
		
		counter++;
		
		if(counter > 60)
			counter = 0;
		
		for(Pixel p : dotList)
		{
			p.setScale(scale);
			p.setOffset(offsetX, offsetY);
		}
	}
}
