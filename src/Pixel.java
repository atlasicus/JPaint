import javax.media.opengl.GL2;


public class Pixel 
{
	public float x;
	public float y;
	public int color;
	private float scale;
	private float offsetX = 1f, offsetY = 1f;
	
//	boolean once = true;
	
	public Pixel(float x, float y, float scale, int color)
	{
		//System.out.println("Mouse X: " + x + " Mouse Y: " + y);
		this.x = x;
		this.y = y;
		this.scale = scale;
		this.color = color;
	}
	
	void draw(GL2 gl)
	{	
		gl.glColor3d(color, color, color);
		gl.glVertex2f(((x) * scale) + offsetX, (((y) * scale)) + offsetY);
		gl.glVertex2f(((x) * scale) + offsetX, ((y + 10) * scale) + offsetY);
		gl.glVertex2f(((x+ 10) * scale) + offsetX, ((y + 10) * scale) + offsetY);
		gl.glVertex2f(((x + 10) * scale) + offsetX, ((y) * scale) + offsetY);
	}
	
	public void setScale(float scale)
	{
		this.scale = scale;
	}
	public void setOffset(float x, float y)
	{
		this.offsetX = x;
		this.offsetY = y;
	}
}

