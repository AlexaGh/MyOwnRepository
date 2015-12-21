package mamoeryGame2;

import java.awt.Graphics;
import java.awt.MediaTracker;
import java.awt.Panel;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;

import javax.imageio.ImageIO;

public class ImageLoader {

	
	private static HashMap<String, BufferedImage> cache = 
	        new HashMap<String, BufferedImage>();
	    
	    public synchronized static BufferedImage getImage(String fileName)
	    {
	        BufferedImage img = cache.get(fileName);
	        
	        if(img == null)
	        {
	            img = loadImage(new File(fileName));
	            cache.put(fileName, img);
	        }
	        
	        return img;
	    }
	    
	    public synchronized static BufferedImage getImage(URL url)
	    {
	        BufferedImage img = cache.get(url.toString());
	        
	        if(img == null)
	        {
	            img = loadImage(url);
	            cache.put(url.toString(), img);
	        }
	        
	        return img;
	    }
	    
	    //////////////////////////////////////////////////////////////
	    ///////////////// PRIVATE IMPLEMENTATION /////////////////////
	    //////////////////////////////////////////////////////////////
	    /**
	     * Loads the specified image. The new image will replace any previous image.
	     * 
	     * @param imageName
	     *            Can be either a local filename or a URL of a GIF, JPG, or PNG
	     *            image.
	     */
	    private static BufferedImage loadImage(File imageFile)
	    {
	        java.awt.Image origImage;
	        
	        try
	        {
	            origImage = ImageIO.read(imageFile);
	        }
	        catch(IOException e)
	        {
	            e.printStackTrace();
	            return null;
	        }
	        
	        return loadImage(origImage);
	    }

	    private static BufferedImage loadImage(URL imageURL) 
	    {
	        java.awt.Image origImage;
	        
	        try
	        {
	            origImage = ImageIO.read(imageURL);
	        }
	        catch(IOException e)
	        {
	            e.printStackTrace();
	            return null;
	        }
	        
	        return loadImage(origImage);
	    }

	    private static BufferedImage loadImage(Image origImage)
	    {
	        int imageWidth;
	        int imageHeight;
	        BufferedImage buf;
	        Graphics g;
	        
	        // Java normally loads images in a background thread.
	        // This waits for the image to finish loading.
	        try
	        {
	            MediaTracker tracker = new MediaTracker(new Panel());
	            tracker.addImage(origImage, 0);
	            tracker.waitForID(0);
	            
	            if(tracker.statusID(0, true) != MediaTracker.COMPLETE)
	                throw new RuntimeException("Unable to load image");
	        }
	        catch(InterruptedException e)
	        {
	            // won't be interrupted
	        }
	        
	        // If image loaded, then create a BufferedImage which is modifiable
	        imageWidth = origImage.getWidth(null);
	        imageHeight = origImage.getHeight(null);
	        buf = new BufferedImage(imageWidth, imageHeight, 
	                BufferedImage.TYPE_INT_RGB);
	        
	        g = buf.createGraphics();
	        g.drawImage(origImage, 0, 0, null);
	        
	        return buf;
	    }
}
