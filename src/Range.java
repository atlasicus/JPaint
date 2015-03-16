
public class Range 
{
	public static boolean Get(float input, float top, float bot)
	{
		if(input < top && input > bot)
			return true;
//		else if(input > top)
//			return top;
//		else if(input < bot)
//			return bot;
		else
			return false;
	}
}
