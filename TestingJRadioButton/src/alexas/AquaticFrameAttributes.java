package alexas;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JTextField;


public class AquaticFrameAttributes extends JFrame {

	private JCheckBox checkboxOne = new JCheckBox("ONE");
	private JCheckBox checkboxTwo = new JCheckBox("TWO");
	private JCheckBox checkboxThree = new JCheckBox("THREE");

	private JTextField textFieldSum = new JTextField(30);

	public AquaticFrameAttributes() {

		super("The title2");
		setLayout(new FlowLayout());

		add(checkboxOne);
		add(checkboxTwo);
		add(checkboxThree);

		textFieldSum.setEditable(false);
		add(textFieldSum);

		// add action listener for the check boxes
		ActionListener actionListener2 = new ActionHandler();
		checkboxOne.addActionListener(actionListener2);
		checkboxTwo.addActionListener(actionListener2);
		checkboxThree.addActionListener(actionListener2);
	}

	class ActionHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			JCheckBox checkbox = (JCheckBox) event.getSource();
			if (checkbox.isSelected()) {
				if (checkbox == checkboxOne) {

				} else if (checkbox == checkboxTwo) {

				} else if (checkbox == checkboxThree) {

				}
			} else {
				if (checkbox == checkboxOne) {

				} else if (checkbox == checkboxTwo) {

				} else if (checkbox == checkboxThree) {

				}
			}
			textFieldSum.setText("TEST");
		}

	}

}
