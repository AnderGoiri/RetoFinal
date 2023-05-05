package login;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserRegister extends JPanel implements ActionListener{
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JCheckBox chckbxManager;
	private JCheckBox chckbxTechnician;
	private JCheckBox chckbxNewCheckBox;
	private JLabel lblAddress;
	private JLabel lblCredirCard;
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public UserRegister() {
		setLayout(null);
		JLabel lblUserName = new JLabel("User Name:");
		lblUserName.setBounds(58, 289, 244, 41);
		lblUserName.setFont(new Font("Constantia", Font.PLAIN, 25));
		add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Constantia", Font.PLAIN, 25));
		lblPassword.setBounds(58, 369, 182, 41);
		add(lblPassword);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Constantia", Font.PLAIN, 25));
		lblEmail.setBounds(449, 120, 182, 51);
		add(lblEmail);
		
		lblCredirCard = new JLabel("Credit Card:");
		lblCredirCard.setFont(new Font("Constantia", Font.PLAIN, 25));
		lblCredirCard.setBounds(449, 284, 201, 51);
		add(lblCredirCard);
		
		JLabel lblSurname = new JLabel("Surname:");
		lblSurname.setFont(new Font("Constantia", Font.PLAIN, 25));
		lblSurname.setBounds(58, 210, 244, 41);
		add(lblSurname);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Constantia", Font.PLAIN, 25));
		lblName.setBounds(58, 131, 244, 41);
		add(lblName);
		
		textField = new JTextField();
		textField.setBounds(58, 169, 311, 41);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(58, 249, 311, 41);
		add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(58, 330, 311, 41);
		add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(58, 409, 311, 41);
		add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(449, 248, 311, 41);
		add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(449, 328, 311, 41);
		add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(449, 167, 311, 41);
		add(textField_6);
		
		lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Constantia", Font.PLAIN, 25));
		lblAddress.setBounds(449, 205, 264, 51);
		add(lblAddress);
		
		chckbxManager = new JCheckBox("Manager");
		chckbxManager.setFont(new Font("Constantia", Font.PLAIN, 25));
		chckbxManager.setBounds(58, 76, 244, 41);
		chckbxManager.addActionListener(this);
		add(chckbxManager);
		chckbxManager.setOpaque(false);
		
		JLabel lblName_1_1 = new JLabel("Registration");
		lblName_1_1.setFont(new Font("Elephant", Font.PLAIN, 45));
		lblName_1_1.setBounds(293, 10, 323, 60);
		add(lblName_1_1);
		
		chckbxNewCheckBox = new JCheckBox("Supervisor");
		chckbxNewCheckBox.setFont(new Font("Constantia", Font.PLAIN, 25));
		chckbxNewCheckBox.setEnabled(false);
		chckbxNewCheckBox.setVisible(false);
		chckbxNewCheckBox.setBounds(459, 257, 201, 33);
		add(chckbxNewCheckBox);
		
		chckbxTechnician = new JCheckBox("Technician");
		chckbxTechnician.setFont(new Font("Constantia", Font.PLAIN, 25));
		chckbxTechnician.setEnabled(false);
		chckbxTechnician.setVisible(false);
		chckbxTechnician.setBounds(459, 341, 201, 30);
		add(chckbxTechnician);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(chckbxManager)) {
			if (chckbxManager.isSelected()) {
				chckbxTechnician.setEnabled(true);
				chckbxTechnician.setVisible(true);
				chckbxNewCheckBox.setEnabled(true);
				chckbxNewCheckBox.setVisible(true);
				
				lblAddress.setEnabled(false);
				lblAddress.setVisible(false);
				lblCredirCard.setEnabled(false);
				lblCredirCard.setVisible(false);
				textField_4.setEditable(false);
				textField_4.setVisible(false);
				textField_5.setEnabled(false);
				textField_5.setVisible(false);
			
			}
			else {
				chckbxTechnician.setEnabled(false);
				chckbxTechnician.setVisible(false);
				chckbxNewCheckBox.setEnabled(false);
				chckbxNewCheckBox.setVisible(false);
				
				lblAddress.setEnabled(true);
				lblAddress.setVisible(true);
				lblCredirCard.setEnabled(true);
				lblCredirCard.setVisible(true);
				textField_4.setEditable(true);
				textField_4.setVisible(true);
				textField_5.setEnabled(true);
				textField_5.setVisible(true);
			}
			
		}
		
	}
}
