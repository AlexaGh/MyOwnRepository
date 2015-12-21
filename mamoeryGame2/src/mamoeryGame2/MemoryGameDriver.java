package mamoeryGame2;

import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class MemoryGameDriver {

	private MemoryGame game;
	private MemoryGamePanel panel;
	private String frameTitle;
	private URL iconURL;

	public MemoryGameDriver(String frameTitle) {
		String codeBase = "file:";

		this.frameTitle = frameTitle;

		// Get the url for the image to set as the frame's icon
		try {
			iconURL = new URL(codeBase + "images/icon.jpg");
		} catch (MalformedURLException e) {
			System.out.println("Error: " + e.getMessage());
		}

		panel = new MemoryGamePanel(codeBase, false);
		game = panel.game;

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
				createAndShowGUI();
			}
		});
	}

	private void createAndShowGUI() {
		JFrame frame = new JFrame(frameTitle);
		frame.getContentPane().add(panel);
		frame.setIconImage(ImageLoader.getImage(iconURL));
		frame.setResizable(false);
		frame.setSize(panel.getPreferredSize());
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		MemoryGameDriver driver = new MemoryGameDriver("Animals Memory Game");
		driver.game.playGame();
		System.exit(0);
	}

}
