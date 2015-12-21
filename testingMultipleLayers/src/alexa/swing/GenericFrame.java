package alexa.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.List;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.Border;

public class GenericFrame extends JFrame {

	private ArrayList<JButton> buttons = new ArrayList<>();
	//JToolBar toolBar = new JToolBar("Still draggable");

	public GenericFrame() {
		
		setSize(600, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridLayout(3, 1));
		//toolBar.setRollover(true);

		///toolBar.add(new JButton("New"));
		//add(toolBar, "North");
		
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();

		add(panel1);
		add(panel2);
		add(panel3);

		panel1.setLayout(null);
		panel2.setLayout(new BorderLayout());
		panel3.setLayout(new FlowLayout());
		panel1.setBorder(BorderFactory.createLineBorder(Color.red, 5));
		panel2.setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
		panel3.setBorder(BorderFactory.createLineBorder(Color.WHITE, 5));

		for (int i = 0; i < 10; i++) {
			buttons.add(new JButton("Button-" + i));
			if (i < 5) {
				panel3.add(buttons.get(i));
			} else if (i == 5) {
				panel2.add(buttons.get(i), BorderLayout.NORTH);
			} else if (i == 6) {
				panel2.add(buttons.get(i), BorderLayout.SOUTH);
			} else if (i == 7) {
				panel2.add(buttons.get(i), BorderLayout.CENTER);
			} else if (i == 8) {
				panel2.add(buttons.get(i), BorderLayout.WEST);
			} else {
				panel2.add(buttons.get(i), BorderLayout.EAST);
			}

		}

		

		setVisible(true);
	}

}
