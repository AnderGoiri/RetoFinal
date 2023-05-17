package storeMenuGUI;

import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
import javax.swing.ImageIcon;

public class MemberRepairPanel extends JPanel implements KeyListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textFieldIntroduceReason;
	private JButton btnSend;
	private JLabel lblAdvice;

	/**
	 * Create the panel.
	 */
	public MemberRepairPanel() {
		setBounds(0, 0, 1860, 910);
		setLayout(null);

		/**
		 * Creation of the comboBox to select the type of
		 * instrument/component/accessory.
		 */
		JComboBox<String> comboBoxType = new JComboBox<>();
		comboBoxType.setBounds(81, 67, 367, 50);
		comboBoxType.setForeground(new Color(0, 0, 0));
		comboBoxType.setFont(new Font("Constantia", Font.PLAIN, 25));
		comboBoxType.setModel(
				new DefaultComboBoxModel<String>(new String[] { "", "Instrument", "Component", "Accessory" }));
		add(comboBoxType);
		comboBoxType.addKeyListener(this);

		/**
		 * Creation of the textField to enter the reason for the repair.
		 */
		textFieldIntroduceReason = new JTextField();
		textFieldIntroduceReason.setBounds(81, 303, 1374, 387);
		add(textFieldIntroduceReason);
		textFieldIntroduceReason.setColumns(10);
		textFieldIntroduceReason.addKeyListener(this);

		/**
		 * Creation of the "Send" button to send the repair request.
		 */
		btnSend = new JButton("Send");
		btnSend.setVerticalAlignment(SwingConstants.TOP);
		btnSend.setBounds(1270, 724, 185, 76);
		btnSend.setForeground(new Color(255, 255, 255));
		btnSend.setBackground(new Color(0, 151, 178));
		btnSend.setFont(new Font("Onyx", Font.BOLD, 45));
		add(btnSend);
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				UIManager.put("OptionPane.background", new ColorUIResource(255, 255, 255));
				UIManager.put("Panel.background", new ColorUIResource(255, 255, 255));
				UIManager.put("Button.background", new java.awt.Color(0, 151, 178));
				
				JOptionPane.showMessageDialog(null, "Your request has been sent correctly", "Send Message",
						JOptionPane.INFORMATION_MESSAGE);
				
				  /*JOptionPane.showMessageDialog(null,"Your request has been sent correctly");*/
				 
				

			}
		});
		btnSend.addKeyListener(this);

		/**
		 * Creation of the label "Enter the reason of the repair".
		 */
		lblAdvice = new JLabel("Enter the reason of the repair");
		lblAdvice.setBounds(81, 254, 521, 39);
		lblAdvice.setForeground(new Color(0, 0, 0));
		lblAdvice.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(lblAdvice);

		/**
		 * Creation of the comboBox to select the instrument/component/accessory brand.
		 */
		JComboBox<String> comboBoxBrand = new JComboBox<>();
		comboBoxBrand.setBounds(81, 165, 367, 50);
		comboBoxBrand.setFont(new Font("Constantia", Font.PLAIN, 25));
		comboBoxBrand.setModel(new DefaultComboBoxModel<String>(
				new String[] { "", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
		add(comboBoxBrand);
		comboBoxBrand.addKeyListener(this);

		/**
		 * 
		 */
		JLabel lblBrand = new JLabel("Brand:");
		lblBrand.setBounds(81, 125, 521, 39);
		lblBrand.setForeground(new Color(0, 0, 0));
		lblBrand.setFont(new Font("Constantia", Font.PLAIN, 25));
		add(lblBrand);

		/**
		 * 
		 */
		JLabel lblType = new JLabel("Type:");
		lblType.setBounds(81, 27, 521, 39);
		lblType.setForeground(Color.BLACK);
		lblType.setFont(new Font("Constantia", Font.PLAIN, 25));
		add(lblType);

		/**
		 * 
		 */
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(230, 230, 250));
		separator.setForeground(new Color(255, 255, 255));
		separator.setBounds(42, 242, 1460, 1);
		add(separator);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(MemberRepairPanel.class.getResource("/media/descarga.jpg")));
		lblNewLabel.setBounds(0, 0, 1540, 845);
		add(lblNewLabel);
	}

	public void actionPerformed(ActionEvent e) {

		

	}

	public void focusLost(FocusEvent e) {

	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (e.getSource() instanceof JCheckBox) {
				((JCheckBox) e.getSource()).doClick();
			} else if (e.getSource() instanceof JCheckBox) {
				((JCheckBox) e.getSource()).doClick();
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
	

	}

	@Override
	public void keyReleased(KeyEvent e) {
	

	}
}
