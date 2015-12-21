package alexas;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


public class AquaticFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JRadioButton SeaTurtleButton = new JRadioButton("Sea Turtle");
	private JRadioButton SeaHorseButton = new JRadioButton("Sea Horse");
	private JRadioButton MoonJellyButton = new JRadioButton("MoonJellyfish");

	AquaticFrameAttributes alexaa = new AquaticFrameAttributes();
	
	public AquaticFrame() {

		super("The title2");
		setLayout(new FlowLayout());

		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(SeaTurtleButton);
		buttonGroup.add(SeaHorseButton);
		buttonGroup.add(MoonJellyButton);

		add(SeaTurtleButton);
		add(SeaHorseButton);
		add(MoonJellyButton);

		RadioButtonActionListener actionListener = new RadioButtonActionListener();
		SeaTurtleButton.addActionListener(actionListener);
		SeaHorseButton.addActionListener(actionListener);
		MoonJellyButton.addActionListener(actionListener);

	}

	class RadioButtonActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			JRadioButton button = (JRadioButton) event.getSource();

			if (button == SeaTurtleButton) {

				alexaa.setSize(600,300);
				alexaa.setLocation(450, 200);
				alexaa.setVisible(true);

			} else if (button == SeaHorseButton) {

				JOptionPane.showMessageDialog(null, "hmm2");

			} else if (button == MoonJellyButton) {

				JOptionPane.showMessageDialog(null, "hmm3");

			}

		}
	}

}
