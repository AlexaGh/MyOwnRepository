package mamoeryGame2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ButtonListener implements ActionListener {

	private JButton button; // Button that was pressed
	private Object lock; // Object used to synchronize the button
	private boolean waiting; // Whether waiting for action or not

	public ButtonListener() {
		lock = new Object();
	}

	/*
	 * "Pauses" the program, waiting until a button is pressed. Returns a
	 * reference to the button that was pressed.
	 */
	public JButton waitForButton() {
		waiting = true;

		try {
			synchronized (lock) {
				while (waiting == true)
					lock.wait();
			}
		} catch (InterruptedException e) {
		}

		return button;
	}

	/*
	 * Gets the reference to the button that was clicked on.
	 */

	@Override
	public void actionPerformed(ActionEvent event) {
		button = (JButton) event.getSource();
		waiting = false;

		synchronized (lock) {
			lock.notifyAll();
		}

	}

}
