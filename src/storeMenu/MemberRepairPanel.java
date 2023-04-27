package storeMenu;

import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JSeparator;

public class MemberRepairPanel extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public MemberRepairPanel() {
	setLayout(null);
	setBounds(0, 0, 1860, 910);
	
	JComboBox comboBox = new JComboBox();
	comboBox.setBounds(81, 67, 367, 48);
	add(comboBox);
	
	textField = new JTextField();
	textField.setBounds(81, 303, 1357, 387);
	add(textField);
	textField.setColumns(10);
	
	JButton btnNewButton = new JButton("Send");
	btnNewButton.setForeground(new Color(255, 255, 255));
	btnNewButton.setBackground(new Color(0, 151, 178));
	btnNewButton.setFont(new Font("Onyx", Font.BOLD, 45));
	btnNewButton.setBounds(1253, 724, 185, 76);
	add(btnNewButton);
	
	JLabel lblNewLabel = new JLabel("Enter the reason of the repair");
	lblNewLabel.setForeground(new Color(0, 151, 178));
	lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
	lblNewLabel.setBounds(81, 254, 521, 39);
	add(lblNewLabel);
	
	JComboBox comboBox_2 = new JComboBox();
	comboBox_2.setBounds(81, 165, 367, 48);
	add(comboBox_2);
	
	JLabel lblBrand = new JLabel("Brand:");
	lblBrand.setForeground(new Color(0, 0, 0));
	lblBrand.setFont(new Font("Constantia", Font.PLAIN, 25));
	lblBrand.setBounds(81, 125, 521, 39);
	add(lblBrand);
	
	JLabel lblType = new JLabel("Type:");
	lblType.setForeground(Color.BLACK);
	lblType.setFont(new Font("Constantia", Font.PLAIN, 25));
	lblType.setBounds(81, 27, 521, 39);
	add(lblType);
	
	JSeparator separator = new JSeparator();
	separator.setBounds(42, 242, 1448, 2);
	add(separator);
	}
}
