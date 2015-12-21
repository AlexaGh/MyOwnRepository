package alexas;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FrameMenu extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JRadioButton btnAquatic = new JRadioButton("Aquatic");
	private JRadioButton btnBird = new JRadioButton("Bird");
	private JRadioButton btnInsect = new JRadioButton("Insect");
	private JRadioButton btnMammal = new JRadioButton("Mammal");
	private JRadioButton btnReptile = new JRadioButton("Reptile");

	private JLabel labelImage = new JLabel();

	// C:/Users/Alexa/Desktop/JavaSummerCourse/MyRepo/JavaMainRepo/Students/Ghiurau
	// A. Alexandra Cristina/TestingJRadioButton/src
	private ImageIcon iconAquatic = new ImageIcon(getClass().getResource("/alexas/fish.png"));
	private ImageIcon iconBird = new ImageIcon(getClass().getResource("/alexas/bird.gif"));
	private ImageIcon iconInsect = new ImageIcon(getClass().getResource("/alexas/fly.png"));
	private ImageIcon iconMammal = new ImageIcon(getClass().getResource("/alexas/dog.gif"));
	private ImageIcon iconReptile = new ImageIcon(getClass().getResource("/alexas/trex2.png"));
	
	AquaticFrame alexaa = new AquaticFrame();


	public FrameMenu() {
		super("The title");
		setLayout(new FlowLayout());

		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(btnAquatic);
		buttonGroup.add(btnBird);
		buttonGroup.add(btnInsect);
		buttonGroup.add(btnMammal);
		buttonGroup.add(btnReptile);

		/*btnAquatic.setMnemonic(KeyEvent.VK_N);
		btnAquatic.setActionCommand("aquatic");
		labelImage.setIcon(iconAquatic);
		btnAquatic.setSelected(true);*/

		add(btnAquatic);
		add(btnBird);
		add(btnInsect);
		add(btnMammal);
		add(btnReptile);

		setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();

		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridwidth = 3;

		add(labelImage, constraints);

		RadioButtonActionListener actionListener = new RadioButtonActionListener();
		btnAquatic.addActionListener(actionListener);
		btnBird.addActionListener(actionListener);
		btnInsect.addActionListener(actionListener);
		btnMammal.addActionListener(actionListener);
		btnReptile.addActionListener(actionListener);


		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

	}

	class RadioButtonActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			JRadioButton button = (JRadioButton) event.getSource();

			if (button == btnAquatic) {

				labelImage.setIcon(iconAquatic);
				alexaa.setSize(600,300);
				alexaa.setLocation(650, 200);
				alexaa.setVisible(true);
				

			} else if (button == btnBird) {

				labelImage.setIcon(iconBird);
				JOptionPane.showMessageDialog(null, "hmm1");

			} else if (button == btnInsect) {

				labelImage.setIcon(iconInsect);
				JOptionPane.showMessageDialog(null, "hmm2");

			} else if (button == btnMammal) {

				labelImage.setIcon(iconMammal);
				JOptionPane.showMessageDialog(null, "hmm3");

			} else if (button == btnReptile) {

				labelImage.setIcon(iconReptile);
				JOptionPane.showMessageDialog(null, "hmm4");

			}
		}

	}



}
