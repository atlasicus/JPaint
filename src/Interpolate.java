
public class Interpolate 
{
	public static float calcX(float t, float startX, float endX)
	{
		float u = 1 - t;
		float tt = t * t;
		float uu = u * u;
		float uuu = uu * u;
		float ttt = tt * t;
		
		float pointX = startX * uuu;
		
		pointX += 3 * uu * t * startX;
		pointX += 3 * u * tt * endX;
		pointX += ttt * endX;
		
		return pointX;
	}
	
	public static float calcY(float t, float startY, float endY)
	{
		float u = 1 - t;
		float tt = t * t;
		float uu = u * u;
		float uuu = uu * u;
		float ttt = tt * t;
		
		float pointY = startY * uuu;
		
		pointY += 3 * uu * t * startY;
		pointY += 3 * u * tt * endY;
		pointY += ttt * endY;
		
		return pointY;
	}
}
