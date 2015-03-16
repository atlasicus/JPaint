import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

import javax.imageio.ImageIO;

public class DiskOperation 
{
	static void writeImage(ByteBuffer buffer)
	{
		try 
		{
			InputStream stream = new ByteArrayInputStream(buffer.array());
			BufferedImage imageBuffer = ImageIO.read(stream);
			ImageIO.write(imageBuffer, "png", new File("test.png"));
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
	}
}
