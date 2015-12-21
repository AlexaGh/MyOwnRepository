package alexas;

import javax.swing.JFrame;


public class Main {
	public static void main(String[] args) {
		
		FrameMenu alexa = new FrameMenu();
		alexa.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		alexa.setSize(600,300);
		alexa.setLocation(40, 200);
		alexa.setVisible(true);
		
	}
}
