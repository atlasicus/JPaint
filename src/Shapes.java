//import javax.media.opengl.*;

public class Shapes
{	/*
	// Draw triangle
	public void triangle(GL2 gl, float xin, float yin, float zin) 
	{
		//gl.glPushMatrix();
		gl.glTranslatef(xin, yin, zin);
		gl.glColor3f(0, 0, 0);
		//gl.glPopMatrix();
	}
	
	// Draw cube
	public void cube(GL2 gl, float a ) 
    {
		//final float thickLineWidth = 1.0f;
		//final float thinLineWidth  = 1.0f;

		gl.glBegin(GL.GL_LINE_STRIP);

		gl.glVertex3f(-a, -a, a);
		gl.glVertex3f(-a, +a, a);
		gl.glVertex3f(+a, +a, a);
		gl.glVertex3f(+a, -a, a);
      	gl.glVertex3f(-a, -a, a);

      	gl.glVertex3f(-a, -a, -a);
      	gl.glVertex3f(-a, +a, -a);
      	gl.glVertex3f(+a, +a, -a);
      	gl.glVertex3f(+a, -a, -a);
      	gl.glVertex3f(-a, -a, -a);

      	gl.glEnd();

      	gl.glBegin(GL.GL_LINES);

      	gl.glVertex3f(-a, -a, +a);
      	gl.glVertex3f(-a, -a, -a);

      	gl.glVertex3f(-a, +a, +a);
      	gl.glVertex3f(-a, +a, -a);

      	gl.glVertex3f(+a, +a, +a);
      	gl.glVertex3f(+a, +a, -a);

      	gl.glVertex3f(+a, -a, +a);
      	gl.glVertex3f(+a, -a, -a);

      	gl.glEnd();
    }
	
	// Draw circle
	public void circle(GL2 gl, float xin, float yin, float zin) 
	{
		double r = 0.9f; // Radius
		
		gl.glBegin( GL.GL_TRIANGLE_FAN );
		{
			gl.glVertex3f(xin, yin, zin); // Center
			for( float a = 0;  a <= 360; a+=10 )
			{
				float ang = (float) Math.toRadians(a);
				float x = xin + (float) (r*Math.cos( ang ));
				float y = yin + (float) (r*Math.sin( ang ));
				float z = zin + 0f;
				gl.glVertex3f( x, y, z );
			}
		}
		
		gl.glEnd();
	}
	*/
}
