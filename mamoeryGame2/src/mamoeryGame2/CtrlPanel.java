package mamoeryGame2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class CtrlPanel extends JPanel{
	
	  private static final long serialVersionUID = 2457951258330065444L;
	    
	    private Dimension size;
	    public static final int HEIGHT = 40;
	    
	    /*
	     * Creates a panel with the given array of buttons and the width to fit to
	     * the parent frame.
	     */
	    public CtrlPanel(JButton[] buttons, int width)
	    {
	        size = new Dimension(width, HEIGHT);
	        setBackground(Color.DARK_GRAY);
	        
	        setLayout(new FlowLayout(FlowLayout.CENTER));
	        
	        if(buttons != null)
	            for(int i = 0; i < buttons.length; i++)
	                add(buttons[i]);
	    }
	    
	    /*
	     * Create a panel with no buttons.
	     */
	    public CtrlPanel(int width)
	    {
	        this(null, width);
	    }
	    
	    /*
	     * Returns the Dimension size of the panel
	     */
	    public Dimension getPreferredSize()
	    {
	        return size;
	    }

}
