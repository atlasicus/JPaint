import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLProfile;
import javax.media.opengl.awt.GLCanvas;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;

import com.jogamp.opengl.util.FPSAnimator;

public class Main 
{
    public static void main(String[] args) 
    {
        
    	//Initialize an OpenGL canvas for use
    	GLProfile.initSingleton();
    	
    	Input input = new Input();
        GLProfile glProfile = GLProfile.getDefault();
        GLCapabilities glCapabilities = new GLCapabilities(glProfile);
        GLCanvas canvas = new GLCanvas(glCapabilities);
        FPSAnimator animator = new FPSAnimator(canvas, 60);
        canvas.addMouseListener(input);
        canvas.addMouseMotionListener(input);
        canvas.addGLEventListener(new Scene(input));
        
        Toolbar toolbar = new Toolbar();
        
    	// Sets up a new AWT window frame
        // [old frame name - before menu implementation - DP]
    	// Frame frame = new Frame("Test");
        // frame.setSize(800, 600);
    	
    	// Creating the Frame
        JFrame frame = new JFrame("Giraffe Drawing Program");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(880,600);
        // frame.setUndecorated(true);
        
        //Add our GLCanvas to our frame
        frame.add(canvas);
        frame.getContentPane().setPreferredSize(new Dimension(800, 600));
        frame.pack();
        
        // Creating the MenuBar and adding components
        JMenuBar menubar = new JMenuBar();
        JMenu menu1 = new JMenu("File");
        JMenu menu2 = new JMenu("Edit");
        JMenu menu3 = new JMenu("Tools");
        JMenu menu4 = new JMenu("View");
        menubar.add(menu1);
        menubar.add(menu2);
        menubar.add(menu3);
        menubar.add(menu4);
        JMenuItem m1_1 = new JMenuItem("New File");
        JMenuItem m1_2 = new JMenuItem("Load File");
        JMenuItem m1_3 = new JMenuItem("Save File");
        JMenuItem m1_4 = new JMenuItem("Revert");
        JMenuItem m1_5 = new JMenuItem("Quit");
        menu1.add(m1_1);
        menu1.add(m1_2);
        menu1.add(m1_3);
        menu1.add(m1_4);
        menu1.add(m1_5);
        JMenuItem m2_1 = new JMenuItem("Undo");
        JMenuItem m2_2 = new JMenuItem("Redo");
        JMenuItem m2_3 = new JMenuItem("--------");
        JMenuItem m2_4 = new JMenuItem("Crop");
        JMenuItem m2_5 = new JMenuItem("Transparency");
        JMenuItem m2_6 = new JMenuItem("Clear");
        JMenuItem m2_7 = new JMenuItem("--------");
        JMenuItem m2_8 = new JMenuItem("Transparency");
        JMenuItem m2_9 = new JMenuItem("Pressure");
        JMenuItem m2_10 = new JMenuItem("Blend");
        menu2.add(m2_1);
        menu2.add(m2_2);
        menu2.add(m2_3);
        menu2.add(m2_4);
        menu2.add(m2_5);
        menu2.add(m2_6);
        menu2.add(m2_7);
        menu2.add(m2_8);
        menu2.add(m2_9);
        menu2.add(m2_10);
        JMenuItem m3_1 = new JMenuItem("Pencil");
        JMenuItem m3_2 = new JMenuItem("Charcoal");
        JMenuItem m3_3 = new JMenuItem("Line");
        JMenuItem m3_4 = new JMenuItem("Ellipse");
        JMenuItem m3_5 = new JMenuItem("Rectangle");
        JMenuItem m3_6 = new JMenuItem("----------");
        JMenuItem m3_7 = new JMenuItem("Select");
        JMenuItem m3_8 = new JMenuItem("Marquee");
        JMenuItem m3_9 = new JMenuItem("Erase");
        JMenuItem m3_10 = new JMenuItem("Blend");
        menu3.add(m3_1);
        menu3.add(m3_2);
        menu3.add(m3_3);
        menu3.add(m3_4);
        menu3.add(m3_5);
        menu3.add(m3_6);
        menu3.add(m3_7);
        menu3.add(m3_8);
        menu3.add(m3_9);
        menu3.add(m3_10);
        JMenuItem m4_1 = new JMenuItem("Zoom In");
        JMenuItem m4_2 = new JMenuItem("Zoom Out");
        menu4.add(m4_1);
        menu4.add(m4_2);

       frame.getContentPane().add(BorderLayout.NORTH,menubar);
       frame.getContentPane().add(toolbar,BorderLayout.WEST);
       
       //frame.getContentPane().add(BorderLayout.CENTER,ta);
        frame.setVisible(true);
        
        
        
//        // - - - - -
//        // DAVE
//     	// START save image
//     	// - - - - -
//        
//        final String defaultImageFilename = 
//        		  new String("duke_wave.gif");
//        		  final String defaultFrameImageFilename = 
//        		  new String("frame.png");
//
//        		  // Databuffer that holds the loaded image.
//        		  byte[] imgRGBA = null;
//        		  // Image size retrieved durung loading,
//        		  // re-used when image is drawn.
//        		  int imgHeight;
//        		  int imgWidth;
//
//        		  // To copy the content of the current frame.
//        		  int frameWidth;
//        		  int frameHeight;
//        
//        private ByteBuffer getFrameData( GL gl, ByteBuffer pixelsRGB ) 
//		{
//        	// Read Frame back into our ByteBuffer.
//        	gl.glReadBuffer( GL.GL_BACK );
//        	gl.glPixelStorei( GL.GL_PACK_ALIGNMENT, 1 );
//        	gl.glReadPixels( 0, 0, frameWidth, frameHeight, GL.GL_RGB, GL.GL_UNSIGNED_BYTE, pixelsRGB );
//        	return pixelsRGB;
//        }
//		
//		
//		private BufferedImage copyFrame( GL gl ) 
//		 {  
//		   // Create a ByteBuffer to hold the frame data.
//		   java.nio.ByteBuffer pixelsRGB = 
//			//BufferUtils.newByteBuffer
//			ByteBuffer.allocateDirect
//			( frameWidth * frameHeight * 3 ); 
//		
//		   // Get date from frame as ByteBuffer.
//		   getFrameData( gl, pixelsRGB );
//		
//		   return transformPixelsRGBBuffer2ARGB_ByHand
//			( pixelsRGB );
//		 }
//		
//		
//		// Copies the Frame to an integer array.
//		// Do the necessary conversion by hand.
//		//
//		private BufferedImage transformPixelsRGBBuffer2ARGB_ByHand
//		( ByteBuffer pixelsRGB)
//		 {
//		   // Transform the ByteBuffer and get it as pixeldata.
//		
//		   int[] pixelInts = new int[ frameWidth * frameHeight ];
//		
//		   // Convert RGB bytes to ARGB ints with no transparency. 
//		   // Flip image vertically by reading the
//		   // rows of pixels in the byte buffer in reverse 
//		   // - (0,0) is at bottom left in OpenGL.
//		   //
//		   // Points to first byte (red) in each row.
//		   int p = frameWidth * frameHeight * 3; 
//		   int q; // Index into ByteBuffer
//		   int i = 0; // Index into target int[]
//		   int w3 = frameWidth * 3; // Number of bytes in each row
//		   for (int row = 0; row < frameHeight; row++) {
//			p -= w3;
//			q = p;
//			for (int col = 0; col < frameWidth; col++) {
//			  int iR = pixelsRGB.get(q++);
//			  int iG = pixelsRGB.get(q++);
//			  int iB = pixelsRGB.get(q++);
//			  pixelInts[i++] = 
//			    0xFF000000 | ((iR & 0x000000FF) << 16) | 
//			    ((iG & 0x000000FF) << 8) | (iB & 0x000000FF);
//			}
//		   }
//		
//		   // Create a new BufferedImage from the pixeldata.
//		   BufferedImage bufferedImage = 
//			new BufferedImage( frameWidth, frameHeight, 
//					   BufferedImage.TYPE_INT_ARGB);
//		   bufferedImage.setRGB( 0, 0, frameWidth, frameHeight, 
//					    pixelInts, 0, frameWidth );
//		
//		   return bufferedImage;
//		 }
//		
//		
//		// Function returns if filename already exsits.
//		// In this way it does not save each frame, when
//		// calles from the display() function.
//		public void saveFrameAsPNG( GL gl, String fileName ) 
//		 {
//		   // Open File
//		   if( fileName == null ) {
//			fileName = new String( defaultFrameImageFilename ); }
//		   File outputFile = new File( fileName );
//		   // Do not overwrite existing image file.
//		   if( outputFile.exists() ) { return; }
//		
//		   // Write file.
//		   try {
//			javax.imageio.ImageIO.write( 
//			  copyFrame( gl ), "PNG", outputFile );
//		   } catch (IOException e) {
//			System.out.println( "Error: ImageIO.write." );
//			e.printStackTrace();
//		   }
//	}
//		
//		// - - - - -
//		// DAVE
//		// END save image
//		// - - - - -
       
        
        //Enable us to close our window
        frame.addWindowListener(new WindowAdapter()
        {
        	public void windowClosing(WindowEvent e)
        	{
                System.exit(0);
            }
        });
        
        animator.add(canvas);
       	animator.start();
       	
//      SwingUtilities.invokeLater(new Runnable()
//      {
//   	   //Toolbar testing = new Toolbar();
//   	   public void run()
//   	   {
//               // UIManager.put("swing.boldMetal", Boolean.FALSE);
//               Toolbar.createAndShowGUI();
//          }
//       });
       
       /*
       // - - - - -
       // DAVE
       // Old Toolbar without functionality
       // works
       JToolBar toolbar = new JToolBar("Toolbar", JToolBar.VERTICAL);
       JButton buttonSelect = new JButton(new ImageIcon("images/selection.png"));
       toolbar.add(buttonSelect);
       JButton buttonPencil = new JButton(new ImageIcon("images/pencil.png"));
       toolbar.add(buttonPencil);
       JButton buttonCharcoal = new JButton(new ImageIcon("images/charcoal.png"));
       toolbar.add(buttonCharcoal);
       JButton buttonCrop = new JButton(new ImageIcon("images/crop.png"));
       toolbar.add(buttonCrop);
       JButton buttonMarquee = new JButton(new ImageIcon("images/marquee.png"));
       toolbar.add(buttonMarquee);
       JButton buttonZoom = new JButton(new ImageIcon("images/zoom.png"));
       toolbar.add(buttonZoom);
       
       frame.setUndecorated(true);
       frame.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
       //Adding Components to the frame.
       frame.getContentPane().add(BorderLayout.NORTH,menubar);
       frame.getContentPane().add(toolbar,BorderLayout.WEST);
       //frame.getContentPane().add(BorderLayout.CENTER,ta);
       frame.setVisible(true);
       // - - - - -
       */
    }
}