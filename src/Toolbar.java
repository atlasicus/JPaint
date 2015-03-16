import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JToolBar;

public class Toolbar extends JPanel implements ActionListener
{
	
	private static final long serialVersionUID = -7330949998607421758L;
	protected JTextArea textArea;
    protected String newline = "\n";
	static final private String ERASER = "eraser";
	static final private String CROP = "crop";
	static final private String PENCIL = "pencil";
	static final private String SELECT = "select";
    static final private String ZOOM = "zoom";
    
    public static boolean eraserState = false;
    public static boolean drawingState = true;
    public static boolean selectionState = false;
    
    private static boolean[] buttonStatus;
    
    private JToolBar toolBar;
    
    public Toolbar ()
    {
        super(new BorderLayout());
 
        // create the toolbar
        toolBar = new JToolBar("Toolbar", JToolBar.VERTICAL);
        toolBar.setFloatable(false);
        addButtons(toolBar);
 
        // Create the text area used for output.  Request
        //enough space for 5 rows and 30 columns.
        /*
        textArea = new JTextArea(5, 30);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        */
 
        // lay out the main panel.
        setPreferredSize(new Dimension(55, 220));
        add(toolBar, BorderLayout.PAGE_START);
        //add(scrollPane, BorderLayout.CENTER);
        
        buttonStatus = new boolean[5];
        for(int i = 0; i < 5; i++)
        	buttonStatus[i] = false;
        
        buttonStatus[2] = true;
    }
    
    protected void addButtons(JToolBar toolbarAddButton)
    {
        JButton button = null;
        button = makeToolbarButton("charcoal", ERASER, "Eraser Tool", "eraser");
        toolbarAddButton.add(button);
        button = makeToolbarButton("crop", CROP, "Crop Tool", "crop");
        toolbarAddButton.add(button);
        button = makeToolbarButton("pencil-o", PENCIL, "Pencil Tool", "pencil");
        toolbarAddButton.add(button);
        button = makeToolbarButton("selection", SELECT, "Move Canvas", "select");
        toolbarAddButton.add(button);
        button = makeToolbarButton("zoom", ZOOM, "Zoom in/out", "zoom");
        toolbarAddButton.add(button);
    }
    
    protected void changeButtons(JToolBar toolBar)
    {
    	toolBar.removeAll();
    	JButton button = null;
    	
    	for(int i = 0; i < 5; i++)
    		System.out.println("Button " + i + " boolean status: " + buttonStatus[i]);
    	if(buttonStatus[0])
    	{
    		button = makeToolbarButton("charcoal-o", ERASER, "Eraser Tool", "eraser");
        	toolBar.add(button);
            button = makeToolbarButton("crop", CROP, "Crop Tool", "crop");
            toolBar.add(button);
            button = makeToolbarButton("pencil", PENCIL, "Pencil Tool", "pencil");
            toolBar.add(button);
            button = makeToolbarButton("selection", SELECT, "Move Canvas", "select");
            toolBar.add(button);
            button = makeToolbarButton("zoom", ZOOM, "Zoom in/out", "zoom");
            toolBar.add(button);
    	}
    	else if(buttonStatus[1])
    	{
    		button = makeToolbarButton("charcoal", ERASER, "Eraser Tool", "eraser");
        	toolBar.add(button);
            button = makeToolbarButton("crop-o", CROP, "Crop Tool", "crop");
            toolBar.add(button);
            button = makeToolbarButton("pencil", PENCIL, "Pencil Tool", "pencil");
            toolBar.add(button);
            button = makeToolbarButton("selection", SELECT, "Move Canvas", "select");
            toolBar.add(button);
            button = makeToolbarButton("zoom", ZOOM, "Zoom in/out", "zoom");
            toolBar.add(button);
    	}
    	else if(buttonStatus[2])
    	{
    		button = makeToolbarButton("charcoal", ERASER, "Eraser Tool", "eraser");
        	toolBar.add(button);
            button = makeToolbarButton("crop", CROP, "Crop Tool", "crop");
            toolBar.add(button);
            button = makeToolbarButton("pencil-o", PENCIL, "Pencil Tool", "pencil");
            toolBar.add(button);
            button = makeToolbarButton("selection", SELECT, "Move Canvas", "select");
            toolBar.add(button);
            button = makeToolbarButton("zoom", ZOOM, "Zoom in/out", "zoom");
            toolBar.add(button);
    	}
    	else if(buttonStatus[3])
    	{
    		button = makeToolbarButton("charcoal", ERASER, "Eraser Tool", "eraser");
        	toolBar.add(button);
            button = makeToolbarButton("crop", CROP, "Crop Tool", "crop");
            toolBar.add(button);
            button = makeToolbarButton("pencil", PENCIL, "Pencil Tool", "pencil");
            toolBar.add(button);
            button = makeToolbarButton("selection-o", SELECT, "Move Canvas", "select");
            toolBar.add(button);
            button = makeToolbarButton("zoom", ZOOM, "Zoom in/out", "zoom");
            toolBar.add(button);
    	}
    	else if(buttonStatus[4])
    	{
    		button = makeToolbarButton("charcoal", ERASER, "Eraser Tool", "eraser");
        	toolBar.add(button);
            button = makeToolbarButton("crop", CROP, "Crop Tool", "crop");
            toolBar.add(button);
            button = makeToolbarButton("pencil", PENCIL, "Pencil Tool", "pencil");
            toolBar.add(button);
            button = makeToolbarButton("selection", SELECT, "Move Canvas", "select");
            toolBar.add(button);
            button = makeToolbarButton("zoom-o", ZOOM, "Zoom in/out", "zoom");
            toolBar.add(button);
    	}
    	else
    	{
    		button = makeToolbarButton("charcoal", ERASER, "Eraser Tool", "eraser");
        	toolBar.add(button);
            button = makeToolbarButton("crop", CROP, "Crop Tool", "crop");
            toolBar.add(button);
            button = makeToolbarButton("pencil", PENCIL, "Pencil Tool", "pencil");
            toolBar.add(button);
            button = makeToolbarButton("selection", SELECT, "Move Canvas", "select");
            toolBar.add(button);
            button = makeToolbarButton("zoom", ZOOM, "Zoom in/out", "zoom");
            toolBar.add(button);
    	}
    }
    
    public void resetToolbar()
    {
    	changeButtons(toolBar);
    	setPreferredSize(new Dimension(55, 220));
        add(toolBar, BorderLayout.PAGE_START);
    }
 
    protected JButton makeToolbarButton(String imageName, String actionName, String toolText, String altText)
    {
        //Look for the image.
        String imgLocation = "images/" + imageName + ".png";
        URL imageURL = Toolbar.class.getResource(imgLocation);
        
        //Create and initialize the button.
        JButton button = new JButton();
        button.setActionCommand(actionName);
        button.setToolTipText(toolText);
        button.addActionListener(this);
 
        if (imageURL != null)
        {
            button.setIcon(new ImageIcon(imageURL));
        }
        else
        {
            button.setText(altText);
            System.err.println("Resource not found: " + imgLocation);
        }
 
        return button;
    }
    
    public void resetButtons()
    {
    	for (int i = 0; i < 5; i++)
    	{
    		buttonStatus[i] = false;
    	}
    }

    public void actionPerformed(ActionEvent e)
    {
        String cmd = e.getActionCommand();
 
        // Handle each button.
        if (ERASER.equals(cmd))
        {
        	//not fully implemented
        	eraserState = true;
        	drawingState = true;
//        	selectionState = false;
        	
        	resetButtons();
        	buttonStatus[0] = true;
        	resetToolbar();
//            description = "charcoal tool clicked.";
        }
        else if (CROP.equals(cmd))
        {
        	//not fully implemented
        	resetButtons();
        	buttonStatus[1] = true;
        	resetToolbar();
//        	description = "crop tool clicked.";
        }
        else if (PENCIL.equals(cmd))
        {
        	//Not fully implemented
        	eraserState = false;
        	drawingState = true;
//        	selectionState = false;
        	resetButtons();
        	buttonStatus[2] = true;
        	resetToolbar();
//        	description = "pencil tool clicked.";
        }
        else if (SELECT.equals(cmd))
        {
        	//not fully implemented
//        	drawingState = false;
//        	selectionState = true;
        	resetButtons();
        	buttonStatus[3] = true;
        	resetToolbar();
//        	description = "select tool clicked.";
        }
        else if (ZOOM.equals(cmd))
        {
        	//not fully implemented
//        	drawingState = false;
//        	selectionState = false;
        	resetButtons();
        	buttonStatus[4] = true;
        	resetToolbar();
//        	description = "zoom tool clicked.";
        }
 
    }
    
    public static void createAndShowGUI()
    {
        JFrame frame = new JFrame("ToolBarDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Add content to the window.
        frame.add(new Toolbar());
 
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
}

