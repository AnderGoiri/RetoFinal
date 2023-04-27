package storeMenu;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class MemberAccountPanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	

	/**
	 * Create the panel.
	 */
	public MemberAccountPanel() {
	setLayout(null);
	setBounds(0, 0, 1860, 910);
	
	JScrollPane scrollPane = new JScrollPane();
	scrollPane.setBounds(51, 469, 1437, 314);
	add(scrollPane);
	
	JLabel lblSurmane = new JLabel("Surname:");
	lblSurmane.setFont(new Font("Constantia", Font.PLAIN, 35));
	lblSurmane.setBounds(286, 161, 148, 41);
	add(lblSurmane);
	
	JLabel lblName = new JLabel("Name:");
	lblName.setFont(new Font("Constantia", Font.PLAIN, 35));
	lblName.setBounds(931, 76, 148, 41);
	add(lblName);
	
	JLabel lblUsername = new JLabel("Username:");
	lblUsername.setFont(new Font("Constantia", Font.PLAIN, 35));
	lblUsername.setBounds(286, 76, 192, 41);
	add(lblUsername);
	
	JLabel lblEmail = new JLabel("Email:");
	lblEmail.setFont(new Font("Constantia", Font.PLAIN, 35));
	lblEmail.setBounds(286, 241, 143, 52);
	add(lblEmail);
	
	JLabel lblAddress = new JLabel("Address:");
	lblAddress.setFont(new Font("Constantia", Font.PLAIN, 35));
	lblAddress.setBounds(931, 161, 148, 41);
	add(lblAddress);
	
	JSeparator separator = new JSeparator();
	separator.setBounds(33, 390, 1482, 2);
	add(separator);
	
	JLabel lblPurchase = new JLabel("Your Purchase List");
	lblPurchase.setFont(new Font("Elephant", Font.BOLD, 35));
	lblPurchase.setBounds(51, 426, 417, 41);
	add(lblPurchase);
	
	textField = new JTextField();
	textField.setBounds(460, 72, 457, 52);
	add(textField);
	textField.setColumns(10);
	
	textField_1 = new JTextField();
	textField_1.setColumns(10);
	textField_1.setBounds(460, 157, 457, 52);
	add(textField_1);
	
	textField_2 = new JTextField();
	textField_2.setColumns(10);
	textField_2.setBounds(460, 243, 457, 52);
	add(textField_2);
	
	textField_3 = new JTextField();
	textField_3.setColumns(10);
	textField_3.setBounds(1073, 72, 457, 52);
	add(textField_3);
	
	JButton btnNewButton = new JButton("Edit Profile");
	btnNewButton.setBackground(new Color(0, 151, 178));
	btnNewButton.setForeground(new Color(255, 255, 255));
	btnNewButton.setFont(new Font("Onyx", Font.BOLD, 45));
	btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		}
	});
	btnNewButton.setBounds(51, 203, 180, 49);
	add(btnNewButton);
	
	textField_4 = new JTextField();
	textField_4.setColumns(10);
	textField_4.setBounds(1073, 157, 457, 52);
	add(textField_4);
	
	textField_5 = new JTextField();
	textField_5.setColumns(10);
	textField_5.setBounds(61, 53, 158, 124);
	add(textField_5);
	}

}
