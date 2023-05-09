package storeMenuGUI;

import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class MemberRepairPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JButton btnSend;
	private JLabel lblAdvice;

	/**
	 * Create the panel.
	 */
	public MemberRepairPanel() {
	setBounds(0, 0, 1860, 910);
	setLayout(null);
	
	/**
	 * Creation of the comboBox to select the type of instrument/component/accessory.
	 */
	JComboBox <String> comboBoxType = new JComboBox<>();
	comboBoxType.setBounds(81, 67, 367, 50);
	comboBoxType.setForeground(new Color(0, 0, 0));
	comboBoxType.setFont(new Font("Constantia", Font.PLAIN, 25));
	comboBoxType.setModel(new DefaultComboBoxModel<String>(new String[] {"", "Instrument", "Component", "Accessory"}));
	add(comboBoxType);
	
	/**
	 * Creation of the textField to enter the reason for the repair.
	 */
	textField = new JTextField();
	textField.setBounds(81, 303, 1374, 387);
	add(textField);
	textField.setColumns(10);
	
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
			JOptionPane.showMessageDialog(null, "Your request has been sent correctly");

		}
	});
	
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
	comboBoxBrand.setModel(new DefaultComboBoxModel<String>(new String[] {"", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
	add(comboBoxBrand);
	
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
		
		// TODO Auto-generated method stub
		
		}
}
