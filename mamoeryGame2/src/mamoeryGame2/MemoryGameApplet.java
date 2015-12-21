package mamoeryGame2;

import javax.swing.JApplet;

public class MemoryGameApplet extends JApplet {

	private static final long serialVersionUID = -4179844911231101217L;

	MemoryGame game;

	public void init() {
		MemoryGamePanel panel = new MemoryGamePanel(getCodeBase().toString(), true);
		game = panel.game;

		getContentPane().add(panel);
		setVisible(true);
	}

	public void start() {
		game.playGame();
	}
}
